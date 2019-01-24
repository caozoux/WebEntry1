package hotfix.db.testlink;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hotfix_hibernate_testlink {
    //定义变量
    Configuration config;
    SessionFactory sessionFactory = null;
    //Session session;
    //Transaction transaction;
    //before表示在方法执行前执行
    static public hotfix_hibernate_testlink mFacObj = null;
    private static Object lock = new Object(); // static确保只有一把锁
    static public hotfix_hibernate_testlink getFactoryObj()
    {
    	synchronized (lock) {
    		if (mFacObj==null) {
    			mFacObj = new  hotfix_hibernate_testlink();
    			mFacObj.setUp();
    		}
    	}
    	return mFacObj;
    }
    
    public void setUp()
    {
      //1.加载hibernate.cfg.xml配置
      config=new Configuration().configure("./hotfix/db/testlink/hotfix_hibernate_testlink.cfg.xml");
      sessionFactory=config.buildSessionFactory(); 
    }
    //添加操作
    
    public void insert(hotfix_hibernate_testlink_bean item)
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
	 public List<hotfix_hibernate_testlink_bean> selectAll()
	 {
	    	Transaction transaction;
		    Session session;
		    
		    session=sessionFactory.openSession();
		    transaction=session.beginTransaction();
	 
	    	Query q=session.createQuery("from hotfix_hibernate_testlink_bean");
	    	List<hotfix_hibernate_testlink_bean> list=q.list();
	    	
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
    public List<hotfix_hibernate_testlink_bean>  select(String akid)
    {
    	Transaction transaction;
	    Session session;
	    
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    hotfix_hibernate_testlink_bean rpminfo = new hotfix_hibernate_testlink_bean();
    	
    	//transaction.begin();
  
    	Query q=session.createQuery("from hotfix_hibernate_testlink_bean bean where bean.akid=:name").setParameter("name", akid);
    	List<hotfix_hibernate_testlink_bean> list=q.list();
    	
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
    
    public hotfix_hibernate_testlink_bean  updateByAkidAndKervel(String akid, String testlinkChangelist)
    {
    	Transaction transaction;
	    Session session;
	    
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    hotfix_hibernate_testlink_bean rpminfo = new hotfix_hibernate_testlink_bean();
    	
    	//transaction.begin();
    	System.out.print(akid);
    	String[] changeItem=testlinkChangelist.split(":") ;
    	String kerver=StringUtils.strip(changeItem[0]);
    	Query q=session.createQuery("from hotfix_hibernate_testlink_bean rpminfo where rpminfo.akid=:name and rpminfo.kerver=:kerstr").setParameter("name", akid).setParameter("kerstr", kerver);
    	List<hotfix_hibernate_testlink_bean> list=q.list();
    	
    	for(hotfix_hibernate_testlink_bean item:list){
            session.delete(item);
    	}	
    	
    	
    	hotfix_hibernate_testlink_bean changeObj = new hotfix_hibernate_testlink_bean();

    	changeObj.setKerver(kerver);
    	changeObj.setAkid(akid);
    	changeObj.setTestlink(testlinkChangelist);
    	session.save(changeObj);
    	
    	  
    	transaction.commit();
    	session.close();
    	return changeObj;
    }
    
    //更新操作
    //查询操作
    public List<hotfix_hibernate_testlink_bean>  updateByAkid(String akid, String[] testlinkChangelist)
    {
    	Transaction transaction;
	    Session session;
	    
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    hotfix_hibernate_testlink_bean rpminfo = new hotfix_hibernate_testlink_bean();
    	
    	//transaction.begin();
    	System.out.print(akid);
    	Query q=session.createQuery("from hotfix_hibernate_testlink_bean rpminfo where rpminfo.akid=:name").setParameter("name", akid);
    	List<hotfix_hibernate_testlink_bean> list=q.list();
    	
    	for(hotfix_hibernate_testlink_bean item:list){
            session.delete(item);
    	}	
    	
    	for(String str:testlinkChangelist) {
    		hotfix_hibernate_testlink_bean changeObj = new hotfix_hibernate_testlink_bean();
    		String[] changeItem=str.split(":") ;
    		changeObj.setKerver(changeItem[0]);
    		changeObj.setAkid(akid);
    		changeObj.setTestlink(str);
    		session.save(changeObj);
    	}
    	  
    	transaction.commit();
    	session.close();
    	return list;
    }
    
    public void update(hotfix_hibernate_testlink_bean item)
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
