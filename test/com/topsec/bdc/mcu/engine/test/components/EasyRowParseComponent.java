package com.topsec.bdc.mcu.engine.test.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topsec.bdc.mcu.engine.test.entity.Contexts;
import com.topsec.bdc.mcu.engine.test.filter.Filter;
import com.topsec.bdc.mcu.engine.test.filter.FilterChain;


public class EasyRowParseComponent extends Component implements Filter  {
	private static Logger logger = LoggerFactory.getLogger(EasyRowParseComponent.class);
	private String separator = "\t";
	
	@Override
	public void doFilter(Contexts contexts, FilterChain chain) throws Exception {
		if(contexts.isFirst()) {
			logger.info(this.getClass().getSimpleName() + " 组件正在运行...");
			String line = contexts.getLine();
			String[] result = line.split(separator);
			contexts.setMap(transtTo(result));
			logger.info(this.getClass().getSimpleName() + " 组件运行结果" + transtTo(result));
		}
		chain.doFilter(contexts, chain);
	}
}
