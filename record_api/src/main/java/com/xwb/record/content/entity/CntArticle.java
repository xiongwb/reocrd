package com.xwb.record.content.entity;

import com.xwb.record.common.entity.BaseEntity;

/**
 * 文章表
 * @author xiongwb
 *
 */
public class CntArticle extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 30234831121780820L;

	private String id;
	/** 文章名称 */
	private String name;
	/** 文章内容 */
	private String content;
	/** 类型 0-公开 1-私密 */
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
