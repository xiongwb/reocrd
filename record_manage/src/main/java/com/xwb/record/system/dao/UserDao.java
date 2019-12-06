package com.xwb.record.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xwb.record.system.entity.SysUser;

@Mapper
public interface UserDao {

	public List<SysUser> getUsers();
}
