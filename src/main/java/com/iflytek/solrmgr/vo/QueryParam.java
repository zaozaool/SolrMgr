package com.iflytek.solrmgr.vo;

public class QueryParam {

	/**
	 * collection名称
	 */
	private String collection;

	/**
	 * 默认返回第一页
	 */
	private Integer pageNo = 1;
	/**
	 * 每页默认返回10条数据
	 */
	private Integer pageSize = 10;

	/**
	 * 默认返回json格式
	 */
	private String returnType = "json";

	/**
	 * 返回的字段
	 */
	private String[] returnFiled = new String[0];

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	// private String sortBy = "";

	// private Map<String, String> params = new HashMap<String, String>();

}
