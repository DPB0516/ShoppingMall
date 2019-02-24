package serviceimpl;

import java.util.List;

import mapper.GoodsMapper;
import mapper.GoodsMapper1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.Goods;
import service.GoodsService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsMapper map1;
	@Autowired
	private GoodsMapper1 map2;
	@Override
	public List<Goods> getAll() {
		
		return map2.getAll();
	}
	@Override
	public Goods selectByid(int id) {
		
		return map1.selectByPrimaryKey(id);
	}
	
}
