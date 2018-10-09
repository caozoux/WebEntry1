package servlet.study.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class frist_ajaxservlet_checkbox
 */
@WebServlet("/frist_ajaxservlet_checkbox")
public class frist_ajaxservlet_checkbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public frist_ajaxservlet_checkbox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        /*String val=request.getParameter("ali2000");
        System.out.print(val);*/
		String[] values = request.getParameterValues("version") ;
		if(values!=null&&values.length>0) {
		     for(int i= 0 ;i<values.length;i++) {
		    	 //out.write(values[i]) ;  
		    	 System.out.println(values[i]);
		     }
		}
		out.write("true") ; 
		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
