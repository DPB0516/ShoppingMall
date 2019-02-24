package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.Goods;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsDAOImpl implements GoodsDAO{
	@Autowired
	private SessionFactory sf;
	@Override
	public List<Goods> getAll() {
		List<Goods> list = sf.getCurrentSession().createQuery("from Goods").list();
		return list;
	}
	@Override
	public Goods findByid(int id) {
		Goods goods = sf.getCurrentSession().get(Goods.class, id);
		return goods;
	}

}
