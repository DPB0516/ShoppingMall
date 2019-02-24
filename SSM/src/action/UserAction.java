package action;

import java.io.IOException;
import java.util.List;







import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapper.UserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import po.User;
import service.UserService;
import serviceimpl.UserServiceImpl;



@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class UserAction {
	@Autowired
	private  UserService us;
	@RequestMapping("/a.action")
	public String a(Model model,String name,String pwd,HttpServletResponse response) throws IOException{
		List<User> all = us.getAll();
		
		for (User user : all) {
		if (user.getName().equals(name)&&user.getPassword().equals(pwd)) {
			Cookie cookie = new Cookie("name", user.getName().trim());
			cookie.setMaxAge(24*60*60);
			cookie.setPath("/SSM/");
			response.addCookie(cookie);
			Cookie cookie1 = new Cookie("userid", user.getUserid().toString().trim());
			cookie1.setMaxAge(24*60*60);
			cookie1.setPath("/SSM/");
			response.addCookie(cookie1);
			return "redirect:goodsgetAll.action";
		}
		}                              
		
		return "index";
		
	}
	@RequestMapping("/b.action")
	public String b(HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userid")) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				cookie.setPath("/SSM/");
				response.addCookie(cookie);
			}
			if (cookie.getName().equals("name")) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				cookie.setPath("/SSM/");
				response.addCookie(cookie);
			}
		}
		return "index";
		
	}
}
