package hotfix.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotifx.db.rpmbuild.hotfix_rpmbuild_server;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server_item;

/**
 * Servlet implementation class hotfix_servlet_getBuildLog
 */
@WebServlet("/hotfix_servlet_getBuildLog")
public class hotfix_servlet_getBuildLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_getBuildLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String akid;
		
		akid = request.getParameter("akid");
		System.out.println("hotfix_servlet_getBuildLog "+akid);
		if (akid.isEmpty()) {
			response.getWriter().append("args error");
			return;
		}
		hotfix_rpmbuild_server_item  buiditem = hotfix_rpmbuild_server.getServer(akid, "");
		response.getWriter().append(buiditem.getBuildlog());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
