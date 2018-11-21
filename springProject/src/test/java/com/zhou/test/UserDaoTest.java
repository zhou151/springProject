package com.zhou.test;

import java.util.List;

import com.zhou.dao.UserMapper;
import com.zhou.dao.entity.User;
import com.zhou.test.tuil.SqlSessionFactoryUtil;

public class UserDaoTest {
	public static void main(String[] args) {
		
		UserMapper testMapper = SqlSessionFactoryUtil.getTestMapper(UserMapper.class);
		
		List<User> user = testMapper.getUser();
		
		System.out.println(user);
		
	}
}
