package com.topsec.bdc.mcu.driver.spark.resource.output;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

import com.topsec.bdc.mcu.driver.spark.resource.ISparkOutputResource;


public class SparkJDBCOutputResource implements ISparkOutputResource {

    @Override
    public Object writeResource() throws Exception {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getType() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setType(String type) {

        // TODO Auto-generated method stub

    }

    @Override
    public String getConfiguration() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setConfiguration(String configuration) {

        // TODO Auto-generated method stub

    }

    @Override
    public void readResource(RDD rdd) throws Exception {

        // TODO Auto-generated method stub

    }

    @Override
    public void setSparkContext(JavaSparkContext jsc) {

        // TODO Auto-generated method stub

    }
}
