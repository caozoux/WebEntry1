package servlet.study.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * Servlet implementation class first_ajaxservlet_json
 */
@WebServlet("/first_ajaxservlet_json")
public class first_ajaxservlet_json extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public first_ajaxservlet_json() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
         //json在这里存放的是数组信息
        JSONObject json=new JSONObject();
        JSONArray array=new JSONArray();

        //两个数据
        JSONObject temp1=new JSONObject();
        JSONObject temp2=new JSONObject();
        
        try {
            //第一个name和sex
            temp1.put("id", 1);
            temp1.put("name", "张三");
            temp1.put("age", "23");
            array.add(temp1);

            //第二个name和sex
            temp2.put("id", 2);
            temp2.put("name", "李四");
            temp2.put("age", "33");
            array.add(temp2);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //向前台的页面输出结果
        PrintWriter out=response.getWriter();
        out.println(array);
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
