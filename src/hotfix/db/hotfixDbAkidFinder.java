package hotfix.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class hotfixDbAkidFinder {
	 // JDBC 驱动名及数据库 URL
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/khotfix_test?useSSL=false";
 
    // 数据库的用户名与密码，需要根据自己的设置
    String USER = "root";
    String PASS = "123456";
    
	Connection conn = null;
    Statement stmt = null;
    
    public List<String> getAllAkid()
    {
    	List<String> str_list = new ArrayList();
    	try {
			String sql;
			sql = "select ak_id from hotfix_akid_info";
			this.connect_bd();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String str  = rs.getString("ak_id");
				str_list.add(str);
			}

			//PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.executeUpdate();
			//ps.close();

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
    	
    	return str_list;
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
}
