package action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.EasybuyUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.EasybuyUserService;
import vo.Msg;

@Controller
public class EasybuyUserAction {
	@Resource
	private EasybuyUserService easybuyUserService;
	
	@RequestMapping("/welcome.do")
	public String  welcome(){
		return "welcome";
	}
	
	@RequestMapping("/doRegister.do")
	@ResponseBody
	 public Object register(String loginName,String userName,String password,String email,String mobile,String identityCode,String address,Integer sex) {
		Msg msg = new Msg();
		List<EasybuyUser> list = easybuyUserService.allMessage();
		for(EasybuyUser user : list){
			if(user.getLoginname().equals(loginName)){
				msg.setCode(-1);
				return msg;
			}
		}
		EasybuyUser easybuyUser = new EasybuyUser();
		easybuyUser.setEmail(email);
		easybuyUser.setIdentitycode(identityCode);
		easybuyUser.setLoginname(loginName);
		easybuyUser.setMobile(mobile);
		easybuyUser.setPassword(password);
		easybuyUser.setSex(sex);
		easybuyUser.setUsername(userName);
		easybuyUser.setType(0);
		if(easybuyUserService.register(easybuyUser)){
			msg.setCode(1);
			return msg;
		}
		msg.setCode(0);
        return msg;
    }
	
	@RequestMapping("/register.do")
	public String  register(){
		return "register/register";
	}
	@RequestMapping("/login.do")
	public String doLogin(String action,String loginName,String password,HttpServletRequest request, HttpServletResponse response,Model model){
		if(loginName==null||loginName.equals("")){
			model.addAttribute("action", action);
			return "login/login";
		}
		if (easybuyUserService.login(loginName,password)) {
			EasybuyUser easybuyUser = easybuyUserService.getAdminByLoginname(loginName);
			request.getSession().setAttribute("loginUser", easybuyUser);
			Cookie cookie = new Cookie("loginName" , loginName);
			cookie.setMaxAge(86400);
			response.addCookie(cookie);
			Cookie cookie1 = new Cookie("password" , password);
			cookie.setMaxAge(86400);
			response.addCookie(cookie1);
			if(action!=null&&!action.equals("")){
				return "redirect:"+action;
			}else{
				return "redirect:/index.do";
			}
		}
		request.setAttribute("action", action);
		return "login/login";
	
	}
	@RequestMapping("/loginOut.do")
	public String loginOut(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("loginUser");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			if (cookie.getName().equals("loginName")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			if (cookie.getName().equals("password")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "redirect:/login.do";
	}
//	@RequestMapping("/shopping_Cart.do")
//	public String  commodity2(){
//		return "shopping_Cart";
//	}

}
