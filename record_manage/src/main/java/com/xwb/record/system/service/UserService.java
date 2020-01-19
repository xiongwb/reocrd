package com.xwb.record.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<SysUser> getList(Integer page, Integer limit) {
		page = page == null ? 1 : page;
		limit = limit == null ? 10 : limit;
		int offset = (page - 1) * limit;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("offset", offset);
		paramMap.put("limit", limit);
		return userDao.getList(paramMap);
	}

	public Integer getCount() {
		return userDao.getCount();
	}
}
