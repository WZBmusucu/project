package com.summer.interceptor.loginInterceptor;

import com.summer.interceptor.entities.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: summer
 * @Mail: lijiahaosummer@gmail.com
 * @Date: 2018 18-4-1 下午12:29
 * Project: LoginInterceptor
 * Package: com.summer.interceptor.loginInterceptor
 * Desc:
 */
public class CheckUserLoginInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		IsCheckUserLogin auth = handlerMethod.getMethodAnnotation(IsCheckUserLogin.class);
		
		/**
		 * 如果在controller中的方法没有使用IsCheckUserLogin注解或者check=false,
		 * 就不需要判断在请求时用户是否已经登录.
		 */
		if (auth == null || !auth.check()) {
			return true;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");     //判断用户是否登录,如果user==null,则没有登录
		if (user != null) {
			return true;
		} else {
			System.out.println("没有登录,跳转到登录页面");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			return false;
		}
	}
}
