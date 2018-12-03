package hotfix.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotfix.db.hitfix_rpminfo_bean;
import hotfix.db.hotfixDbAkidOp;
import hotfix.db.hotfix_hibernate_hotfixrpminfo;
import hotfix.db.rpminfo.hotfix_hibernate_functionschange;
import hotfix.db.rpminfo.hotfix_hibernate_functionschange_bean;

/**
 * Servlet implementation class hotfix_db_akid_show_update
 */
@WebServlet("/hotfix_db_akid_show_update")
public class hotfix_db_akid_show_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotfix_db_akid_show_update() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int hoitfix_item_update_simple(String key, String val) {
    
    	return 0;
    }
    
    public int hoitfix_item_update_multp() {
    	return 0;
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
	 	PrintWriter out = response.getWriter();
	 	String akid_str;
	 	Map<String, String[]> mapstr = request.getParameterMap();
	 	Iterator<Map.Entry<String, String[]>> it = mapstr.entrySet().iterator();
	 	akid_str=mapstr.get("akid")[0];
	 	
	 	/*hotfixDbAkidOp o_akid= new hotfixDbAkidOp();
	 	o_akid.setakid(akid_str);
	 	o_akid.get_akid_info(akid_str);
		*/


 		hotfix_hibernate_hotfixrpminfo hiber_rpminfo = hotfix_hibernate_hotfixrpminfo.getFactoryObj();
 		hitfix_rpminfo_bean o_akid;
 		o_akid=hiber_rpminfo.select(akid_str);
 		if (o_akid == null) {
 			response.getWriter().append("akid: "+akid_str+" isn't exist.").append(request.getContextPath());
 			return;
 		} 	

	 	while (it.hasNext()) {
	 		Map.Entry<String, String[]> entry = it.next(); 
	 		String key = entry.getKey();
	 		String[] value = entry.getValue();
	 		System.out.println("key= " + key+ " and value= " + value[0]); 
	 		switch(key) {
	 			case "link":
	 				o_akid.setLink(value[0]);
	 				break;
	 			case "description":
	 				o_akid.setDescription(value[0]);
	 				break;
	 			case "author":
	 				o_akid.setAuthor(value[0]);
	 				break;
	 			case "functest":
	 				o_akid.setFunctest(value[0]);
	 				break;
	 			case "patchlink":
	 				o_akid.setPatchlink(value[0]);
	 				break;	
	 			case "aone_link":
	 				o_akid.setAonelink(value[0]);
	 				break;	
	 			case "functionschange":
	 				String[] str = value[0].split("\n");
	 				hotfix_hibernate_functionschange hiber_rpminfo_functionchane = hotfix_hibernate_functionschange.getFactoryObj();
	 				hiber_rpminfo_functionchane.updateByAkid(akid_str, str);
	 				break;
	 			default:
	 				break;
	 		}
	 		
	 		hiber_rpminfo.update(o_akid);
	 		//hiber_rpminfo.insert(o_akid);
	 		//o_akid.insert_into_db();
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
