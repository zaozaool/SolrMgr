package com.iflytek.solrmgr.service;

import com.iflytek.solrmgr.vo.QueryVo;

public interface SolrService {

	/**
	 * 根据关键字查询
	 * 
	 * @param keyword
	 *            关键字
	 * 
	 * @return
	 */
	public String query(String keyword);

	/**
	 * 根据具体字段等查询
	 * 
	 * @param param
	 * 
	 * @return
	 */
	public String query(QueryVo param);

}
