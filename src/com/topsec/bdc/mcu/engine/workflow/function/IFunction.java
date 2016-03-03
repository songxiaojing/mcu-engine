package com.topsec.bdc.mcu.engine.workflow.function;

import java.util.List;

import com.topsec.bdc.mcu.engine.data.CalculateData;


public interface IFunction {

    public void doFunction(CalculateData calculateData);

    public void setOperations(List operations);
}