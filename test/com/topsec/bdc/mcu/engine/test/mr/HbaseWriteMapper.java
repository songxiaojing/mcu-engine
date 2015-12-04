package com.topsec.bdc.mcu.engine.test.mr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.chain.ChainMapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.NullOutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topsec.bdc.mcu.engine.test.conf.ConfUtils;

/**
 * 
 * @author Administrator
 *
 */
public class HbaseWriteMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	protected Logger log = LoggerFactory.getLogger(HbaseWriteMapper.class);

	List<Put> lists = null;
	Table table = null;
	
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {

		try {
			lists = new ArrayList<Put>();
			if(!ConfUtils.admin.tableExists(TableName.valueOf("test_3"))) {
				HTableDescriptor hd = new HTableDescriptor(TableName.valueOf("test_3"));
				hd.addFamily(new HColumnDescriptor("f_1"));
				ConfUtils.admin.createTable(hd);
			}
			table = ConfUtils.conn.getTable(TableName.valueOf("test_3"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);// 将错误信息抛出到控制台上
		}

	}

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		try {
			String line = value.toString();

			if (line == null || line.trim().length() == 0) {
				log.info("空行不处理!");
				return;
			}
			Put put = new Put(Bytes.toBytes("rk_" + key));
			put.addColumn(Bytes.toBytes("f_1"), Bytes.toBytes("mes"), Bytes.toBytes(line));
			lists.add(put);
		} catch (Exception e) {
			e.getMessage();
			log.error("错误数据:" + value);
			return;
		}
	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
		table.put(lists);
		table.close();
	}
	
	public static void main(String[] args) throws Exception {
		String hdfsPath = "hdfs://192.168.56.14:9000/test";
		
		Configuration conf = ConfUtils.getLocalConfiguration();

		Job job = new Job(conf, HbaseWriteMapper.class.getName());
		job.setJarByClass(HbaseWriteMapper.class);// 很重要，否则提示类找不到
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(NullOutputFormat.class);// 取消输出
		job.setNumReduceTasks(0);
		FileInputFormat.setInputPaths(job, hdfsPath);// 输入

		ChainMapper.addMapper(job, HbaseWriteMapper.class, LongWritable.class, Text.class, Text.class, Text.class, conf);
		job.waitForCompletion(true);
	}
	
}