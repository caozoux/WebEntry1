package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotifx.db.rpmbuild.hotfix_rpmbuild_server;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server_item;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server_item.build_status;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * Servlet implementation class hotfix_servlet_rpmbuild_ajax
 */
@WebServlet("/hotfix_servlet_rpmbuild_ajax")
public class hotfix_servlet_rpmbuild_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int complete = 0;
    public int debug = 0;
    List<String> buildList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_rpmbuild_ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int  hasCompete(PrintWriter out, JSONArray array) {
    	int complete;
    	 JSONObject cpmplete_data=new JSONObject();
    	 debug ++;
    	 if (debug >4) {
    		 complete = 1;
    	 } else {
    		 complete = 0;
    		 	
    	 }
    	 cpmplete_data.put("complete", complete); 
    	 array.add(complete);
    	 
    	 return 0;
    }
    
    public int handlCheck(String akid, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		
		String respone_str = "doing";
		String version_list = "";
    	build_status status;
    	hotfix_rpmbuild_server_item  buiditem = hotfix_rpmbuild_server.getServer(akid, "");
    	
    	if (buiditem == null)
    		return 1;
    	  
    	status = buiditem.checkStatus();
    	
    	if (status == build_status.BUIDING || status == build_status.TESTING 
    			|| status == build_status.CURRENTING) {
    		respone_str = "doing";
    	}
    	
        //json在这里存放的是数组信息
        JSONArray array=new JSONArray();
        PrintWriter out=response.getWriter();
        JSONObject temp1=new JSONObject();
       
        if (status == build_status.BUILT) {
        	List<String> respone_listver = buiditem.getBuildRpmList();
        	for (String str: respone_listver) {
        		version_list += str+" ";
        	}
        	respone_str = "built";
        } else if (status == build_status.TEST)
        	respone_str = "test";
        else if (status == build_status.COMPLETE)
        	respone_str = "complete";
     
           //第一个name和sex
        temp1.put("status", respone_str);
        temp1.put("verlist", version_list);
        //temp1.put("complete", "1");
        //temp1.put("complete", "0");
        //temp1.put("complete", "0");
        array.add(temp1);

 
       //向前台的页面输出结果
 
       out.println(array);
       out.close();
       return 0;
    }
    
    public int handlCommandBuild(String akid, String verlist) {
    	build_status status;
    	hotfix_rpmbuild_server_item  buiditem = hotfix_rpmbuild_server.getServer(akid, verlist);
    	status = buiditem.checkStatus();
    	
    	if (status == build_status.BUIDING || status == build_status.TESTING 
    			|| status == build_status.CURRENTING) {
    		return 1;
    	}
    	
    	buiditem.startBuild();
    	
    	return 0;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String akid;
		String verlist;
		String command;

		command = request.getParameter("command");
		akid = request.getParameter("akid");
		verlist = request.getParameter("verlist");
		System.out.println("hotfix_servlet_rpmbuild: command"+command+" akid:"+akid+" verlist:"+verlist);

		if (command==null) {
			response.getWriter().append("Error ").append(request.getContextPath());
			return;
		}
		
		switch(command) {
			case "build":
				handlCommandBuild(akid, verlist);
				break;
			case "test":
				break;
			case "current":
				break;
			case "check":
				handlCheck(akid, response);
				break;
			default:
				break;
		}

       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
