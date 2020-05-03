package com.xwb.record.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.xwb.record.system.entity.SysUser;

@Mapper
public interface UserDao {

	public List<SysUser> getList(Map<String, Object> paramMap);

	public Integer getCount();

	public SysUser getUserById(String id);
}
