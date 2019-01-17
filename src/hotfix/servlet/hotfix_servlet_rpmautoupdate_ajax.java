package hotfix.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hotfix_servlet_rpmautoupdate_ajax
 */
@WebServlet("/hotfix_servlet_rpmautoupdate_ajax")
public class hotfix_servlet_rpmautoupdate_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_rpmautoupdate_ajax() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void runUpdate(String akid) throws InterruptedException, IOException {
    	System.out.println("update now+\n");
    	String command2 = "/usr/bin/python2.7 /Users/zoucao-ipc/github/shell/mysql/rpmfind.py"+" -a " + akid; 
        Runtime.getRuntime().exec(command2).waitFor();
        System.out.println("update now-\n");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String akid = request.getParameter("akid");
		if (akid != null) {
			try {
				runUpdate(akid);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
