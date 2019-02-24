package action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import po.User;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserAction extends ActionSupport{
	@Autowired
	private UserService us;
	@Test
	public void demo1(){
	
	}
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();
	
	@Action(value = "/getuser",results = {@Result(name="getGoods",location="/getGoods",type="redirect"),@Result(name="no",location="/index.jsp")})
	public String add(){
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		List<User> list = us.getAll();
		for (User user : list) {
			if (user.getName().equals(name)&&user.getPassword().equals(pwd)) {
				Cookie cookie = new Cookie("name", user.getName().trim());
				cookie.setMaxAge(24*60*60);
				cookie.setPath("/SSH/");
				response.addCookie(cookie);
				Cookie cookie1 = new Cookie("userid", user.getUserid().toString().trim());
				cookie1.setMaxAge(24*60*60);
				cookie1.setPath("/SSH/");
				response.addCookie(cookie1);
				return "getGoods";
			}
		}
		
		return "no";
	}
	@Action(value = "/deleteuser",results = {@Result(name="delete",location="/index.jsp",type="redirect")})
	public String delete(){
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userid")) {
						cookie.setValue(null);
						cookie.setMaxAge(0);
						cookie.setPath("/SSH/");
						response.addCookie(cookie);
				}
				if (cookie.getName().equals("name")) {
					cookie.setValue(null);
					cookie.setMaxAge(0);
					cookie.setPath("/SSH/");
					response.addCookie(cookie);
			}
		}
		return "delete";
	}
	
}
