package servlet.study.bootstraptable;

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
 * Servlet implementation class servlet_bootstraptable
 */
@WebServlet("/servlet_bootstraptable")
public class servlet_bootstraptable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_bootstraptable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		JSONArray jsonData=new JSONArray();
        JSONObject jo=null;
        for (int i=0,len=20;i<len;i++)
        {
        	bootstrap_table_bean tb = new bootstrap_table_bean();
            if(tb==null)
            {
                continue;
            }
            jo=new JSONObject();
            jo.put("id",  i+1);
            jo.put("liushuiid", tb.getLiushuiid());
            jo.put("price", tb.getPrice());
            jo.put("mobilephone", tb.getMobilephone());
            jo.put("receivetime", tb.getReceivetime());
            jo.put("tradetype", tb.getTradetype());
            jo.put("changestatus", tb.getChangestatus());
            jo.put("sendstatus", tb.getSendstatus());
            jo.put("bill_credit", tb.getBill_credit());
            jo.put("goodroadid", tb.getGoodroadid());
            jo.put("SmsContent", tb.getSmsContent());
            jo.put("orderid", tb.getOrderid());
            jo.put("goodsName", tb.getGoodsName());
            jo.put("inneridname", tb.getInneridname());
            jo.put("xmlstr", tb.getXmlstr());
            
            
            jsonData.add(jo);
        }
        int TotalCount=2;
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("rows", jsonData);//JSONArray
        jsonObject.put("total",TotalCount);//总记录数
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString()); 
		out.flush(); 
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
