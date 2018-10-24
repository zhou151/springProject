package com.zhou.service.inter;

import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.zhou.dao.entity.User;

public interface UserServiceInter {

	PageInfo<User> getUser(int page, int pageSize);

	Boolean insertUser(Integer id, String name);

}