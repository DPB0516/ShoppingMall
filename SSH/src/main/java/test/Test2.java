package test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserService;
import dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {
	@Autowired
	private UserService us;
	@Autowired
	private UserDAO ud;
	@Test
	public void demo1(){
		System.out.println(us.getClass());
	}
	@Test
	public void demo2(){
		System.out.println(ud.getClass());
	}
}
