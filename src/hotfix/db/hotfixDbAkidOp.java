package hotfix.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class hotfixDbAkidOp {
	
	 // JDBC 驱动名及数据库 URL
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/khotfix_test";
 
    // 数据库的用户名与密码，需要根据自己的设置
    String USER = "root";
    String PASS = "123456";
    
	Connection conn = null;
    Statement stmt = null;
    
    
	String akid;
	String link;
	String autor;
	String summary;
	String description;
	String aone_link;
	// 1 通用必选， 2 通用可选， 非通用
	String target;
	String mode;
	String patch_link;
	String functest;
	
	List<hotfixRpmInfo> RpmList;
	List<hotfixChangeFunc> funcList;
	
	public hotfixDbAkidOp(String akid_val)
	{
		
	}
	
	private void disconnect_bd()
	{
        // 关闭资源
        try{
            if(stmt!=null) stmt.close();
        }catch(SQLException se2){
        }// 什么都不做
        try{
            if(conn!=null) conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
	}
	
	/*链接DB*/
	private void connect_bd() throws SQLException, ClassNotFoundException
	{	    

		// 注册 JDBC 驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
    
		// 打开链接
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();

	}
	
	public int insert_into_db()
	{
		if(this.getakid().isEmpty() || this.getlink().isEmpty()) {
			System.out.print("akid or link is null");
			return 0;
		}
		
		try {
			String sql;
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);
			sql = "INSERT INTO hotfix_akid_info (ak_id, link, submission_date,summary,description,author,functest,patchlink) "
					+ "VALUES(?,?,?,?,?,?,?,?)";
			//sql = "INSERT INTO hotfix_akid_info (ak_id,link) values(?,?)";
			this.connect_bd();


			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,this.getakid());
			ps.setString(2,this.getlink());
			ps.setString(3,dateString);
			ps.setString(4,this.getsummary());
			ps.setString(5,this.getdescription());
			ps.setString(6,this.getautor());
			ps.setString(7,this.getfunctest());
			ps.setString(8,this.getpatch_link());
			
			ps.executeUpdate();
			ps.close();

			this.disconnect_bd();
		}catch(SQLException se){
	        // 处理 JDBC 错误
	        se.printStackTrace();
	    }catch(Exception e){
	        // 处理 Class.forName 错误
	        e.printStackTrace();
	    }finally{
	    	disconnect_bd();
	    }
		return 0;
	}
	
	public void get_akid_info(String akid_val)
	{
        int id;
        String name;
        String url;

	    try{
	    	
	        String sql;
	        connect_bd();
	        
	        sql = "SELECT id, ak_id, link FROM hotfix_id_debug where ak_id='"+akid_val+"'";
	        ResultSet rs = stmt.executeQuery(sql);
	    
	        if (rs.first()) {
	            id  = rs.getInt("id");
	            name = rs.getString("ak_id");
	            url = rs.getString("link");
	            this.setlink(url);
	            System.out.print(id+name+url);
	            
	        } else {
	        	System.out.println("find failed"+akid_val);
	        }
	        
	        rs.close();
	        disconnect_bd();
	    }catch(SQLException se){
	        // 处理 JDBC 错误
	        se.printStackTrace();
	    }catch(Exception e){
	        // 处理 Class.forName 错误
	        e.printStackTrace();
	    }finally{
	    	disconnect_bd();
	    }
	}
	
	
	public hotfixDbAkidOp()
	{
		
	}
	
	public void setsummary(String val)
	{
		summary=val;
	}
	
	public String getsummary()
	{
		return summary;
	}
	
	public void setfunctest(String val)
	{
		functest=val;
	}
	
	public String getfunctest()
	{
		return functest;
	}
	public void setakid(String val)
	{
		akid=val;
	}
	
	public String getakid()
	{
		return akid;
	}
	
	public void setlink(String val)
	{
		link=val;
	}
	
	public String getlink()
	{
		return link;
	}
	
	public void setautor(String val)
	{
		autor=val;
	}
	
	public String getautor()
	{
		return autor;
	}
	public void setdescription(String val)
	{
		description=val;
	}
	
	public String getdescription()
	{
		return description;
	}
	public void setaone_link(String val)
	{
		aone_link=val;
	}
	
	public String getaone_link()
	{
		return aone_link;
	}
	public void setmode(String val)
	{
		mode=val;
	}
	
	public String getmode()
	{
		return mode;
	}
	public void setpatch_link(String val)
	{
		patch_link=val;
	}
	
	public String getpatch_link()
	{
		return patch_link;
	}
}
