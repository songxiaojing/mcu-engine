package com.topsec.bdc.mcu.driver.spark.function;

import java.util.List;

import com.topsec.bdc.mcu.engine.data.CalculateData;


public interface ISparkFunction {

    public void doFunction(CalculateData calculateData);

    public void setOperations(List operations);
}