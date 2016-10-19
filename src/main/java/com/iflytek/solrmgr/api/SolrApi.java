package com.iflytek.solrmgr.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.iflytek.solrmgr.service.SolrService;
import com.iflytek.solrmgr.vo.QueryVo;

@Controller
@RequestMapping("/api")
public class SolrApi {

	@Autowired
	private SolrService solrService;

	@RequestMapping(value = "/query/{keyword}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String query(@PathVariable String keyword) {
		return solrService.query(keyword);
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String query(QueryVo param) {
		return solrService.query(param);
	}

	@RequestMapping(value = "/upload/config", method = RequestMethod.GET)
	public String uploadConfig() {
		return "/upload/config";
	}

	@RequestMapping(value = "/upload/config", method = RequestMethod.POST)
	public String uploadConfig(@RequestParam(value = "file", required = false) MultipartFile file) {

		return null;
	}

}
