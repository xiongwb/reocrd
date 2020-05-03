package com.xwb.record.common.entity;

import java.util.List;

public class PageInfo<T> {

	/** 第几页 */
	private Integer pageNo;
	/** 每页多少条 */
    private Integer pageSize;
    /** 总数 */
    private Long count;
    /** 结果 */
    private List<T> data;
}
