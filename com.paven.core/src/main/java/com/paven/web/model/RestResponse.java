package com.paven.web.model;

import java.io.Serializable;
import java.util.List;

public class RestResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2725197707897906722L;
	private List<T> valueList;
	private RestPageInfo pageInfo;

	public RestResponse() {
	}

	public RestResponse(List<T> valueList) {
		this.valueList = valueList;
		this.pageInfo = new RestPageInfo();
	}

	public RestResponse(List<T> valueList, RestPageInfo pageInfo) {
		this.valueList = valueList;
		this.pageInfo = pageInfo;
	}

	public List<T> getValueList() {
		return valueList;
	}

	public void setValueList(List<T> valueList) {
		this.valueList = valueList;
	}

	public RestPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(RestPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
}
