package hotfix.db.config;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hotfix_db_config {

	    //定义变量
	    Configuration config;
	    SessionFactory sessionFactory = null;
	    //Session session;
	    //Transaction transaction;
	    //before表示在方法执行前执行
	    static public hotfix_db_config mFacObj = null;
	    private static Object lock = new Object(); // static确保只有一把锁
	    static public hotfix_db_config getFactoryObj()
	    {
	    	synchronized (lock) {
	    		if (mFacObj==null) {
	    			mFacObj = new  hotfix_db_config();
	    			mFacObj.setUp();
	    		}
	    	}
	    	return mFacObj;
	    }
	    
	    public void setUp()
	    {
	      //1.加载hibernate.cfg.xml配置
	      config=new Configuration().configure("./hotfix/db/config/hotfix_hibernate_config.cfg.xml");
	      sessionFactory=config.buildSessionFactory(); 
	    }
	    //添加操作
	    
	    public void insert(hotfix_hibernate_config_bean item)
	    { 
		    Session session;
		    Transaction transaction;
		    session=sessionFactory.openSession();
		    transaction=session.beginTransaction();
		    //transaction.begin();
	    	session.save(item);
	    	transaction.commit();
	    	session.close();
	    }
	    //删除操作

	     public void delete()
	     {
	        //先查询
	    	 //first_hibernate_custom customer=(first_hibernate_custom)session.get(first_hibernate_custom.class, 1);
	        //再删除
	        //session.delete(customer);
	     }
	 
	   //查询操作
		 public List<hotfix_hibernate_config_bean> selectAll()
		 {
		    	Transaction transaction;
			    Session session;
			    
			    session=sessionFactory.openSession();
			    transaction=session.beginTransaction();
		 
		    	Query q=session.createQuery("from hitfix_rpminfo_bean");
		    	List<hotfix_hibernate_config_bean> list=q.list();
		    	
		    	if (list.isEmpty()) {
		    		transaction.commit();
		    		session.close();
		    		return null;
		    	}
		    		
		    	//System.out.println(list.size());
		    	transaction.commit();
		    	session.close();
		    	return list;
		    }
		    
	    //查询操作
	    public hotfix_hibernate_config_bean  select(String kervel)
	    {
	    	Transaction transaction;
		    Session session;
		    
		    session=sessionFactory.openSession();
		    transaction=session.beginTransaction();
		    hotfix_hibernate_config_bean rpminfo = new hotfix_hibernate_config_bean();
	    	
	    	//transaction.begin();
	  
	    	Query q=session.createQuery("from hotfix_hibernate_config_bean bean where bean.kerver=:name").setParameter("name", kervel);
	    	List<hotfix_hibernate_config_bean> list=q.list();
	    	
	    	if (list.isEmpty()) {
	    		transaction.commit();
	    		session.close();
	    		return null;
	    	}
	    		
	    	//System.out.println(list.size());
	    	transaction.commit();
	    	session.close();
	    	return list.get(0);
	    }
	    //更新操作
	   
	    public void update(hotfix_hibernate_config_bean item)
	    {
		    Session session;
		    Transaction transaction;
		    session=sessionFactory.openSession();
		    transaction=session.beginTransaction();
		    //transaction.begin();
	    	session.update(item);
	    	transaction.commit();
	    	session.close();
	    }
	    //After表示在方法执行结束后执行
	    
	    public void closeTransaction()
	    {
	      //6.提交事务
	      //transaction.commit();
	      //7.关闭资源
	      //session.close();
	      sessionFactory.close();
	    }

}
