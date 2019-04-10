package com.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.User;

public interface UserMapper {
	public int count();
	
	public int add(User user);
	
	public int modpwd(@Param("uid")Integer id,@Param("upwd")String pwd);
}
