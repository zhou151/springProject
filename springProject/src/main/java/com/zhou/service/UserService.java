package com.zhou.service;

import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.zhou.dao.entity.User;

public interface UserService {

	PageInfo<User> getUser(int page, int pageSize);

	Boolean insertUser(Integer id, String name);

}