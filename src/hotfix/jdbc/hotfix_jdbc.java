package hotfix.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


public class hotfix_jdbc {
	public Connection conn = null;
	public Statement stmt = null;
	// 不同的数据库有不同的驱动
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/khotfix_test?useSSL=false";
    // 数据库的用户名与密码，需要根据自己的设置
	String user = "root";
	String password = "123456";
	
	public void init() {

		try {
			// 加载驱动
			Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, user, password);
	            // 开始连接数据库
	            System.out.println("数据库连接成功..");
	      } catch (ClassNotFoundException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	      } catch (SQLException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	      }
	}
	
	public List<String> selectString(String item, String table) throws SQLException {
		List<String> list = new ArrayList<String>();
		String sqlString = "select "+item+" from "+table;
    	try {

			//this.connect_bd();
			ResultSet rs = stmt.executeQuery(sqlString);
			while(rs.next()) {
				//String str  = rs.getString("ak_id");
				String str  = rs.getString(item);
				list.add(str);
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
    	
    	return list;
	}

    /*链接DB*/
	private void connect_bd() throws SQLException, ClassNotFoundException
	{
		// 注册 JDBC 驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 打开链接
		conn = DriverManager.getConnection(DB_URL,user, password);
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
            if(conn!=null) 
            	conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
	}
}
