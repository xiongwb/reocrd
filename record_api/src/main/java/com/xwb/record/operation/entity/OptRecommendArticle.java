package com.xwb.record.operation.entity;

import com.xwb.record.common.entity.BaseEntity;

/**
 * 推荐文章表
 * @author xiongwb
 *
 */
public class OptRecommendArticle extends BaseEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6283258326645665147L;

	private String id;
	/** 文章id */
	private String articleId;
	/** 排序 */
	private Integer index;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
	
}
