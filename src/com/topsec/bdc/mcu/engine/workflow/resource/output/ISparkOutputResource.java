package com.topsec.bdc.mcu.engine.workflow.resource.output;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

import com.topsec.bdc.mcu.engine.workflow.resource.IOutputResource;


public interface ISparkOutputResource extends IOutputResource {

    public void readResource(RDD rdd) throws Exception;

    public void setSparkContext(JavaSparkContext jsc);
}
