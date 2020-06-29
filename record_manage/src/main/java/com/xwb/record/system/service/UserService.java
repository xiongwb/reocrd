package com.xwb.record.system.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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

	/**
	 * 通过主键获取实体类
	 * @param id
	 * @return
	 */
	public SysUser getUserById(String id) {
		return userDao.getUserById(id);
	}
	
	/**
	 * 通过用户名获取实体类
	 * @param principal
	 * @return
	 */
	public SysUser getUserByName(String username) {
		return userDao.getUserByName(username);
	}

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public SysUser signUp(SysUser user) {
		String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		user.setId(id);
		
		//用户创建信息
		user.setCreatedId("system");
		user.setLastModifiedId("system");
		String now = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		user.setCreatedTime(now);
		user.setLastModifiedTime(now);
		
		//角色设为普通用户
		user.setRole("0");
		
		//密码加密
		String currentTimeMillis = System.currentTimeMillis() + "";
		user.setSalt(currentTimeMillis);
		user.setPassword(encryptPassword(user.getPassword(), currentTimeMillis));
		
		userDao.insert(user);
		
		return user;
	}
	
	/**
	 * 密码加密
	 * @param pwd
	 * @param salt
	 * @return
	 */
	public String encryptPassword(String pwd, String salt) {
		String hashAlgorithName = "MD5";//加密算法
        int hashIterations = 2;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash(hashAlgorithName, pwd, credentialsSalt, hashIterations);
        return simpleHash.toString();
	}
	
}
