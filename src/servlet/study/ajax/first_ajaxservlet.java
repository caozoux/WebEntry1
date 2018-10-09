package servlet.study.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class first_ajaxservlet
 */
@WebServlet("/first_ajaxservlet")
public class first_ajaxservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public first_ajaxservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	PrintWriter out = response.getWriter();
	        
	        String name = request.getParameter("name");
	        String pwd = request.getParameter("pwd");
	        System.out.println("name="+name+" pwd="+pwd);
	        if(name.equals("admin") && pwd.equals("123456")){
	            try {
	                out.write("true");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }finally{
	                out.close();
	            }
	        }else{
	            try {
	                out.write("false");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }finally{
	                out.close();
	            }
	        }
	}

}
