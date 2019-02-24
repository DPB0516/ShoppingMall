package serviceimpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.User;
import service.UserService;
import dao.UserDAO;

@Service("UserService")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImpl implements UserService{
	@Autowired
	@Qualifier("UserDAO")
	private UserDAO userdao;

	@Override
	public void addUser(User user) {
		userdao.addUser(user);
	}
	@Override
	public List<User> getAll() {
	
		return userdao.getAll();
	}
}
