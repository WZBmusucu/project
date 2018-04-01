package com.summer.interceptor.controller;

import com.summer.interceptor.entities.User;
import com.summer.interceptor.loginInterceptor.IsCheckUserLogin;
import com.summer.interceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: summer
 * @Mail: lijiahaosummer@gmail.com
 * @Date: 2018 18-3-31 下午6:24
 * Project: LoginInterceptor
 * Package: PACKAGE_NAME
 * Desc:
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Resource
	private HttpServletRequest request;
	
	@IsCheckUserLogin(check = true)
	@RequestMapping(value = "showAllUsers.do")
	public ModelAndView showAllUsers() {
		ModelAndView modelAndView = new ModelAndView("showAllUsers");
		List<User> userList = userService.getAllUsers();
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	
	@RequestMapping(value = "doLogin.do", method = RequestMethod.POST)
	public String login(String username, String password) {
		User user = userService.getUserByNameAngPassw(username, password);
		if (user == null) {
			return "fail";
		} else {
			request.getSession().setAttribute("user", user);
			return "success";
		}
	}
	
	@RequestMapping("login.do")
	public String toLoginPage() {
		return "login";
	}
}
