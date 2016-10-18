package com.iflytek.solrmgr.api;

import static com.iflytek.solrmgr.util.GsonHelper.gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iflytek.solrmgr.service.SolrService;

@Controller
@RequestMapping("/api")
public class SolrApi {

	@Autowired
	private SolrService solrService;

	@RequestMapping(value = "/query/{keyword}", method = RequestMethod.GET)
	public String query(@PathVariable String keyword) {
		// System.out.println("/query/{keyword}");
		// SolrZkClient zkClient = SolrUtil.createZkClient();
		// gson().toJson(jsonElement);
		return null;
	}
}
