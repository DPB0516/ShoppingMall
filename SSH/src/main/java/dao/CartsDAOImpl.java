package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.Carts;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CartsDAOImpl implements CartsDAO{
	@Autowired
	private SessionFactory sf;
	@Override
	public void addCart(Carts cart) {
		sf.getCurrentSession().save(cart);
	}
	@Override
	public List<Carts> selectcart(int id) {
		Query query = sf.getCurrentSession().createQuery("from Carts where userid=?");
		query.setInteger(0, id);
		List<Carts> list = query.list();
		return list;
	}
	@Override
	public void delete(int id) {
		Session session = sf.getCurrentSession();
		Carts carts = session.get(Carts.class, id);
		System.out.println(carts.toString());
		session.delete(carts);
		System.out.println("运行了delete方法");
		
	}

}
