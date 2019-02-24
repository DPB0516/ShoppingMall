package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory  sf ;
	
	@Override
	public void addUser(User user) {
		sf.getCurrentSession().save(user);
	}
	public List<User> getAll(){
		Query query = sf.getCurrentSession().createQuery("from User");
		List<User> list = query.list();
		return list;
	}
	
}
