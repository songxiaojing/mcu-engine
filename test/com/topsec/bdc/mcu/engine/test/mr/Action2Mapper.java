package com.topsec.bdc.mcu.engine.test.mr;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topsec.bdc.mcu.engine.test.components.EasyRowParseComponent;

@SuppressWarnings("all")
public class Action2Mapper extends Mapper<LongWritable, Text, Text, Text> {
	private Text word = new Text();
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {

	}

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		try {
			String line = value.toString();
			EasyRowParseComponent opr = new EasyRowParseComponent();
			String result = "";
			word.set(result);
			context.write(word,word);
		} catch (Exception e) {
		}
	}

	@Override
	protected void cleanup(org.apache.hadoop.mapreduce.Mapper.Context context) throws IOException, InterruptedException {
	}

}