package action;

import java.util.List;





import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import po.Goods;
import service.GoodsService;

@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class GoodsAction {
	@Autowired
	private GoodsService gs;
	
@RequestMapping("/goodsgetAll")
public String demo1(Model model,HttpServletResponse response){
	List<Goods> all = gs.getAll();
	model.addAttribute("list", all);
	return "ohuo";
	
}
}

