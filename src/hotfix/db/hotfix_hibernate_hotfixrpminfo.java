package hotfix.db;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import hibernate.study.first_hibernate_custom;

public class hotfix_hibernate_hotfixrpminfo {

	    //定义变量
	    Configuration config;
	    SessionFactory sessionFactory = null;
	    //Session session;
	    //Transaction transaction;
	    //before表示在方法执行前执行
	    static public hotfix_hibernate_hotfixrpminfo mFacObj;
	    static public hotfix_hibernate_hotfixrpminfo getFactoryObj()
	    {
	    	if (mFacObj==null) {
	    		mFacObj = new  hotfix_hibernate_hotfixrpminfo();
	    		mFacObj.setUp();
	    	}
	    	return mFacObj;
	    }
	    
	    public void setUp()
	    {
	      //1.加载hibernate.cfg.xml配置
	      config=new Configuration().configure("./hotfix/db/hotfix_hibernate.cfg2.xml");
	      //config=new Configuration().configure("./hotfix/db/hotfix_test.cfg2.xml");
	      //2.获取SessionFactory
	      sessionFactory=config.buildSessionFactory(); 
	     //3.获得一个session
	      //session=sessionFactory.openSession();
	      //session=sessionFactory.getCurrentSession();
	      //4.开始事务
	      //transaction=session.beginTransaction();
	      System.out.print("setup");
	    }
	    //添加操作
	    
	    public void insert(hitfix_rpminfo_bean item)
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
	    public hitfix_rpminfo_bean select(String akid)
	    {
	    	
	    	//hitfix_rpminfo_bean u=(hitfix_rpminfo_bean)session.load(hitfix_rpminfo_bean.class, 7);
	    	//System.out.println(u);
	    	
	    	//Query q=session.createQuery("from hitfix_rpminfo_bean");
	    	//List<hitfix_rpminfo_bean> list=q.list();
	    	//System.out.println(list.size());
	    	Transaction transaction;
		    Session session;
		    
		    session=sessionFactory.openSession();
		    transaction=session.beginTransaction();
	    	hitfix_rpminfo_bean rpminfo = new hitfix_rpminfo_bean();
	    	
	    	//transaction.begin();
	    	System.out.print(akid);
	    	Query q=session.createQuery("from hitfix_rpminfo_bean rpminfo where rpminfo.akid=:name").setParameter("name", akid);
	    	List<hitfix_rpminfo_bean> list=q.list();
	    	
	    	if (list.isEmpty()) {
	    		transaction.commit();
	    		session.close();
	    		return null;
	    	}
	    		
	    	//System.out.println(list.size());
	    	transaction.commit();
	    	session.close();
	    	return rpminfo;
	    }
	    //更新操作
	   
	    public void update()
	    {   
	      //first_hibernate_custom customer=new first_hibernate_custom(); 
	      //存在就更新，不存在就执行插入操作
	      //session.saveOrUpdate(customer);
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
