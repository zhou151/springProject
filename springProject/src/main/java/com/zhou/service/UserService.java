package com.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhou.dao.entity.User;
import com.zhou.dao.interfaces.UserMapper;
import com.zhou.service.inter.UserServiceInter;

@Service
@Transactional
public class UserService implements UserServiceInter
{
	@Autowired
	private UserMapper userMapper;
	
	/* (non-Javadoc)
	 * @see com.zhou.service.UserServiceInter#getUser(int, int)
	 */
	@Override
	@Transactional(readOnly=true)
	public PageInfo<User> getUser(int page ,int pageSize){
		PageHelper.startPage(page,pageSize);
		List<User> list=userMapper.getUser();
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	}
	/* (non-Javadoc)
	 * @see com.zhou.service.UserServiceInter#insertUser(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Boolean insertUser(Integer id,String name){
		Boolean b=userMapper.insertUser(id,name);
		//模拟异常发生,测试事务是否开启
		//int i=5/0;  
		return b;
	}
}
