package hotfix.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.hotfixDbAkidOp;

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

    public void hotfix_akid_set(HttpServletRequest request) {
    	hotfixDbAkidOp o_akid= new hotfixDbAkidOp();
    	o_akid.setakid("D12345");
    	o_akid.setlink("www.baidu.com");
    	request.setAttribute("akid_obj", o_akid);
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
	    rd = sc.getRequestDispatcher("/hotfix/hotfix_show_template.jsp");
	    request.setAttribute("testval", "1");
	    hotfix_akid_set(request);
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
