package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	private String charset = "UTF-8";
	

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		
		filterChain.doFilter(request, response);
		
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		charset = filterConfig.getInitParameter("charset");
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
