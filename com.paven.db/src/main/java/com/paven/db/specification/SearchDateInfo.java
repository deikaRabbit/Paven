package com.paven.db.specification;

public class SearchDateInfo {

	private String column;
	private Object value1;
	private Object value2;

	public SearchDateInfo() {
	}

	public SearchDateInfo(String column, Object value1, Object value2) {
		this.column = column;
		this.value1 = value1;
		this.value2 = value2;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Object getValue1() {
		return value1;
	}

	public void setValue1(Object value1) {
		this.value1 = value1;
	}

	public Object getValue2() {
		return value2;
	}

	public void setValue2(Object value2) {
		this.value2 = value2;
	}	
}
