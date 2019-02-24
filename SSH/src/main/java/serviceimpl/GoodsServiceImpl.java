package serviceimpl;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.GoodsDAO;
import po.Goods;
import service.GoodsService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDAO gd;
	@Override
	public List<Goods> getAll() {
		
		return gd.getAll();
	}
	@Override
	public Goods findByid(int id) {
		return gd.findByid(id);
	}

}
