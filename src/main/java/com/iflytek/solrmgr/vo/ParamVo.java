package com.iflytek.solrmgr.vo;

import java.util.ArrayList;
import java.util.List;

import com.iflytek.solrmgr.util.PropertiesConfig;
import com.iflytek.solrmgr.util.StringUtil;

public class ParamVo {

	private List<ParamVo> paramList = new ArrayList<ParamVo>();

	private String key = "";
	private String value = "";

	private String logic = "AND";

	public String getKey() {
		if (StringUtil.isNullOREmpty(key)) {
			return PropertiesConfig.getProperty("solr.defaultKey");
		}
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLogic() {
		if (!"AND".equalsIgnoreCase(logic) && !"OR".equalsIgnoreCase(logic)) {
			return "AND";
		}
		return logic.toUpperCase();
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}

	public List<ParamVo> getParamList() {
		return paramList;
	}

	public void setParamList(List<ParamVo> paramList) {
		this.paramList = paramList;
	}

	public String getParamJson() {
		String json = "";
		if (!StringUtil.isNullOREmpty(value)) {
			json += getLogic() + "  (" + getKey() + ":\"" + value + "\") ";
		}
		if (paramList != null && !paramList.isEmpty()) {
			String tempJson = getLogic() + " (";
			for (int i = 0; i < paramList.size(); i++) {
				ParamVo p = paramList.get(i);
				String tempJson2 = p.getParamJson();
				if (i == 0 && !StringUtil.isNullOREmpty(tempJson2)) {
					tempJson2 = tempJson2.substring(3, tempJson2.length());
				}
				tempJson += tempJson2;
			}
			tempJson += ") ";
			if (tempJson.endsWith("()")) {
				tempJson = "";
			}
			json += tempJson;
		}
		return json;
	}

}
