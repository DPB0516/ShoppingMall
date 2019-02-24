package serviceimpl;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.CartsDAO;
import po.Carts;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CartsServiceImpl implements service.CartsService{
	@Autowired
	private CartsDAO cd;
	@Override
	public void addCart(Carts cart) {
		cd.addCart(cart);
	}
	@Override
	public List<Carts> selectcart(int id) {
		
		return cd.selectcart(id);
	}
	@Override
	public void delete(int id) {
		cd.delete(id);
	}
	
	
}
