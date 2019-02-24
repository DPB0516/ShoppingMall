package action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.Carts;
import po.Goods;
import service.CartsService;
import service.GoodsService;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CartsAction {
	@Autowired
	private CartsService cs;
	@Autowired
	private GoodsService gs;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	@Action(value="/addcart",results={@Result(name="getGoods",location="/getGoods",type="redirect")})
	public String addcart(){
		int userid = Integer.parseInt(request.getParameter("userid")) ;
		int goodid = Integer.parseInt(request.getParameter("goodid"));
		Carts cart = new Carts();
		cart.setUserid(userid);
		cart.setGoodsid(goodid);
		cs.addCart(cart);
		return "getGoods";
		
	}
	@Action(value="/selectcart",results={@Result(name="ok",location="/selectcarts.jsp")})
	public String selectcart(){
		int userid = Integer.parseInt(request.getParameter("userid")) ;
		List<Carts> list = cs.selectcart(userid);
		Map<Integer, Goods> map=new LinkedHashMap<>();
		for (Carts carts : list) {
				Goods findByid = gs.findByid(carts.getGoodsid());
				map.put(carts.getCartid(),findByid);
			}
		session.setAttribute("list", map);
		return "ok";
		
	}
	@Action(value="/delectcart",results={@Result(name="ok",location="selectcart",type="chain")})
	public String delectcart(){
		int userid = Integer.parseInt(request.getParameter("userid")) ;
		int cartid = Integer.parseInt(request.getParameter("cartid")) ;
		System.out.println(cartid);
		cs.delete(cartid);
		request.setAttribute("userid", userid);
		return "ok";
			}
}
