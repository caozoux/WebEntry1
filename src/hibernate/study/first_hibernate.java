package hibernate.study;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class first_hibernate {

		   //定义变量
		    Configuration config;
		    SessionFactory sessionFactory;
		    Session session;
		    Transaction transaction;
		    //before表示在方法执行前执行
		    
		    public void setUp()
		    {
		      //1.加载hibernate.cfg.xml配置
		      config=new Configuration().configure();
		      //2.获取SessionFactory
		      sessionFactory=config.buildSessionFactory(); 
		     //3.获得一个session
		      session=sessionFactory.openSession();
		      //4.开始事务
		      transaction=session.beginTransaction();
		    }
		    //添加操作
		    
		    public void insert()
		    {   
		      //5.操作
		     // first_hibernate_custom customer=new first_hibernate_custom();
	
		      first_hibernate_custom customer=new first_hibernate_custom();
		      customer.setId(1);
		      customer.setName("zhangsan");
		      customer.setAge(20);
		      customer.setSex("m");
		      customer.setCity("guangzhou");
		      session.save(customer);
		      //customer.setSname("a1");
		      //customer.setAddress("address1");
		      session.saveOrUpdate(customer);
		    }
		    //删除操作
		    
		     public void delete()
		     {
		        //先查询
		    	 first_hibernate_custom customer=(first_hibernate_custom)session.get(first_hibernate_custom.class, 1);
		        //再删除
		        session.delete(customer);
		     }
		    //查询操作
		   
		    public void select()
		    {
		    	first_hibernate_custom customer=(first_hibernate_custom)session.get(first_hibernate_custom.class, 1);
		        System.out.println(customer);  
		    }
		    //更新操作
		   
		    public void update()
		    {   
		      first_hibernate_custom customer=new first_hibernate_custom();
		      
		      //存在就更新，不存在就执行插入操作
		      session.saveOrUpdate(customer);
		    }
		    //After表示在方法执行结束后执行
		    
		    public void closeTransaction()
		    {
		      //6.提交事务
		      transaction.commit();
		      //7.关闭资源
		      session.close();
		      sessionFactory.close();
		    }
	
}
