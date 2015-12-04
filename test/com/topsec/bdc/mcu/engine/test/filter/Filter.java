package com.topsec.bdc.mcu.engine.test.filter;

import com.topsec.bdc.mcu.engine.test.entity.Contexts;

/**
 * 
 * @author Administrator
 *
 */
public interface Filter {
	
    public abstract void doFilter(Contexts contexts, FilterChain chain) throws Exception;

}
