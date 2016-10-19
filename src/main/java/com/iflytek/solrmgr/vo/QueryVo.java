package com.iflytek.solrmgr.vo;

import com.iflytek.solrmgr.util.StringUtil;

public class QueryVo {

	/**
	 * 默认返回第一页
	 */
	private Integer pageNo;
	/**
	 * 每页默认返回10条数据
	 */
	private Integer pageSize;

	/**
	 * 排序字段（例如:name asc,age desc）
	 */
	private String sortBy;

	/**
	 * 返回的字段
	 */
	private String[] returnFiled = new String[0];

	private ParamVo param = new ParamVo();

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

	public String[] getReturnFiled() {
		return returnFiled;
	}

	public void setReturnFiled(String[] returnFiled) {
		this.returnFiled = returnFiled;
	}

	public String getSortBy() {
		if (StringUtil.isNullOREmpty(sortBy)) {
			return "";
		}
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public int getStartNum() {
		if (pageNo == null) {
			return 0;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		return (pageNo - 1) * pageSize;
	}

	public int getRowsNum() {
		if (pageSize == null) {
			pageSize = 10;
		}
		return pageSize;
	}

	public String getQ() {
		if (param == null) {
			return "*:*";
		}
		String json = param.getParamJson();
		if (StringUtil.isNullOREmpty(json)) {
			return "*:*";
		} else if (json.startsWith("AND") || json.startsWith("OR")) {
			json = json.substring(3, json.length());
		}
		return json;
	}

	public ParamVo getParam() {
		return param;
	}

	public void setParam(ParamVo param) {
		this.param = param;
	}

}
