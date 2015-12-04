package com.topsec.bdc.mcu.engine.operations;

import com.topsec.bdc.platform.core.configuration.GenericConfiguration;


/**
 * 
 * 定义所有基于动作中数据处理操作的行为.
 * 
 * 定义所有基于动作中数据处理操作的行为.
 * 
 * @title IDataOperation
 * @package com.topsec.bdc.mcu.engine.actions
 * @author baiyanwei
 * @version
 * @date Oct 8, 2015
 * 
 */
public interface IDataOperation extends ICalculable {

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