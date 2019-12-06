package com.xwb.record.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xwb.record.system.entity.SysUser;
import com.xwb.record.system.service.UserService;

@RestController
@RequestMapping("/sys/userController")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public void getUsers() {
		List<SysUser> users = userService.getUsers();
		if(users != null) {
			users.stream().forEach(user -> System.out.println(user.getUsername() + "---" + user.getNickname()));
		}
	}
}
