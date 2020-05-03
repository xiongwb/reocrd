package com.xwb.record.content.entity;

import com.xwb.record.common.entity.BaseEntity;

/**
 * 专题表
 * @author xiongwb
 *
 */
public class CntSubject extends BaseEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6463715646985334094L;

	private String id;
	/** 专题名称 */
	private String name;
	/** 专题描述 */
	private String describe;
	/** 专题图片 */
	private String picture;
	/** 专题类型 0-平台创建 1-用户创建 */
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
