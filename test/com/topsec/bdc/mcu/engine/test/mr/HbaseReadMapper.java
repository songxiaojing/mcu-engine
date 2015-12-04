package com.topsec.bdc.mcu.engine.test.mr;

import java.io.IOException;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.NullOutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topsec.bdc.mcu.engine.test.conf.ConfUtils;

public class HbaseReadMapper extends TableMapper<Text, Text> {
	
	private static final Logger logger = LoggerFactory.getLogger(HbaseReadMapper.class);
	
    private static String bytes2String(byte[] name) {

        if (name == null || name.length == 0) {
            return null;
        }
        return Bytes.toString(name);
    }

    
    
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
    	
    }

    public void map(ImmutableBytesWritable row, Result result, Context context) throws InterruptedException, IOException {

        logger.info(Bytes.toString(row.get()));

        for (Cell cell : result.listCells()) {
            logger.info("rowkey-content : " + CellUtil.getCellKeyAsString(cell));
            logger.info("rowkey : " + bytes2String(CellUtil.cloneRow(cell)));
            logger.info("family : " + bytes2String(CellUtil.cloneFamily(cell)));
            logger.info("column : " + bytes2String(CellUtil.cloneQualifier(cell)));
            logger.info("values : " + bytes2String(CellUtil.cloneValue(cell)));
            logger.info("Ttimes : " + String.valueOf(cell.getTimestamp()));
            logger.info("-----------------------------");
        }
    }
    
    protected void cleanup(Context context) throws IOException, InterruptedException {
    	
    }
    
	public static void main(String[] args) throws Exception {

        String tableName = "test_3";

		Job job = Job.getInstance(ConfUtils.conf, "hbase client run");
        job.setJarByClass(HbaseReadMapper.class);     // class that contains mapper
        job.setNumReduceTasks(0);
        Scan scan = new Scan();
        scan.setCaching(500);        // 1 is the default in Scan, which will be bad for MapReduce jobs
        scan.setCacheBlocks(false);  // don't set to true for MR jobs

        TableMapReduceUtil.initTableMapperJob(
                tableName,        // input HBase table name
                scan,             // Scan instance to control CF and attribute selection
                HbaseReadMapper.class,   // mapper
                null,             // mapper output key
                null,             // mapper output value
                job, false);
        job.setOutputFormatClass(NullOutputFormat.class);   // because we aren't emitting anything from mapper

        boolean b = job.waitForCompletion(true);
        if (!b) {
            throw new IOException("error with job!");
        }
    }
}