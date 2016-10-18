package com.iflytek.solrmgr.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
	public static Properties p;
	
	public static String getProperty(String key){
		if(p == null){
			p = new Properties();
			try {
				p.load(PropertiesConfig.class.getResourceAsStream("/application.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return p.getProperty(key);
	}
}
