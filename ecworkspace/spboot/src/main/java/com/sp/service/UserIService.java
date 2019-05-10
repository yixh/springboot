package com.sp.service;

import java.util.List;
import com.sp.entity.User;

public interface UserIService {

	List<User> selectAllUser();

	User SelectUserById(int id);

	int InsertTest();
}
