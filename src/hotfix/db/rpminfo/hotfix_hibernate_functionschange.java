package hotfix.db.rpminfo;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class hotfix_hibernate_functionschange {

	    //定义变量
	    Configuration config;
	    SessionFactory sessionFactory = null;
	    //Session session;
	    //Transaction transaction;
	    //before表示在方法执行前执行
	    static public hotfix_hibernate_functionschange mFacObj;
	    static public hotfix_hibernate_functionschange getFactoryObj()
	    {
	    	if (mFacObj==null) {
	    		mFacObj = new  hotfix_hibernate_functionschange();
	    		mFacObj.setUp();
	    	}
	    	return mFacObj;
	    }
	    
	    public void setUp()
	    {
	      //1.加载hibernate.cfg.xml配置
	      config=new Configuration().configure("./hotfix/db/hotfix_hibernate_functionschange.cfg.xml");
	      sessionFactory=config.buildSessionFactory(); 
	    }
	    //添加操作
	    
	    public void insert(hotfix_hibernate_functionschange_bean item)
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
		 public List<hotfix_hibernate_functionschange_bean> selectAll()
		 {
		    	Transaction transaction;
			    Session session;
			    
			    session=sessionFactory.openSession();
			    transaction=session.beginTransaction();
		 
		    	Query q=session.createQuery("from hitfix_rpminfo_bean");
		    	List<hotfix_hibernate_functionschange_bean> list=q.list();
		    	
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
		    public List<hotfix_hibernate_functionschange_bean>  updateByAkid(String akid, String[] functionChangelist)
		    {
		    	Transaction transaction;
			    Session session;
			    
			    session=sessionFactory.openSession();
			    transaction=session.beginTransaction();
			    hotfix_hibernate_functionschange_bean rpminfo = new hotfix_hibernate_functionschange_bean();
		    	
		    	//transaction.begin();
		    	System.out.print(akid);
		    	Query q=session.createQuery("from hotfix_hibernate_functionschange_bean rpminfo where rpminfo.akid=:name").setParameter("name", akid);
		    	List<hotfix_hibernate_functionschange_bean> list=q.list();
		    	
		    	for(hotfix_hibernate_functionschange_bean item:list){
                    session.delete(item);
		    	}	
		    	
		    	for(String str:functionChangelist) {
		    		hotfix_hibernate_functionschange_bean changeObj = new hotfix_hibernate_functionschange_bean();
		    		String[] changeItem=str.split(":") ;
		    		changeObj.setAkid(akid);
		    		changeObj.setFile(changeItem[0]);
		    		changeObj.setMode(changeItem[1]);
		    		changeObj.setFunctions(changeItem[2]);
		    		session.save(changeObj);
		    	}
		    	  
		    	transaction.commit();
		    	session.close();
		    	return list;
		    }
		   
	    //查询操作
	    public List<hotfix_hibernate_functionschange_bean>  select(String akid)
	    {
	    	Transaction transaction;
		    Session session;
		    
		    session=sessionFactory.openSession();
		    transaction=session.beginTransaction();
		    hotfix_hibernate_functionschange_bean rpminfo = new hotfix_hibernate_functionschange_bean();
	    	
	    	//transaction.begin();
	    	System.out.print(akid);
	    	Query q=session.createQuery("from hotfix_hibernate_functionschange_bean rpminfo where rpminfo.akid=:name").setParameter("name", akid);
	    	List<hotfix_hibernate_functionschange_bean> list=q.list();
	    	
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
