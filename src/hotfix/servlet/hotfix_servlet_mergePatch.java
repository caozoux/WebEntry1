package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hotfix_servlet_mergePatch
 */
@WebServlet("/hotfix_servlet_mergePatch")
public class hotfix_servlet_mergePatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_mergePatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        String akid_str = request.getParameter("akid_val") ;
		String[] values = request.getParameterValues("version");
		
		if (akid_str.isEmpty()) {
			return;
		}
		
		if(values!=null&&values.length>0) {
		     for(int i= 0 ;i<values.length;i++)
		    	 out.println(values[i]);  
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
