package mapper;

import java.util.List;

import po.Carts;

public interface CartsMapper1 {
	public List<Carts> getAll(int id);
	public void deleteCart(int id);
}
