package com.topsec.bdc.mcu.engine.test;

import java.util.HashMap;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;

import com.topsec.bdc.mcu.engine.test.actions.Test1Action;
import com.topsec.bdc.mcu.engine.test.actions.Test2Action;
import com.topsec.bdc.mcu.engine.test.actions.Test3Action;
import com.topsec.bdc.mcu.engine.test.conf.ConfUtils;
import com.topsec.bdc.mcu.engine.test.entity.Contexts;
import com.topsec.bdc.mcu.engine.test.entity.Params;
import com.topsec.bdc.mcu.engine.test.filter.FilterChain;
import com.topsec.bdc.mcu.engine.test.hdfs.HdfsUtils;
import com.topsec.bdc.mcu.engine.test.mr.Action1Mapper;
import com.topsec.bdc.mcu.engine.test.mr.Action1Reducer;
import com.topsec.bdc.mcu.engine.test.mr.Action2Mapper;
import com.topsec.bdc.mcu.engine.test.mr.Action2Reducer;
import com.topsec.bdc.mcu.engine.test.mr.Action3Mapper;
import com.topsec.bdc.mcu.engine.test.mr.Action3Reducer;


public class RunTest {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("HADOOP_USER_NAME", "hdfs");
		ExecuteClient client = new ExecuteClient();
		Path path = new Path("hdfs://192.168.56.14:9000/t");

		String rootPath = "hdfs://192.168.56.14:9000";
		
		Params param = new Params();
		param.setJarByclass(RunTest.class);
		param.setMapclass(Action1Mapper.class);
		param.setReducerclass(Action1Reducer.class);
		param.setInputPath(path);
		param.setOutKeyclass(Text.class);
		param.setOutValueclass(Text.class);
		param.setOutPath(new Path(rootPath + "/action1"));
		param.setConf(ConfUtils.getLocalConfiguration());
		
		Params param1 = new Params();
		param1.setJarByclass(RunTest.class);
		param1.setMapclass(Action2Mapper.class);
		param1.setReducerclass(Action2Reducer.class);
		param1.setInputPath(param.getOutPath());
		param1.setOutKeyclass(Text.class);
		param1.setOutValueclass(Text.class);
		param1.setOutPath(new Path(rootPath + "/action2"));
		param1.setConf(ConfUtils.getLocalConfiguration());
		
		Params param2 = new Params();
		param2.setJarByclass(RunTest.class);
		param2.setMapclass(Action3Mapper.class);
		param2.setReducerclass(Action3Reducer.class);
		param2.setInputPath(param1.getOutPath());
		param2.setOutKeyclass(Text.class);
		param2.setOutValueclass(Text.class);
		param2.setOutPath(new Path(rootPath + "/action3"));
		param2.setConf(ConfUtils.getLocalConfiguration());

		HdfsUtils.getInstance().delete("/action1","/action2","/action3");
		
		
		FilterChain chain = new FilterChain();
		
		chain.addFilters(new Test1Action());
		chain.addFilters(new Test2Action());
		chain.addFilters(new Test3Action());
		
		HashMap<String, Params> actionParamsMap = new HashMap<String, Params>();
		actionParamsMap.put(Test1Action.class.getSimpleName(), param);
		actionParamsMap.put(Test2Action.class.getSimpleName(), param1);
		actionParamsMap.put(Test3Action.class.getSimpleName(), param2);
		
		Contexts ct = new Contexts();
		ct.setActionParamsMap(actionParamsMap);
		
		client.setInitParams(ct, chain);
		
		client.start();
	}
}
