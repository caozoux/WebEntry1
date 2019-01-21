package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.hitfix_rpminfo_bean;
import hotfix.db.hotfix_hibernate_hotfixrpminfo;
import hotfix.db.hotfix_hibernate_rpmpackage;
import hotfix.db.hotfix_rpmpackage_bean;
import hotfix.db.config.hotfix_db_config;
import hotfix.db.config.hotfix_hibernate_config_bean;
import hotfix.env.hotfix_kerver_format;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class hotfix_servlet_getAkidInfoByKervel
 */
@WebServlet("/hotfix_servlet_getAkidInfoByKervel")
public class hotfix_servlet_getAkidInfoByKervel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_getAkidInfoByKervel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("utf-8");
		String kervel = request.getParameter("kervel");
		System.out.println("zz+:"+kervel);
		kervel = hotfix_kerver_format.format(kervel);
		System.out.println("zz+:-"+kervel);
		
		//kervel="ali2010.rc6";
		if (kervel.isEmpty()) {
			response.getWriter().append("error");
			return;
		}
		
		hotfix_hibernate_hotfixrpminfo rpminfo = hotfix_hibernate_hotfixrpminfo.getFactoryObj();
		hotfix_hibernate_rpmpackage config = hotfix_hibernate_rpmpackage.getFactoryObj();
		List<hotfix_rpmpackage_bean> list = config.selectByItem(kervel);
		JSONArray array=new JSONArray();

		for(hotfix_rpmpackage_bean bean : list) {
			JSONObject temp1=JSONObject.fromObject(bean);
			hitfix_rpminfo_bean rpminfo_bean = rpminfo.select(bean.getAkid());
			temp1.put("type", rpminfo_bean.getBusinesslevel());
			temp1.put("link", rpminfo_bean.getLink());
			temp1.put("business", rpminfo_bean.getBusinessitems());
			temp1.put("author", rpminfo_bean.getAuthor());
			temp1.put("desc", rpminfo_bean.getDescription());
			
			array.add(temp1);
		}
		
		System.out.println(array);
		PrintWriter out=response.getWriter();
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
