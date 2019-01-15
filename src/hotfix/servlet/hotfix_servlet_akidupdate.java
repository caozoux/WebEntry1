package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.hitfix_rpminfo_bean;
import hotfix.db.hotfixDbAkidOp;
import hotfix.db.hotfix_hibernate_hotfixrpminfo;
import hotfix.db.hotfix_test_bean;
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
	    
		String akid;
		String Aone;
		String desc;
		String author;
		String wiki_link;
		String summary;

		akid = request.getParameter("akid");
		Aone = request.getParameter("aone");
		desc = request.getParameter("description");
		author = request.getParameter("author");
		wiki_link = request.getParameter("wiki_link");
		summary = request.getParameter("summary");

	
	 	hitfix_rpminfo_bean o_akid;

 		hotfix_hibernate_hotfixrpminfo hiber_rpminfo = hotfix_hibernate_hotfixrpminfo.getFactoryObj();

 		o_akid=hiber_rpminfo.select(akid);
 		if (o_akid == null) {
 			o_akid= new hitfix_rpminfo_bean();
 			o_akid.setAkid(akid);
 			o_akid.setAonelink(Aone);
 			o_akid.setDescription(desc);
 			o_akid.setAuthor(author);
 			o_akid.setLink(wiki_link);
 			o_akid.setSummary(summary);
 			hiber_rpminfo.insert(o_akid);
 			response.sendRedirect("hotfix_servlet_listshow");
 		} else {
 			response.getWriter().append("akid "+akid+" is exist").append(request.getContextPath());
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
