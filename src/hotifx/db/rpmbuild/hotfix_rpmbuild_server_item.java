package hotifx.db.rpmbuild;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import hotifx.db.rpmbuild.hotfix_rpmbuild_build_socket.enumBuildState;


public class hotfix_rpmbuild_server_item {
	
	public String akid;
	public List<String> kernellist;
	public List<String> rpmllist;
	public int kerneltype;
	public build_status status;
	public hotfix_hibernate_rpmbuild_bean build_bean; //记录hotfix build的目录

	/*
	 * kernel version, hotfix_signal_kernel_build
	 */
	public Map<String,hotfix_signal_kernel_build> buildMap;
	
	
	public hotfix_rpmbuild_server_item(String akid, int kerneltype, List<String> list) {
		this.akid = akid;
		this.kerneltype = kerneltype;
		this.kernellist = list;
		this.rpmllist = new ArrayList<String>();
		this.status = build_status.INIT_STATUS;
		hotfix_hibernate_rpmbuild hibernate_rpmbuild = hotfix_hibernate_rpmbuild.getFactoryObj();
		build_bean = hibernate_rpmbuild.select(akid);

		if (build_bean == null) {
			hotfix_hibernate_rpmbuild_bean  bean = new hotfix_hibernate_rpmbuild_bean();
			bean.setAkid(this.akid);
			hibernate_rpmbuild.insert(bean);
			build_bean = hibernate_rpmbuild.select(akid);
		}
	}
	
	public enum build_status {
		INIT_STATUS, //初始状态
		BUIDING,     //打包中
		BUILT,       //完成打包
		TESTING,     //转测试包
		TEST,        //完成测试
		CURRENTING,  //转正式包中
		COMPLETE,    //完成
		BUIDINGERR,
		TESTINGERR,
		CURRENTINGERR
	};
	
	
	/* 运行build的线程 */
	public class CmdBuildThread  implements Runnable {  
		hotfix_rpmbuild_server_item builditem;
		
		public CmdBuildThread(hotfix_rpmbuild_server_item item)
		{
			this.builditem = item;
		}

		private int SendBuildKernel(String kerstr) {
			enumBuildState state;
			hotfix_rpmbuild_build_socket build_socket =
					new hotfix_rpmbuild_build_socket(kerstr);
			try {
				int ret = 1;
				build_socket.connect();
				build_socket.sendBuildCmd(builditem.akid, kerstr);

				do {
					state = build_socket.waitBuildCmd();
					Thread.sleep(5000);
				} while (state == enumBuildState.BUILDLOG);
				
				build_socket.closed();
				if (state == enumBuildState.BUILDSUC) {
					String rpmlist = build_socket.rpmlist;
					builditem.rpmllist.add(rpmlist);
					return 0;
				}
				return 1;

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 1;
		}
		public void run() {
			int ret = 0;
		
			if (builditem.kernellist.size() == 0)
				ret = SendBuildKernel("");
			else 
				for (String kerstr : builditem.kernellist) {
					ret = SendBuildKernel(kerstr);
					if (ret != 0)
						break;
				}
			
			if (ret == 0) {
				
				builditem.CompleteBuild();
			} else {
				CompleteBuildFailed();
			}
			
		
			System.out.println("CmdBuildThread.run()"); 
			/*while(i++<10) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			builditem.CompleteBuild();
			*/
		}
	}
	
