package dao;

import java.util.List;

import po.Goods;

public interface GoodsDAO {
	public List<Goods> getAll();
	public Goods findByid(int id);
}
