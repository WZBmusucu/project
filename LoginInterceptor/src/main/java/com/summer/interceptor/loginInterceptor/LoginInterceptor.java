package com.summer.interceptor.loginInterceptor;

import com.summer.interceptor.entities.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: summer
 * @Mail: lijiahaosummer@gmail.com
 * @Date: 2018 18-3-31 下午6:29
 * Project: LoginInterceptor
 * Package: com.summer.interceptor.loginInterceptor
 * Desc:
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("登录拦截器启动");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			System.out.println("没有登录,跳转到登录页面");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			return false;
		} else{
			return true;
		}
	}
}
