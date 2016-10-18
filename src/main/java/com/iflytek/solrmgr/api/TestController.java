package com.iflytek.solrmgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iflytek.solrmgr.service.SolrService;
import com.iflytek.solrmgr.vo.UserVo;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private SolrService solrService;

	@RequestMapping("/hello")
	public String hello() {
		return "/test/hello";
	}
}
