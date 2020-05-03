package com.xwb.record.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.xwb.record.system.entity.SysUser;
import com.xwb.record.system.service.UserService;

public class AuthRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;

	/**
	 * 验证权限时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Session session = SecurityUtils.getSubject().getSession();
		SysUser user = (SysUser) session.getAttribute("USER_SESSION");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole(user.getRole());
		return authorizationInfo;
	}

	/**
	 * 登陆时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String principal = (String) token.getPrincipal();
		SysUser user = userService.getUserById(principal);
		if(user == null) {
			//用户不存在
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, user.getPassword(), getName());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", user);
        return authenticationInfo;
	}

}
