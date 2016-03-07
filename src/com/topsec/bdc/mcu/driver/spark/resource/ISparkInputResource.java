package com.topsec.bdc.mcu.driver.spark.resource;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

import com.topsec.bdc.mcu.engine.workflow.resource.input.IInputResource;


public interface ISparkInputResource extends IInputResource {

    public RDD readResource() throws Exception;

    public void setSparkContext(JavaSparkContext jsc);
}
