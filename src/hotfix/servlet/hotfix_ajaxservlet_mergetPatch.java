package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONException;

import hotfix.patch.patchMerge;

/**
 * Servlet implementation class hotfix_ajaxservlet_mergetPatch
 */
@WebServlet("/hotfix_ajaxservlet_mergetPatch")
public class hotfix_ajaxservlet_mergetPatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_ajaxservlet_mergetPatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		patchMerge merge=new patchMerge();
		//
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   response.setCharacterEncoding("UTF-8");
        //json在这里存放的是数组信息

       PrintWriter out = response.getWriter();
	   JSONArray array=new JSONArray();
	   String akid;
 
	   akid = request.getParameter("akid");
	   System.out.println(akid);
		String[] values = request.getParameterValues("version") ;
		if(values!=null&&values.length>0) {
		     for(int i= 0 ;i<values.length;i++) {
		    	 int sucess = 0;
		    	 JSONObject temp1=new JSONObject();
		    	 StringBuffer mergeout = merge.mergePatch(values[i], akid);
		    	 sucess = merge.mergeIsPass();
		    	 //out.write(values[i]) ;
		    	 temp1.put("id", String.valueOf(i));
		         temp1.put("version", values[i]);
		         
		         if (sucess == 1)
		        	 temp1.put("status", "ok");
		         else
		        	 temp1.put("status", "failed");
		        	 
		         array.add(temp1);
		    	 System.out.println(values[i]);
		     }
		}

       //向前台的页面输出结果
       out.println(array);
       out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
