package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import po.Carts;
import po.Goods;
import service.CartService;
import service.GoodsService;

@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class CartsAction {
	@Autowired
	private CartService cs;
	@Autowired
	private GoodsService gs;
	@RequestMapping("/addcart")
	public String addcart(int userid,int goodid,HttpServletResponse response) throws IOException{
		Carts carts = new Carts();
		carts.setUserid(userid);
		carts.setGoodsid(goodid);
		cs.addCart(carts);
	return "redirect:goodsgetAll.action";
		}
	@RequestMapping("/selectcart")
	public String selectcart(int userid,Model model,HttpSession session){
		List<Carts> all = cs.getAll(userid);
		Map<Integer,Goods> map=new LinkedHashMap<Integer,Goods>();
		for (Carts carts : all) {
			
				Goods selectByid = gs.selectByid(carts.getGoodsid());
				map.put(carts.getCartid(),selectByid);
		}
		session.setAttribute("list", map);
		return "redirect:selectcarts.jsp";
	}
	@RequestMapping("/deleteCart")
	public String deleteCart(int cartid,int userid){
			cs.deleteCart(cartid);
		return "redirect:selectcart.action?userid="+userid;
	}
}
