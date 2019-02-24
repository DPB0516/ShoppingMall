package Test;



import java.util.List;

import mapper.UserMapper;
import mapper.UserMapper1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;







import po.Carts;
import po.User;
import service.CartService;
import service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class Test1 {
	@Autowired
	private CartService cs;
	@Test
	public void demo1(){
		List<Carts> all = cs.getAll(1);
		System.out.println(all);
	}
}
