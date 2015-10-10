package com.topsec.bdc.mcu.engine.test.entity;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class Params {
	private Configuration conf;
	private Class<? extends Mapper> mapclass;
	private Class<? extends Reducer> combileclass;
	private Class<? extends Reducer> reducerclass;
	private Class<?> outKeyclass;
	private Class<?> outValueclass;
	private Path inputPath;
	private Path outPath;
	private Class<?> jarByclass;
	
	public Class<?> getJarByclass() {
		return jarByclass;
	}
	public void setJarByclass(Class<?> jarByclass) {
		this.jarByclass = jarByclass;
	}
	public Configuration getConf() {
		return conf;
	}
	public void setConf(Configuration conf) {
		this.conf = conf;
	}
	public Class<? extends Mapper> getMapclass() {
		return mapclass;
	}
	public void setMapclass(Class<? extends Mapper> mapclass) {
		this.mapclass = mapclass;
	}
	public Class<? extends Reducer> getCombileclass() {
		return combileclass;
	}
	public void setCombileclass(Class<? extends Reducer> combileclass) {
		this.combileclass = combileclass;
	}
	public Class<? extends Reducer> getReducerclass() {
		return reducerclass;
	}
	public void setReducerclass(Class<? extends Reducer> reducerclass) {
		this.reducerclass = reducerclass;
	}
	public Class<?> getOutKeyclass() {
		return outKeyclass;
	}
	public void setOutKeyclass(Class<?> outKeyclass) {
		this.outKeyclass = outKeyclass;
	}
	public Class<?> getOutValueclass() {
		return outValueclass;
	}
	public void setOutValueclass(Class<?> outValueclass) {
		this.outValueclass = outValueclass;
	}
	public Path getInputPath() {
		return inputPath;
	}
	public void setInputPath(Path inputPath) {
		this.inputPath = inputPath;
	}
	public Path getOutPath() {
		return outPath;
	}
	public void setOutPath(Path outPath) {
		this.outPath = outPath;
	}
}
