package com.sp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.sp.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from userinfo")
    List<User> selectAllUser();
	
	User SelectUserById(int id);

	int InsertTest();

}
