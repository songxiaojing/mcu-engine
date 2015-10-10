package com.topsec.bdc.mcu.engine.test.components;

import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topsec.bdc.mcu.engine.test.entity.Contexts;
import com.topsec.bdc.mcu.engine.test.filter.Filter;
import com.topsec.bdc.mcu.engine.test.filter.FilterChain;


public class EasyFiltersComponent extends Component implements Filter {
	private static Logger logger = LoggerFactory.getLogger(EasyFiltersComponent.class);
	
	@Override
	public void doFilter(Contexts contexts, FilterChain chain) throws Exception {
		if(contexts.isFirst()) {
			logger.info(this.getClass().getSimpleName() + "	组件一正在运行...");
		}else {
			logger.info(this.getClass().getSimpleName() + " 组件正在运行...");
			HashMap<String, Object> map = contexts.getMap();
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				if(key.contains("银行")) {
					it.remove();
					map.remove(key);
				}
			}
			contexts.setMap(map);
			logger.info(this.getClass().getSimpleName() + " 组件运行结果" + map);
		}
		chain.doFilter(contexts, chain);
	}
	
}
