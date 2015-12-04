package com.topsec.bdc.mcu.engine.test.filter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topsec.bdc.mcu.engine.test.entity.Contexts;

/**
 * 
 * @author Administrator
 *
 */
public class FilterChain {

    private static Logger logger = LoggerFactory.getLogger(FilterChain.class);

    private int index = 0;

    private List<Filter> filters = new ArrayList<Filter>();

    public List<Filter> getFilters() {

        return filters;
    }

    public FilterChain addFilters(Filter filter) {

        this.filters.add(filter);
        return this;
    }
    
    public void init() {
    	if(index != 0) {
    		index = 0;
    	}
    }

    public void doFilter(Contexts contexts, FilterChain chain) throws Exception {
        if (index == filters.size())
            return;
        if(index == 0) {
        	contexts.setFirst(true);
        }else {
        	contexts.setFirst(false);
        }
        Filter filter = filters.get(index);
        index++;

        logger.info("汇入过程正在执行--{0}".replace("{0}", filter.getClass().getName()));

        filter.doFilter(contexts, chain);
    }
}
