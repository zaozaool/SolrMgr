package com.iflytek.solrmgr.util;

import org.apache.solr.common.cloud.OnReconnect;
import org.apache.solr.common.cloud.SolrZkClient;

public class SolrUtil {

	public static SolrZkClient createZkClient() {
		String zkServerAddress = PropertiesConfig.getProperty("zkServerAddress");
		SolrZkClient zkClient = new SolrZkClient(zkServerAddress, 30000, 30000, new OnReconnect() {
			@Override
			public void command() {
				
			}
		});
		return zkClient;
	}
}
