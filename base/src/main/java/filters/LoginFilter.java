package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO 判断session里面是否有用户名这个属性同时这个属性的值是否为空，如果为空则重定向到login.jsp，否则继续访问Web资源。
 *
 * @author 丁光辉
 * @version 1.0
 * @since Bessky V100R001C00
 */
public class LoginFilter implements Filter
{
	FilterConfig config;

	@Override
	public void destroy()
	{

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String encoding = config.getInitParameter("encoding");
		if (null == encoding)
		{
			request.setCharacterEncoding("UTF-8");
		}
		else
		{
			request.setCharacterEncoding(encoding);
		}
		String userName = (String) request.getSession().getAttribute("username");

		String exceptPage = config.getInitParameter("exceptPage");
		if (null != exceptPage && !"".equals(exceptPage.trim()))
		{
			String[] exceptPages = exceptPage.split(";");
			for (String except : exceptPages)
			{
				System.out.println(request.getRequestURI());
//				request.getRequestURL() 返回客户端正要请求的url全路径
//				request.getRequestURI() 返回除去host（域名或者ip）部分的路径
//				请求的url内“xx.jsp”的位置，返回的是一个数字，代表出现的位置，-1表示不存在。
				if (request.getRequestURI().indexOf(except) != -1)
				{
//					放行，执行下一个filter，没有就继续执行servlet：如登入（密码不为admin）会遍历三次=loginIn.jsp，满足if，客户端正要请求的url变为fail.jsp，继续执行doFilter
//					如直接请求success.jsp，会遍历四次，没有可以满足if的exceptPage
					arg2.doFilter(arg0, arg1);
					return;
				}
			}
		}
//按正常流程执行后，有username可以继续执行servlet(请求到下一个url)
		if (null != userName)
		{
			arg2.doFilter(arg0, arg1);
		}
		else
		{
			//第一次request.getRequestURL()为/，必定执行
			response.sendRedirect(request.getContextPath() + "/theory/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		this.config = arg0;
	}
}
