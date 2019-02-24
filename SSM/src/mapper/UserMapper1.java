package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import po.User;
@Repository("UserMapper1")
public interface UserMapper1 {
	public List<User> getAll();
}
