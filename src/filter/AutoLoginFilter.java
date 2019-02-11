package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import model.EasybuyUser;
import service.EasybuyUserService;
import service.impl.EasybuyUserServiceImpl;
@Component
public class AutoLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
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
				if(loginname!=null&&!loginname.equals("")){
					EasybuyUserService easybuyUserService = new EasybuyUserServiceImpl();
					EasybuyUser easybuyUser = new EasybuyUser();
					easybuyUser.setLoginname(loginname);
					easybuyUser.setPassword(password);
					if (easybuyUserService.login(loginname, password)) {//验证登录
						session.setAttribute("loginUser", easybuyUser);
					}
				}
			}
		}
		filterChain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
