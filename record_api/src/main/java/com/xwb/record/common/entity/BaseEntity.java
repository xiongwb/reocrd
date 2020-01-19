package com.xwb.record.common.entity;

public class BaseEntity {

	/** 创建人id */
	private String createdId;
	/** 创建时间 */
	private String createdTime;
	/** 最后修改人id */
	private String lastModifiedId;
	/** 最后修改时间 */
	private String lastModifiedTime;
	/** 备注 */
	private String remarks;
	/** 删除标志 0-未删除 1-已删除 */
	private String deleteFlag = "0";

	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastModifiedId() {
		return lastModifiedId;
	}

	public void setLastModifiedId(String lastModifiedId) {
		this.lastModifiedId = lastModifiedId;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
