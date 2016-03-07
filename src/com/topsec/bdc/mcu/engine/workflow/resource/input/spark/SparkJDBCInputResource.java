package com.topsec.bdc.mcu.engine.workflow.resource.input.spark;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

import com.topsec.bdc.mcu.engine.workflow.resource.input.ISparkInputResource;


public class SparkJDBCInputResource implements ISparkInputResource {

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
    public RDD readResource() throws Exception {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSparkContext(JavaSparkContext jsc) {

        // TODO Auto-generated method stub

    }

}
