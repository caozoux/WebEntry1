package hotfix.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.hitfix_rpminfo_bean;
import hotfix.db.hotfixDbAkidOp;
import hotfix.db.hotfix_hibernate_hotfixrpminfo;
import hotfix.db.hotfix_hibernate_rpmpackage;
import hotfix.db.hotfix_rpmpackage_bean;

/**
 * Servlet implementation class hotfix_akid_show
 */
@WebServlet("/hotfix_akid_show")
public class hotfix_akid_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_akid_show() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void hotfix_akid_set(HttpServletRequest request,  HttpServletResponse response, String akid) 
    		throws ServletException, IOException {
    	/*
    	hotfixDbAkidOp o_akid= new hotfixDbAkidOp();
    	o_akid.setakid("D728868");
    	//o_akid.setlink("www.baidu.com");
    	o_akid.get_akid_info("D728868");
    	request.setAttribute("akid_obj", o_akid);
    	*/
 		hotfix_hibernate_hotfixrpminfo hiber_rpminfo = hotfix_hibernate_hotfixrpminfo.getFactoryObj();
 		hitfix_rpminfo_bean o_akid;
 		o_akid=hiber_rpminfo.select(akid);
 		if (o_akid == null) {
 			response.getWriter().append("akid: "+akid+" isn't exist.").append(request.getContextPath());
 			return;
 		}
 		o_akid=hiber_rpminfo.select(akid);
 		request.setAttribute("akid_obj", o_akid);
 		
 		List<hotfix_rpmpackage_bean> rpmpackage_list;
 		hotfix_hibernate_rpmpackage hiber_rpmpackager =  hotfix_hibernate_rpmpackage.getFactoryObj();
 		rpmpackage_list = hiber_rpmpackager.select(akid);
 		
 		request.setAttribute("rpmpackage_list", rpmpackage_list);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		 
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = null;
	    String akid = request.getParameter("akid");
	    
	    if (akid.isEmpty()) {
			response.getWriter().append("akid: is invalid").append(request.getContextPath());
 			return;
	    }
	    rd = sc.getRequestDispatcher("/hotfix/hotfix_show_template.jsp");
	    request.setAttribute("testval", "1");
	    hotfix_akid_set(request,response,akid);
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
