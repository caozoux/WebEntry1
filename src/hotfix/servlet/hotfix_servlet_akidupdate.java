package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.hotfixDbAkidOp;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class hotfix_servlet_akidupdate
 */
@WebServlet("/hotfix_servlet_akidupdate")
public class hotfix_servlet_akidupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_akidupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    PrintWriter out = response.getWriter();
	    hotfixDbAkidOp dbop=new hotfixDbAkidOp();

   
		String akid;
		String Aone;
		String desc;
		String author;
		String wiki_link;
		String summary;

		akid = request.getParameter("akid");
		Aone = request.getParameter("Aone");
		desc = request.getParameter("desc");
		author = request.getParameter("author");
		wiki_link = request.getParameter("wiki_link");
		summary = request.getParameter("summary");

		
		dbop.setakid(akid);
		dbop.setsummary(summary);
		dbop.setaone_link(Aone);
		dbop.setdescription(desc);
		dbop.setautor(author);
		dbop.setlink(wiki_link);
		
		System.out.print(dbop.getakid()+dbop.getlink());
		dbop.insert_into_db();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
