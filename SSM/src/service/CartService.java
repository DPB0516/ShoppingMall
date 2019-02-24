package service;

import java.util.List;

import po.Carts;

public interface CartService {
	public void addCart(Carts cart);
	public List<Carts> getAll(int id);
	public void deleteCart(int id);
}
