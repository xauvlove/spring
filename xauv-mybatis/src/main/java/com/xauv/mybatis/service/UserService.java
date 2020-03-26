package com.xauv.mybatis.service;

import com.xauv.mybatis.mapper.UserMapper;
import com.xauv.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	public List<User> queryAllUser() {
		return userMapper.queryAllUser();
	}
}
