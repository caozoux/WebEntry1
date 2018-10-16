package mysqljdb.study;
import java.sql.*;
import java.io.IOException;

public class first_mysqljdb {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/khotfix_test";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";
    
	public void connectdb() {
	Connection conn = null;
    Statement stmt = null;
    try{
        // 注册 JDBC 驱动
        Class.forName("com.mysql.jdbc.Driver");
    
        // 打开链接
        System.out.println("连接数据库...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
        // 执行查询
        System.out.println(" 实例化Statement对象...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, ak_id, link FROM hotfix_id_debug";
        ResultSet rs = stmt.executeQuery(sql);
    
        // 展开结果集数据库
        while(rs.next()){
            // 通过字段检索
            int id  = rs.getInt("id");
            String name = rs.getString("ak_id");
            String url = rs.getString("link");

            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", ak_id: " + name);
            System.out.print(", link: " + url);
            System.out.print("\n");
        }
        // 完成后关闭
        rs.close();
        stmt.close();
        conn.close();
    }catch(SQLException se){
        // 处理 JDBC 错误
        se.printStackTrace();
    }catch(Exception e){
        // 处理 Class.forName 错误
        e.printStackTrace();
    }finally{
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
    System.out.println("Goodbye!");
    }

}
