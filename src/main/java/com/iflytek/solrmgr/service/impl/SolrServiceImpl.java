package com.iflytek.solrmgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iflytek.solrmgr.bean.TUserTemp;
import com.iflytek.solrmgr.dao.TUserTempDao;
import com.iflytek.solrmgr.service.SolrService;
import com.iflytek.solrmgr.vo.UserVo;

@Service
@Transactional
public class SolrServiceImpl implements SolrService {

	@Autowired
	private TUserTempDao tUserTempDao;

	@Override
	public List<UserVo> getAllUser() {
		List<TUserTemp> list = this.tUserTempDao.getAll();
		for (TUserTemp tUserTemp : list) {
			System.out.println(tUserTemp);
		}
		return null;
	}

}
