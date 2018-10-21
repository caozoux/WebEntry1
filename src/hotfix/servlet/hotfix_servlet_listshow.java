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

import hotfix.db.hotfixDbAkidFinder;

/**
 * Servlet implementation class hotfix_servlet_listshow
 */
@WebServlet("/hotfix_servlet_listshow")
public class hotfix_servlet_listshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_listshow() {
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
		hotfixDbAkidFinder finder = new hotfixDbAkidFinder();
		List<String> list;
		
		response.setContentType("text/html;charset=UTF-8");
		 
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = null;
	    rd = sc.getRequestDispatcher("/hotfix/hotfix_show_list.jsp");
	    list = finder.getAllAkid();
	    if (!list.isEmpty()) {
	    	request.setAttribute("akid_list", list);
	    }
	    
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
