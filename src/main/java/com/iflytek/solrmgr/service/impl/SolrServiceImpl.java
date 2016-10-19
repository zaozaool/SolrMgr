package com.iflytek.solrmgr.service.impl;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iflytek.solrmgr.service.SolrService;
import com.iflytek.solrmgr.util.PropertiesConfig;
import com.iflytek.solrmgr.util.SolrUtil;
import com.iflytek.solrmgr.util.StringUtil;
import com.iflytek.solrmgr.vo.QueryVo;

@Service
@Transactional
public class SolrServiceImpl implements SolrService {

	@Override
	public String query(String keyword) {
		SolrClient solr = SolrUtil.createSolrClient();
		try {
			SolrQuery query = new SolrQuery();
			if (StringUtil.isNullOREmpty(keyword)) {
				query.set("q", "*:*");
			} else {
				query.set("q", PropertiesConfig.getProperty("solr.defaultKey") + ":" + keyword);
			}
			query.set("wt", PropertiesConfig.getProperty("solr.wt"));
			query.set("collection", PropertiesConfig.getProperty("solr.collection"));
			QueryResponse response;
			response = solr.query(query);
			return new Gson().toJson(response);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				solr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new Gson().toString();
	}

	@Override
	public String query(QueryVo vo) {
		SolrClient solr = SolrUtil.createSolrClient();
		try {
			SolrQuery query = new SolrQuery();
			query.set("start", vo.getStartNum());
			query.set("rows", vo.getRowsNum());
			query.set("sort", vo.getSortBy());
			query.set("q", vo.getQ());
			query.set("wt", PropertiesConfig.getProperty("solr.wt"));
			query.set("collection", PropertiesConfig.getProperty("solr.collection"));
			QueryResponse response;
			response = solr.query(query);
			return new Gson().toJson(response);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				solr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
