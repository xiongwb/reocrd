package com.xwb.record.content.entity;

import com.xwb.record.common.entity.BaseEntity;

/**
 * 专题文章关系表
 * @author xiongwb
 *
 */
public class CntSubjectArticle extends BaseEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2159314586850786904L;
	
	private String id;
	/** 专题id */
	private String subjectId;
	/** 文章id */
	private String articleId;

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

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}


}
