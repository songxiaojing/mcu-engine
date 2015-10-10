package com.topsec.bdc.mcu.engine.test;

import com.topsec.bdc.mcu.engine.test.entity.Contexts;
import com.topsec.bdc.mcu.engine.test.filter.FilterChain;

public class ExecuteClient {
	
	FilterChain filterChain;
	Contexts ct;
	
	public void start() throws Exception {
		filterChain.doFilter(ct, filterChain);
	}

	public void setInitParams(Contexts ct, FilterChain chain) {
		this.filterChain = chain;
		this.ct = ct;
	}
	
}
