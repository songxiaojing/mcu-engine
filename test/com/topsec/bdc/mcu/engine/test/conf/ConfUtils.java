package com.topsec.bdc.mcu.engine.test.conf;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;


public class ConfUtils {

    private static String mapreduceYarn = "local";
    private static String yarnResourceAddress = "192.168.56.14:8032";
    public static String fsDefaultName = "hdfs://192.168.56.14:9000";
    
    public static Configuration conf = null;
    public static Connection conn = null;
    public static Admin admin = null;
    static {
        try {
            conf = HBaseConfiguration.create();
            conf.set("hbase.zookeeper.quorum", "192.168.56.14:2181");
            conn = ConnectionFactory.createConnection(conf);
            admin = conn.getAdmin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Configuration getConfiguration(boolean localconf) {
    	if(localconf == true) {
    		return getLocalConfiguration();
    	}else {
    		return getRemoteConfiguration();
    	}
    }

    public static Configuration getRemoteConfiguration() {

        return new Configuration();
    }

    public static Configuration getLocalConfiguration() {

        Configuration conf = new Configuration();
        conf.set("mapreduce.framework.name", mapreduceYarn);
        conf.set("yarn.resourcemanager.address", yarnResourceAddress);
        conf.set("fs.defaultFS", fsDefaultName);

        return conf;
    }

}
