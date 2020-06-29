package com.xwb.record.system.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.xwb.record.common.entity.ResponseMessage;
import com.xwb.record.common.entity.Result;
import com.xwb.record.system.entity.SysUser;
import com.xwb.record.system.service.UserService;

/**
 * 用户管理
 * @author xiongwb
 *
 */
@RestController
@RequestMapping("/sys/userController")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getPage")
	public JSONObject getPage(Integer page, Integer limit) {
		List<SysUser> userList = userService.getList(page, limit);
		Integer count = userService.getCount();
		JSONObject data = new JSONObject();
		data.put("code", 0);
		data.put("msg", "查询成功");
		data.put("count", count);
		data.put("data", userList);
		return data;
	}
	
	@PostMapping("/signUp")
	public ResponseMessage<SysUser> signUp(SysUser user) {
		if(StringUtils.isBlank(user.getUsername())) {
			return Result.error("-1", "用户名不可为空", null);
		}
		if(StringUtils.isBlank(user.getPassword())) {
			return Result.error("-1", "密码不可为空", null);
		}
		user = userService.signUp(user);
		return Result.success("0", "注册成功", user);
	}
}
