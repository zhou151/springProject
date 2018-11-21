package com.zhou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhou.dao.entity.User;

public interface UserMapper
{

	public List<User> getUser();

	public Boolean insertUser( Integer id,String name);
}
