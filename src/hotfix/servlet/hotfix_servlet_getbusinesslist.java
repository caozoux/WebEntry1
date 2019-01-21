package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.business.hotfix_db_business;
import hotfix.db.business.hotfix_db_business_bean;
import hotfix.db.config.hotfix_db_config;
import hotfix.db.config.hotfix_hibernate_config_bean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class hotfix_servlet_getbusinesslist
 */
@WebServlet("/hotfix_servlet_getbusinesslist")
public class hotfix_servlet_getbusinesslist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_getbusinesslist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("utf-8");
		hotfix_db_business config = hotfix_db_business.getFactoryObj();
		List<hotfix_db_business_bean> list = config.selectAll();
		JSONArray array=new JSONArray();

		for(hotfix_db_business_bean bean : list) {
			JSONObject temp1=JSONObject.fromObject(bean);
			array.add(temp1);
		}
		JSONObject respone_json= new JSONObject();
		respone_json.put("total", list.size());
		respone_json.put("rows", array);
		System.out.println(array);
		PrintWriter out=response.getWriter();
	    out.println(respone_json);
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
