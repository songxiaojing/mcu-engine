package com.topsec.bdc.mcu.engine.workflow.operations;

import java.util.Set;


public interface IOperation {

    public void setCalculateRange(Class targetClass);

    public void checkCalculate(Class calculateDataType);

    public void doCalculate(Set calculateDataSet);
}