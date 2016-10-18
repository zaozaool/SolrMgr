package com.iflytek.solrmgr.bean;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;

@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicInsert = true, dynamicUpdate = true)
@javax.persistence.Entity
@javax.persistence.Table(name = "T_USER_TEMP")
@AccessType("field")
// @SequenceGenerator(name = "T_USER_TEMP_ID", sequenceName = "T_USER_TEMP_SEQ",
// allocationSize = 1)
public class TUserTemp {

	public TUserTemp() {

	}

	/**
	 * OBJECTID
	 */
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "T_USER_TEMP_ID")
	private Long objectid;

	@Column(name = "SFZH", length = 200)
	private String sfzh;

	@Column(name = "RYMC", length = 200)
	private String rymc;

	public Long getObjectid() {
		return objectid;
	}

	public void setObjectid(Long objectid) {
		this.objectid = objectid;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getRymc() {
		return rymc;
	}

	public void setRymc(String rymc) {
		this.rymc = rymc;
	}

}
