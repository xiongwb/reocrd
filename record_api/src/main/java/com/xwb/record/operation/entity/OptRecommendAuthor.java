package com.xwb.record.operation.entity;

import com.xwb.record.common.entity.BaseEntity;

/**
 * 推荐作者表
 * @author xiongwb
 *
 */
public class OptRecommendAuthor extends BaseEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7254671011270956122L;

	private String id;
	/** 用户id */
	private String userId;
	/** 排序 */
	private Integer index;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
	
}
