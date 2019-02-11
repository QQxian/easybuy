package intercepter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EasybuyUser;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import service.EasybuyUserService;


public class AutoLoginIntercepter implements HandlerInterceptor {
	@Resource
	private EasybuyUserService easybuyUserService;
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session!=null&&session.getAttribute("loginUser")==null){
			Cookie[] cookies = request.getCookies();
			String loginname = "";
			String password = "";
			if (cookies != null) {
				for(Cookie cookie : cookies ) {
					if (cookie.getName().equals("loginName")) {
						loginname = cookie.getValue();
					}
					if (cookie.getName().equals("password")) {
						password = cookie.getValue();
					}
				}
				if(easybuyUserService.login(loginname, password)){
					EasybuyUser easybuyUser = easybuyUserService.getAdminByLoginname(loginname);
					session.setAttribute("loginUser", easybuyUser);

				}
			}
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2) throws Exception {
		
		return true;
	}

}
