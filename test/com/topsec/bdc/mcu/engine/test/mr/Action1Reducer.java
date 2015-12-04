package com.topsec.bdc.mcu.engine.test.mr;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Action1Reducer extends Reducer<Text, Text, Text, NullWritable> {

	private static Logger log = LoggerFactory.getLogger(Action1Reducer.class);

	@Override
	protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		System.out.println(" >>> Action1Reducer accept value : " + values);
		context.write(key, NullWritable.get());
		log.info(" Action1Reducer has success !");
	}

	@Override
	protected void setup(Context context) throws IOException, InterruptedException {

	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {

	}

}