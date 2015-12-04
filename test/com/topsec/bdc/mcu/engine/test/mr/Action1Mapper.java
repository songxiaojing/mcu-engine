package com.topsec.bdc.mcu.engine.test.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topsec.bdc.mcu.engine.test.components.EasyFiltersComponent;
import com.topsec.bdc.mcu.engine.test.components.EasyRowParseComponent;
import com.topsec.bdc.mcu.engine.test.entity.Contexts;
import com.topsec.bdc.mcu.engine.test.filter.FilterChain;

public class Action1Mapper extends Mapper<LongWritable, Text, Text, Text> {
	
	private static Logger logger = LoggerFactory.getLogger(Action1Mapper.class);

	private Text word = new Text();
	FilterChain operationChain = null;
	Contexts contexts = null;
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		logger.info(" >>> xx Action 正在运行");
		contexts = new Contexts();
		operationChain = new FilterChain();
		operationChain.addFilters(new EasyRowParseComponent());
		operationChain.addFilters(new EasyFiltersComponent());
	}

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		try {
			String line = value.toString();
			contexts.setLine(line);
			operationChain.init();
			operationChain.doFilter(contexts, operationChain);
			context.write(word,word);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
	
	}

}