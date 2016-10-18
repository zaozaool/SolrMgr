package com.iflytek.solrmgr.service;

import com.iflytek.solrmgr.vo.QueryParam;

public interface SolrService {

	/**
	 * 更加关键字查询
	 * 
	 * @param keyword
	 *            关键字
	 * @param collection
	 *            collection名称
	 * @param returnType
	 *            返回类型，默认是json，可用类型有json/xml/csv/python/ruby/php
	 * 
	 * @return
	 */
	public String query(String keyword, String collection, String returnType);

	public String query(QueryParam param);

}
