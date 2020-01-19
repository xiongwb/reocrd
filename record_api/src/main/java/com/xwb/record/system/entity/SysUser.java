package com.xwb.record.system.entity;

import com.xwb.record.common.entity.BaseEntity;

/**
 * 普通用户表
 * @author xiongwb
 *
 */
public class SysUser extends BaseEntity{

	private String id;
	/** 账号 */
	private String username;
	/** 密码 */
	private String password;
	/** 昵称 */
	private String nickname;
	/** 性别 0-男 1-女 */
	private String gender;
	/** 生日 */
	private String birthday;
	/** 手机 */
	private String phone;
	/** 邮箱 */
	private String email;
	/** 个人简介 */
	private String introduce;
	/** 角色 0-普通用户  1-管理员 */
	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
}
