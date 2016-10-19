package com.iflytek.solrmgr.util;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.cloud.OnReconnect;
import org.apache.solr.common.cloud.SolrZkClient;

public class SolrUtil {

	/**
	 * 获取zk client
	 * 
	 * @return
	 */
	public static SolrZkClient createZkClient() {
		String zkServerAddress = PropertiesConfig.getProperty("zkServerAddress");
		SolrZkClient zkClient = new SolrZkClient(zkServerAddress, 30000, 30000, new OnReconnect() {
			@Override
			public void command() {

			}
		});
		return zkClient;
	}

	/**
	 * 获取solr client
	 * 
	 * @return
	 */
	public static SolrClient createSolrClient() {
		String zkServerAddress = PropertiesConfig.getProperty("zkServerAddress");
		SolrClient solr = new CloudSolrClient(zkServerAddress);
		return solr;
	}

}
