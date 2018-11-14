package com.zhou.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhou.dao.entity.User;
import com.zhou.service.UserService;

@Controller
public class IndexController
{
	@Autowired UserService userService;

	public PageInfo<User> select(int page ,int pageSize)
	{
		return userService.getUser(page, pageSize);
	}
	
	
	@RequestMapping(value="/index")
	@ResponseBody
	public PageInfo<User> getindex(int page ,int pageSize)
	{
		//http://127.0.0.1:8080/helloSpring/index?page=1&pageSize=3
		PageInfo<User> u=select(page, pageSize);
		return u;
	}
	
	@ResponseBody
	@RequestMapping(value="/index1")
	public String getindex1()
	{
		return "dssdsdsdsdsdsd";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/insert")
	public Boolean getindex2(Integer id,String name)
	{
		return userService.insertUser(id, name);
	}
	
	
	@RequestMapping(value="/p")
	public String mvc01(ModelMap m)
	{
		m.addAttribute("msg","你好Spring mvc");
		return "myPage";
	}
	
	@RequestMapping(value="/t")
	public String mvc02()
	{
		return "test";
	}
	
	@RequestMapping(value="/errorTest")
	public String mvc03(Integer num01)
	{
		int i =num01/0;
		return "myPage";
	}
	
	
}
