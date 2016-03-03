package com.topsec.bdc.mcu.engine.workflow.executor;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;


/**
 * 
 * 工作流片段执行器.
 * 
 * .
 * 
 * @title IExecutor
 * @package com.topsec.bdc.mcu.engine.workflow.ILayerExecutor
 * @author baiyanwei
 * @version
 * @date Mar 3, 2016
 * 
 */
public interface ILayerExecutor extends IConfiguration {

    /**
     * 执行工作流片段.
     * 
     * @param rdd
     * @return
     */
    public Object executeLayer(Object rdd);

}
