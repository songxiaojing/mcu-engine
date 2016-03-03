package com.topsec.bdc.mcu.engine.workflow.operations.calculate;

import com.topsec.bdc.mcu.engine.workflow.operations.IOperation;
import com.topsec.bdc.platform.core.configuration.GenericConfiguration;


public interface ICalculateOperation extends IOperation {

    /**
     * 取得本操作的ID.
     * 
     * @return
     */
    public String getOperationID();

    /**
     * 设置操作ID.
     * 
     * @param operationID
     */
    public void setOperationID(String operationID);

    /**
     * 取得操作的执行顺序.
     * 
     * @return
     */
    public int getOperationOrder();

    /**
     * 设置操作执行顺序.
     * 
     * @param operationOrder
     */
    public void setOperationOrder(int operationOrder);

    /**
     * 对操作进行行为配置.
     * 
     * @param operationConfiguration
     */
    public void configure(GenericConfiguration operationConfiguration);

}