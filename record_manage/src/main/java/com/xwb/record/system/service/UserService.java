package com.xwb.record.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xwb.record.system.dao.UserDao;
import com.xwb.record.system.entity.SysUser;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<SysUser> getUsers(){
		return userDao.getUsers();
	}
}
