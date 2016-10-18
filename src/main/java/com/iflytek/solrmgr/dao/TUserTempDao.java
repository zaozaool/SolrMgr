package com.iflytek.solrmgr.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iflytek.solrmgr.bean.TUserTemp;

@Repository
public class TUserTempDao extends BaseDao<TUserTemp, Integer> {

	@Autowired
	private SessionFactory sessionFactory;

}
