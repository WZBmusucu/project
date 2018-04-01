package com.summer.interceptor.dao;

import com.summer.interceptor.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: summer
 * @Date: 2018 18-3-31 下午6:43
 * @Project: LoginInterceptor
 */
public interface UserDao {
	public User getUserByNameAngPasw(@Param("username") String username,
									 @Param("password") String password);
	public List<User> getAllUsers();
}
