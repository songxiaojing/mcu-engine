package com.topsec.bdc.mcu.engine.test.actions;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.topsec.bdc.mcu.engine.test.entity.Params;

/**
 * 
 * @author Administrator
 *
 */
public abstract class Action {
	
	protected void run(Params params) throws Exception{
		Configuration conf = params.getConf();
        Job job = Job.getInstance(conf, this.getClass().getName());
        job.setJarByClass(params.getJarByclass());
        job.setMapperClass(params.getMapclass());
        FileInputFormat.addInputPath(job, params.getInputPath());

        //reduce
        job.setReducerClass(params.getReducerclass());
        //job.setNumReduceTasks(Integer.parseInt(args[3]));
        job.setOutputKeyClass(params.getOutKeyclass());
        job.setOutputValueClass(params.getOutValueclass());
        FileOutputFormat.setOutputPath(job, params.getOutPath());

        job.waitForCompletion(true);
	}
}
