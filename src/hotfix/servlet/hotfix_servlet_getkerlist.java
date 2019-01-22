package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.config.hotfix_db_config;
import hotfix.db.config.hotfix_hibernate_config_bean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class hotfix_servlet_getkerlist
 */
@WebServlet("/hotfix_servlet_getkerlist")
public class hotfix_servlet_getkerlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_getkerlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		hotfix_db_config config = hotfix_db_config.getFactoryObj();
		List<hotfix_hibernate_config_bean> list = config.selectAll();
		JSONArray array=new JSONArray();

		for(hotfix_hibernate_config_bean bean : list) {
			JSONObject temp1=JSONObject.fromObject(bean);
			array.add(temp1);
		}
		JSONObject respone_json= new JSONObject();
		respone_json.put("total", list.size());
		respone_json.put("rows", array);
		String returndata=respone_json.toString();
		PrintWriter out=response.getWriter();
	    out.println(returndata);
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
