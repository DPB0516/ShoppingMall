package serviceimpl;

import java.util.List;

import mapper.CartsMapper;
import mapper.CartsMapper1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.Carts;
import service.CartService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class CartServiceImpl implements CartService{
	@Autowired
	private CartsMapper map;
	@Autowired
	private CartsMapper1 map1;
	@Override
	public void addCart(Carts cart) {
		map.insert(cart);
	}
	@Override
	public List<Carts> getAll(int id) {
		return map1.getAll(id);
	}
	@Override
	public void deleteCart(int id) {
		 map1.deleteCart(id);
	}
	
}
