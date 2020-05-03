package com.xwb.record.operation.entity;

import com.xwb.record.common.entity.BaseEntity;

/**
 * 推荐专题表
 * @author xiongwb
 *
 */
public class OptRecommendSubject extends BaseEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6621542912380869269L;

	private String id;
	/** 专题id */
	private String subjectId;
	/** 排序 */
	private Integer index;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	
}
