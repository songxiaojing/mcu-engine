package com.topsec.bdc.mcu.engine.actions;

import java.util.List;

import com.topsec.bdc.mcu.engine.operations.DataOperation;
import com.topsec.bdc.platform.core.configuration.GenericConfiguration;
import com.topsec.bdc.platform.core.exception.PlatformException;


public interface IAction {

    /**
     * 取得本操作的ID.
     * 
     * @return
     */
    public String getActionID();

    /**
     * 设置操作ID.
     * 
     * @param ActionID
     */
    public void setActionID(String ActionID);

    /**
     * 取得操作的执行顺序.
     * 
     * @return
     */
    public int getActionOrder();

    /**
     * 设置操作执行顺序.
     * 
     * @param ActionOrder
     */
    public void setActionOrder(int ActionOrder);

    /**
     * 取得操作的执行顺序.
     * 
     * @return
     */
    public List<DataOperation> getOperations();

    /**
     * 设置操作执行顺序.
     * 
     * @param ActionOrder
     */
    public void setOperations(List<DataOperation> dataOperationList);

    /**
     * 对操作进行行为配置.
     * 
     * @param ActionConfiguration
     */
    public void configure(GenericConfiguration actionConfiguration);

    /**
     * Your Methods description is in here.
     * 
     * @param config
     * @return
     * @throws PlatformException
     */
    public Object doAction(Object config) throws PlatformException;
}
