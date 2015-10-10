package com.topsec.bdc.mcu.engine.test.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Action3Mapper extends Mapper<LongWritable, Text, Text, Text> {
	private Text word = new Text();
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {

	}

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		try {
			System.out.println(" >>> Action-3-Map accept value : " + value);
			word.set(" Action-3-Map");
			context.write(word,word);
		} catch (Exception e) {
		}
	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
	}

}