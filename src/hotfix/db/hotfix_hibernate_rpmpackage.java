package hotfix.db;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class hotfix_hibernate_rpmpackage {

	    //定义变量
	    Configuration config;
	    SessionFactory sessionFactory = null;
	    //Session session;
	    //Transaction transaction;
	    //before表示在方法执行前执行
	    static public hotfix_hibernate_rpmpackage mFacObj;
	    static public hotfix_hibernate_rpmpackage getFactoryObj()
	    {
	    	if (mFacObj==null) {
	    		mFacObj = new  hotfix_hibernate_rpmpackage();
	    		mFacObj.setUp();
	    	}
	    	return mFacObj;
	    }
	    
	    public void setUp()
	    {
	      //1.加载hibernate.cfg.xml配置
	      config=new Configuration().configure("./hotfix/db/hotfix_hibernate_rpmpackage.cfg.xml");
	      sessionFactory=config.buildSessionFactory(); 
	    }
	    //添加操作
	    
	    public void insert(hotfix_rpmpackage_bean item)
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
		 public List<hotfix_rpmpackage_bean> selectAll()
		 {
		    	Transaction transaction;
			    Session session;
			    
			    session=sessionFactory.openSession();
			    transaction=session.beginTransaction();
		 
		    	Query q=session.createQuery("from hitfix_rpminfo_bean");
		    	List<hotfix_rpmpackage_bean> list=q.list();
		    	
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
		    public List<hotfix_rpmpackage_bean>  selectByItem(String item)
		    {
		    	
		    	Transaction transaction;
			    Session session;
			    
			    session=sessionFactory.openSession();
			    transaction=session.beginTransaction();
			    Criteria criteria = session.createCriteria(hotfix_rpmpackage_bean.class);   
			    criteria.add(Restrictions.eq("kernel", item));
		    	//transaction.begin();
		    	System.out.print(item);
		    	List<hotfix_rpmpackage_bean> list=criteria.list();
		    	
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
	    public List<hotfix_rpmpackage_bean>  select(String akid)
	    {
	    	Transaction transaction;
		    Session session;
		    
		    session=sessionFactory.openSession();
		    transaction=session.beginTransaction();
		    hotfix_rpmpackage_bean rpminfo = new hotfix_rpmpackage_bean();
	    	
	    	//transaction.begin();
	    	System.out.print(akid);
	    	Query q=session.createQuery("from hotfix_rpmpackage_bean rpminfo where rpminfo.akid=:name").setParameter("name", akid);
	    	List<hotfix_rpmpackage_bean> list=q.list();
	    	
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
