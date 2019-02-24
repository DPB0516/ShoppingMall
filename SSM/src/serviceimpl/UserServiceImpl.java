package serviceimpl;

import java.util.List;

import mapper.UserMapper;
import mapper.UserMapper1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.User;
import service.UserService;
@Service
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper map1;
	@Autowired
	private UserMapper1 map2;
	@Override
	public List<User> getAll() {
		
		return map2.getAll();
	}
	
}
