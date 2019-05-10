package com.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sp.dao.UserMapper;
import com.sp.entity.User;
import com.sp.service.UserIService;

@Service("userService")
public class UserServiceImpl implements UserIService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> selectAllUser() {
		return null;
	}

	@Override
	public User SelectUserById(int id) {
		return userMapper.SelectUserById(id);
	}

	@Override
	public int InsertTest() {
		return userMapper.InsertTest();
	}

}
