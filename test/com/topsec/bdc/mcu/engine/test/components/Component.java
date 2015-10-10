package com.topsec.bdc.mcu.engine.test.components;

import java.util.HashMap;

public abstract class Component {
	
	protected HashMap<String, Object> transtTo(String[] result) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(null == result || result.length == 0) {
			return map;
		}
		for(String data : result) {
			map.put(data + "_k", data);
		}
		return map;
	}
}
