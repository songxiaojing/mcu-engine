package com.topsec.bdc.mcu.engine.test.actions;

import com.topsec.bdc.mcu.engine.test.entity.Contexts;
import com.topsec.bdc.mcu.engine.test.filter.Filter;
import com.topsec.bdc.mcu.engine.test.filter.FilterChain;

public class Test3Action extends Action implements Filter {
	@Override
	public void doFilter(Contexts contexts, FilterChain chain) throws Exception {
		if(contexts.getActionParamsMap().containsKey(this.getClass().getSimpleName())) {
			run(contexts.getActionParamsMap().get(this.getClass().getSimpleName()));
		}
		chain.doFilter(contexts, chain);
	}

}
