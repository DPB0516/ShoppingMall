package service;

import java.util.List;

import po.Goods;

public interface GoodsService {
	public List<Goods> getAll();
	public Goods selectByid(int id);
}
