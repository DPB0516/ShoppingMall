package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import po.User;
import dao.UserDAO;

public class Test extends HibernateDaoSupport{
	@org.junit.Test
	public void demo1(){
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserDAO bean = (UserDAO) context.getBean("UserDAO");
		System.out.println(bean.getClass());
	}
	@org.junit.Test
	public void demo2(){
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory bean = (SessionFactory) context.getBean("sessionFactory");
		Session session = bean.getCurrentSession();
		System.out.println(1);
	}
}		
