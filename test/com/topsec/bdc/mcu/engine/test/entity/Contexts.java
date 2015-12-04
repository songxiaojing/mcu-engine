package com.topsec.bdc.mcu.engine.test.entity;

import java.util.HashMap;

public class Contexts {
	private String line;
	private boolean isFirst;
	private HashMap<String, Object> map;
	private HashMap<String, Params> actionParamsMap = null;
	
	public HashMap<String, Params> getActionParamsMap() {
		return actionParamsMap;
	}

	public void setActionParamsMap(HashMap<String, Params> actionParamsMap) {
		this.actionParamsMap = actionParamsMap;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
}
