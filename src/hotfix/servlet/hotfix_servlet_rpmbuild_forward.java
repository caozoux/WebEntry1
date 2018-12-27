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

import hotifx.db.rpmbuild.hotfix_hibernate_rpmbuild;
import hotifx.db.rpmbuild.hotfix_hibernate_rpmbuild_bean;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server_item;

/**
 * Servlet implementation class hotfix_servlet_rpmbuild_forward
 */
@WebServlet("/hotfix_servlet_rpmbuild_forward")
public class hotfix_servlet_rpmbuild_forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_rpmbuild_forward() {
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
    	hotfix_hibernate_rpmbuild_bean  o_akid;
    	hotfix_rpmbuild_server_item  buiditem = hotfix_rpmbuild_server.getServer(akid, "");
    	
    	if (buiditem == null) {
        	hotfix_hibernate_rpmbuild hiber_rpminfo = hotfix_hibernate_rpmbuild.getFactoryObj();
     		o_akid = hiber_rpminfo.select(akid);
     		if (o_akid == null) {
     			o_akid = new hotfix_hibernate_rpmbuild_bean();
     			o_akid.setAkid(akid);
     			hiber_rpminfo.insert(o_akid);
     		}  		
    	} else {
    		o_akid = buiditem.build_bean;
    	}
    	
 		request.setAttribute("akid_obj", o_akid);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		 
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = null;
	    String akid = request.getParameter("akid");
	    System.out.println(akid);
	    if (akid.isEmpty()) {
			response.getWriter().append("akid: is invalid").append(request.getContextPath());
 			return;
	    }

	    hotfix_akid_set(request, response, akid);
	    rd = sc.getRequestDispatcher("/hotfix/hotfix_rpmbuild.jsp");
 
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
