package com.summer.interceptor.service;

import com.summer.interceptor.entities.User;

import java.util.List;

/**
 * @Author: summer
 * @Date: 2018 18-3-31 下午6:52
 * @Project: LoginInterceptor
 */
public interface UserService {
	public User getUserByNameAngPassw(String username, String password);
	public List<User> getAllUsers();
}
