package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.config.hotfix_db_config;
import hotfix.db.config.hotfix_hibernate_config_bean;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class hotfix_servlet_mangeUpdate_ajax
 */
@WebServlet("/hotfix_servlet_mangeUpdate_ajax")
public class hotfix_servlet_mangeUpdate_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_mangeUpdate_ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    request.setCharacterEncoding("utf-8");
	   
		hotfix_hibernate_config_bean bean;
		
		String jsonStr = request.getParameter("json");
		JSONObject json = JSONObject.fromObject(jsonStr);
		System.out.println("log"+json.getString("kerver"));
		String kerver = json.getString("kerver");
		String desc = json.getString("desc");		
		
		hotfix_db_config fac = hotfix_db_config.getFactoryObj();
		bean = fac.select(kerver);
		if (bean == null) {
			bean = new hotfix_hibernate_config_bean();
			bean.setKerver(kerver);
			bean.setKerdesc(desc);
			fac.insert(bean);
		} else  {
			bean.setKerver(kerver);
			bean.setKerdesc(desc);
			fac.update(bean);
		}
		
		 response.setContentType("application/x-json");//需要设置ContentType 为"application/x-json" 
		 PrintWriter out = response.getWriter(); 
		 
		 //out.println("okay");//向客户端输出JSONObject字符串 
		 out.println("{\"status\":\"okay\"}");
		 out.flush(); 
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
