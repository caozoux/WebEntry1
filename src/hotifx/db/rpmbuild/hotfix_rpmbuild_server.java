package hotifx.db.rpmbuild;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class hotfix_rpmbuild_server {
	static public hotfix_rpmbuild_server worklist = null;

	public Map<String,hotfix_rpmbuild_server_item> map;
	
	
	public hotfix_rpmbuild_server() {
		this.map = new HashMap<String,hotfix_rpmbuild_server_item>();
	}
	
	static public hotfix_rpmbuild_server_item  getServer(String akid, String verlist)
	{
		if (worklist == null) 
			worklist = new hotfix_rpmbuild_server();
		 System.out.println(worklist.map);
		 if (!worklist.map.isEmpty()) {
			 if (worklist.map.containsKey(akid))
				 return worklist.map.get(akid);
		 }

	     List<String> list = Arrays.asList(verlist.split(","));
		 hotfix_rpmbuild_server_item item = worklist.createBuildItem(akid,list);
		 return item;
	}
	
	public hotfix_rpmbuild_server_item createBuildItem(String akid, List<String> verlist)
	{
		 hotfix_rpmbuild_server_item item = new hotfix_rpmbuild_server_item(akid, 0, verlist );
		 worklist.map.put(akid, item);
		 return item;
	}
	
	/*
	 * 查询后台是否完成编译
	 * 1:完成
	 * 0:未开始
	 * 2: 运行中
	 * 3: 失败
	 */
	public int checkStatus(String akid) {
		return 1;
	}
	
	/*
	 * 后台开始编译
	 */
	public void runbuild(String akid) {
		//Iterator iterator = map.entrySet().iterator();
		for (hotfix_rpmbuild_server_item iterator : map.values()) {
			//iterator.checkStatus();
		}
	}
}
