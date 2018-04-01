package com.summer.interceptor.service.impl;

import com.summer.interceptor.dao.UserDao;
import com.summer.interceptor.entities.User;
import com.summer.interceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: summer
 * @Mail: lijiahaosummer@gmail.com
 * @Date: 2018 18-3-31 下午6:54
 * Project: LoginInterceptor
 * Package: com.summer.interceptor.service.impl
 * Desc:
 */
@Service
public class UserServiceImpl implements UserService {
 	@Autowired
 	private UserDao userDao;
 	
	@Override
	public User getUserByNameAngPassw(String username, String password) {
		return userDao.getUserByNameAngPasw(username, password);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
