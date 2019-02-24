package dao;

import java.util.List;

import po.User;

public interface UserDAO {
	public void addUser(User user);
	public List<User> getAll();
}
