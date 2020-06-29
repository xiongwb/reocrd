package com.xwb.record.common.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xwb.record.common.entity.ResponseMessage;
import com.xwb.record.common.entity.Result;

@RestController
@RequestMapping("/common/loginController")
@SuppressWarnings("rawtypes")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	public ResponseMessage login(String username, String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
			return Result.success("0", "登录成功");
		} catch (UnknownAccountException e) {
			logger.info(e.getMessage(), e);
			token.clear();
			return Result.error("-1", "用户名或密码不正确");
		} catch (AuthenticationException e) {
			logger.info(e.getMessage(), e);
			token.clear();
			return Result.error("-1", "用户名或密码不正确");
		}
	}
}
