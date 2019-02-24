package service;

import java.util.List;

import po.Carts;

public interface CartsService {
	public void addCart(Carts cart);
	public List<Carts> selectcart(int id);
	public void delete(int id);
}
