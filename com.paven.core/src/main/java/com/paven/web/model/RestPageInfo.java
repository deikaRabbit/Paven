package com.paven.web.model;

import java.io.Serializable;

public class RestPageInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3166502630426114536L;
	private Long totalCount;
	private Integer totalPage;

	public RestPageInfo() {
		this.totalCount = 0l;
		this.totalPage = 0;
	}

	public RestPageInfo(Long totalCount, Integer totalPage) {
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}
