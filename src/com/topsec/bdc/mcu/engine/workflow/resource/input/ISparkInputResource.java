package com.topsec.bdc.mcu.engine.workflow.resource.input;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

import com.topsec.bdc.mcu.engine.workflow.resource.IInputResource;


public interface ISparkInputResource extends IInputResource {

    public RDD readResource() throws Exception;

    public void setSparkContext(JavaSparkContext jsc);
}
