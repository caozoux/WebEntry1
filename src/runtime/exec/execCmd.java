package runtime.exec;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import hotifx.db.rpmbuild.hotfix_rpmbuild_server_item;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server_item.CmdBuildThread;

public class execCmd {
	public StringBuffer outBuf;
	/* 运行build的线程 */
	public class CmdBuildThread  implements Runnable {  
		String cmd_str;
		StringBuffer output;
		public Process p;
		public int exit_code;
		public CmdBuildThread(String cmd)
		{
			this.cmd_str = cmd;
			this.output= new StringBuffer();
			this.p = null;
			this.exit_code = 1;
		}
		
		public void run() {
			String cmd=this.cmd_str;
	        try {
	             p = Runtime.getRuntime().exec(cmd);
	             p.waitFor();
	             int val = p.exitValue();
	            
	             BufferedReader  reader;
	             if (val == 0) {
	            	 reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
	            	 String line = "";        	 
	            	 while( (line = reader.readLine()) != null) {
	            		 output.append(line + "\n");
	            		 System.out.println(line);
	            	 }
	             } else {
	              	 reader=new BufferedReader(new InputStreamReader(p.getErrorStream()));
	            	 String line = "";
	            	 while( (line = reader.readLine()) != null) {
	            		 output.append(line + "\n");
	            		 System.out.println(line);
	            	 }
	             }            
	        } catch (Exception e) {
	             e.printStackTrace();
	        }
		}
	}
	
	public int execCmd(String cmd) throws InterruptedException {
		CmdBuildThread myThread = new CmdBuildThread(cmd);  
		Thread thread = new Thread(myThread);  
		thread.start(); 
		thread.join();
		outBuf = myThread.output;
		return 0;
	}
}
