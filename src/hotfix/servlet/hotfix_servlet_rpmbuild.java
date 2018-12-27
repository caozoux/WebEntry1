package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.hitfix_rpminfo_bean;
import hotfix.db.hotfix_hibernate_hotfixrpminfo;
import hotfix.db.hotfix_hibernate_rpmpackage;
import hotfix.db.hotfix_rpmpackage_bean;
import hotfix.db.rpminfo.hotfix_hibernate_functionschange;
import hotfix.db.rpminfo.hotfix_hibernate_functionschange_bean;
import hotifx.db.rpmbuild.hotfix_hibernate_rpmbuild;
import hotifx.db.rpmbuild.hotfix_hibernate_rpmbuild_bean;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server_item;
import hotifx.db.rpmbuild.hotfix_rpmbuild_server_item.build_status;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class hotfix_servlet_rpmbuild
 */
@WebServlet("/hotfix_servlet_rpmbuild")
public class hotfix_servlet_rpmbuild extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_rpmbuild() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String akid;
		String verlist;
		String command;

		command = request.getParameter("command");
		akid = request.getParameter("akid");
		verlist = request.getParameter("verlist");
		System.out.print("hotfix_servlet_rpmbuild command:"+command+" akid:"+akid+" verlist:"+verlist);

        //向前台的页面输出结果
        
        if (akid == null) {
        	response.getWriter().append("akid "+"is null").append(request.getContextPath());
        	return;
        }
        
        hotfix_rpmbuild_server_item builditem = hotfix_rpmbuild_server.getServer(akid, verlist);
        
        build_status status = builditem.checkStatus();
        
		response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        out.println("ture");
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
