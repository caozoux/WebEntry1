package hotfix.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import runtime.exec.execCmd;

/**
 * Servlet implementation class hotfix_servlet_patchmerge
 */
@WebServlet("/hotfix_servlet_patchmerge")
public class hotfix_servlet_patchmerge extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Object lock = new Object(); // static确保只有一把锁  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_servlet_patchmerge() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String runUpdate(String[] kers, String commitid) throws InterruptedException, IOException {  	
    	String kerlist= StringUtils.join(kers, ",");
    	String command2 = "/Users/zoucao-ipc/gitlab/env/hotfix/mergePatchV2.sh -m commit -k "
    				+kerlist+" -i " +commitid+" -w  /Users/zoucao-ipc/gitlab/alitest"; 
    	
    	System.out.println(command2);
    	execCmd cmdcontain = new execCmd();
    	synchronized (lock) {
    		cmdcontain.execCmd(command2);
    	}
    	return cmdcontain.outBuf.toString();
    	//return Runtime.getRuntime().exec(command2).waitFor();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] kers= request.getParameterValues("kervels");
		String commit = request.getParameter("commit");
		String output="";
		System.out.println(kers+" "+commit);
		
		if (kers.length != 0 && commit != "") {
			try {
				output = runUpdate(kers, commit);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.getWriter().append(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