	/* 运行test的线程 */
	public class CmdTestThread  implements Runnable {  
		hotfix_rpmbuild_server_item builditem;
		public CmdTestThread(hotfix_rpmbuild_server_item item)
		{
			this.builditem = item;
		}
		public void run() {  
			int i=0;
			System.out.println("CmdTestThread.run()");  
			while(i++<10) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//Auto-generated catch block
					e.printStackTrace();
				}
			}
			builditem.CompleteTest();
		}  
	}	
	
	/* 运行current的线程 */
	public class CmdCurrentThread  implements Runnable {  
		hotfix_rpmbuild_server_item builditem;
		public CmdCurrentThread(hotfix_rpmbuild_server_item item)
		{
			this.builditem = item;
		}
		public void run() {  
			System.out.println("CmdCurrentThread.run()"); 
			builditem.CompleteCurrent();
		}  
	}	
	
	public class hotfix_signal_kernel_build {
		public int compelet;
		public int kerneltype;
		public String rpmLink;
		public String kernelVersion;
		
		public hotfix_signal_kernel_build(String kernelVersion, int kerneltype) {
			this.kernelVersion = kernelVersion;
			this.kerneltype = kerneltype;
		}
	}
	
	private void createBuildMap() {
		Iterator<String> iter = kernellist.iterator();
		while(iter.hasNext()){
			buildMap.put(iter.next(), new hotfix_signal_kernel_build(iter.next(), kerneltype));
		}
	}
	
	public build_status checkStatus() {
		return this.status;
	}
	
	/*
	 * 返回已经编译完成的rpmList
	 */
	public List<String> getBuildRpmList()
	{
		return this.rpmllist;
	}
	
	public void startBuild(String kervlist) {
		System.out.println("startBuild");
		this.kernellist = Arrays.asList(kervlist.split(","));
		this.status = build_status.BUIDING;
		this.build_bean.status =  this.status.ordinal();
		this.build_bean.setVersionlist(kervlist);
		this.rpmllist.clear();
		hotfix_hibernate_rpmbuild hibernate_rpmbuild = hotfix_hibernate_rpmbuild.getFactoryObj();
		hibernate_rpmbuild.update(this.build_bean);
		
		CmdBuildThread myThread = new CmdBuildThread(this);  
		Thread thread = new Thread(myThread);  
		thread.start();  
	}
	private  void CompleteBuildFailed() {
		this.status = build_status.BUIDINGERR;
		this.build_bean.setStatus(this.status.ordinal());
		this.build_bean.setVersionlist("");
		hotfix_hibernate_rpmbuild hibernate_rpmbuild = hotfix_hibernate_rpmbuild.getFactoryObj();
		hibernate_rpmbuild.update(this.build_bean);
		System.out.println("CompleteBuildFailed");
	}
	private  void CompleteBuild() {
		this.status = build_status.BUILT;
		this.build_bean.setStatus(this.status.ordinal());
		List<String> list = this.getBuildRpmList();
		String verlist = StringUtils.join(list.toArray(), ",");
		this.build_bean.setVersionlist(verlist);
		hotfix_hibernate_rpmbuild hibernate_rpmbuild = hotfix_hibernate_rpmbuild.getFactoryObj();
		hibernate_rpmbuild.update(this.build_bean);
		System.out.println("CompleteBuild");
	}
	
	public void startTest() {
		this.status = build_status.TESTING;
		this.build_bean.status =  this.status.ordinal();
		CmdTestThread myThread = new CmdTestThread(this);  
		Thread thread = new Thread(myThread);  
		thread.start(); 
	}

	private void CompleteTest() {
		this.status = build_status.TEST;
		this.build_bean.status =  this.status.ordinal();
		System.out.println("CompleteTest");
	}
	
	public void startCurrent() {
		this.status = build_status.CURRENTING;
		this.build_bean.status =  this.status.ordinal();
		CmdCurrentThread myThread = new CmdCurrentThread(this);  
		Thread thread = new Thread(myThread);  
		thread.start();
	}

	private void CompleteCurrent() {
		this.status = build_status.COMPLETE;
		this.build_bean.status =  this.status.ordinal();
		System.out.println("CompleteCurrent");
	}
	
	private void runTestCmd(String args) {
		
	}
	
	private void runCurrentCmd(String args) {
		
	}
	
	private void runBuildCmd(String args) {
		Runtime runtime = Runtime.getRuntime();
		Process process;
		BufferedReader br = null;
		BufferedWriter wr = null;
		try {
		    process = runtime.exec(args);
		    
		    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		    //wr = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

		    String inline;
		    while ((inline = br.readLine()) != null) {
		        if (!inline.equals(""))
		            inline = inline.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		    }
		    br.close();
		    //br = new BufferedReader(new InputStreamReader(process.getErrorStream()));    //错误信息
		    //while ((inline = br.readLine()) != null) {
		     
		   // }
		} catch (Exception e) {
		  
		} finally {    
		}
	}
}
