package com.iflytek.solrmgr.test;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.cloud.SolrZkClient;
import org.apache.solr.common.cloud.ZkConfigManager;

import com.iflytek.solrmgr.util.HttpRequestUtil;
import com.iflytek.solrmgr.util.SolrUtil;
import com.iflytek.solrmgr.util.StringUtil;

public class TestSolr {

	public static void main(String[] args) {
		// uploadConf();
		// createCollection();
		// deleteCollection();
		query();
	}

	public static void createCollection() {
		TestSolr ts = new TestSolr();
		ts.createCompositeIdCollection("test1", "3", "3", null, "test");
	}

	public static void deleteCollection() {
		String url = "http://172.16.246.30:8001/solr/admin/collections";
		String para = "action=CREATE";
		para += "&name=test";
		String sr = HttpRequestUtil.sendGet(url, para);
	}

	public static void uploadConf() {
		TestSolr ts = new TestSolr();
		SolrZkClient zkClient = SolrUtil.createZkClient();
		ts.uploadConfBySolrZkClient(zkClient, "D:\\iflytek\\qbpt\\config\\monitor-web\\conf", "test");
	}

	public void uploadConfBySolrZkClient(SolrZkClient zkClient, String confDir, String confName) {
		try {
			ZkConfigManager zkConfigManager = new ZkConfigManager(zkClient);
			if (zkConfigManager.configExists(confName)) {
				zkConfigManager.deleteConfigDir(confName);
			}
			zkConfigManager.uploadConfigDir(Paths.get(confDir), confName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int createCompositeIdCollection(String name, String numShards, String replicationFactor,
			String maxShardsPerNode, String configName) {
		try {

			String url = "http://172.16.246.30:8001/solr/admin/collections";
			String para = "action=CREATE";
			para += "&name=";
			para += name;
			para += "&numShards=";
			para += numShards;
			if (!StringUtil.isNullOREmpty(maxShardsPerNode)) {
				para += "&maxShardsPerNode=";
				para += maxShardsPerNode;
			} else {
				para += "&maxShardsPerNode=30";
			}
			para += "&collection.configName=";
			para += configName;
			para += "&replicationFactor=";
			para += replicationFactor;
			para += "&wt=json";

			String sr = HttpRequestUtil.sendGet(url, para);
			if (sr.indexOf("success") == -1) {
				// logger.error("创建collection失败！ msg : " + sr);
				// throw new MidServiceException("创建collection失败" + sr);
				return -1;
			}

			return 1;

		} catch (Exception e) {
			// logger.error("创建collection失败！ msg : " + e.getMessage());
			// throw new MidServiceException("创建collection失败！", e);
			return -1;
		}
	}

	public static void query() {
		String zkHostString = "172.16.246.27:2182,172.16.246.30:2182,172.16.246.31:2182";
		SolrClient solr = new CloudSolrClient(zkHostString);
		try {
			// SolrClient solr = new
			// CloudSolrClient.Builder().withZkHost(zkHostString).build();
			// solr.connect();
			SolrQuery query = new SolrQuery();
			// query.setRequestHandler("/test");
			// query.setQuery(mQueryString);
			query.set("q", "*:*");
			// query.set("qt", "/select");
			// query.setFields("category", "title", "price");
			// query.set("q", "category:books");
			query.set("wt", "json");
			 query.set("shards", "shard3");
			query.set("collection", "test1");
			QueryResponse response;
			response = solr.query(query);
			SolrDocumentList list = response.getResults();
			for (SolrDocument d : list) {
				System.out.println(d);
			}
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
	}

}
