package com.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhou.dao.entity.User;
import com.zhou.dao.interfaces.UserMapper;

@Service
@Transactional
public class UserService
{
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(readOnly=true)
	public PageInfo<User> getUser(int page ,int pageSize){
		PageHelper.startPage(page,pageSize);
		List<User> list=userMapper.getUser();
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	}
	
	public Boolean insertUser(Integer id,String name){
		Boolean b=userMapper.insertUser(id,name);
		//模拟异常发生,测试事务是否开启
		//int i=5/0;  
		return b;
	}
}
