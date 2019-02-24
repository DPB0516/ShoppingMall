package service;

import java.util.List;

import po.User;

public interface UserService {
	public void addUser(User user);
	public List<User> getAll();
}
