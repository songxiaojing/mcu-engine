package com.topsec.bdc.mcu.engine.services;

import com.topsec.bdc.mcu.engine.workflow.IWorkflow;
import com.topsec.bdc.mcu.engine.workflow.driver.DriverStatus;
import com.topsec.bdc.mcu.engine.workflow.driver.IDriverEngin;
import com.topsec.bdc.platform.core.exception.PlatformException;
import com.topsec.bdc.platform.core.metrics.AbstractMetricMBean;
import com.topsec.bdc.platform.core.services.IService;


/**
 * 
 * 数据处理引擎.
 * 
 * 提供选择处理驱动，转化配置为可执行任务，执行任务，上报状态，返回执行结果，统计处理状态信息，自身的心跳信息.
 * 
 * @title DriverEngineService
 * @package com.topsec.bdc.mcu.engine.services
 * @author baiyanwei
 * @version
 * @date Dec 23, 2015
 * 
 */
public class DriverEngineService extends AbstractMetricMBean implements IService {

    @Override
    public void start() throws Exception {

        // TODO Auto-generated method stub

    }

    @Override
    public void stop() throws Exception {

        // TODO Auto-generated method stub

    }

    /**
     * 执行数据处理流程.
     * 
     * @param workflowContext
     * @throws PlatformException
     */
    public IWorkflow fireWorkflow(String workflowContext) throws PlatformException {

        return null;
    }

    /**
     * 取消数据处理流的执行.
     * 
     * @param workflow
     */
    public boolean cancelWorkflow(IWorkflow workflow) throws PlatformException {

        return true;
    }

    /**
     * Your Methods description is in here.
     * 
     * @return
     * @throws PlatformException
     */
    public DriverStatus reportWorkflowStatus() throws PlatformException {

        return null;
    }

    /**
     * 注消驱动.
     * 
     * @param driver
     */
    public void unregisterDriver(Class<? extends IDriverEngin> driver) {

    }

    /**
     * 注册驱动.
     * 
     * @param driver
     */
    public void registerDriver(Class<? extends IDriverEngin> driver) {

    }

    /**
     * 报告引擎状态.
     * 
     * @return
     */
    public String reportEngineStatus() {

        return null;
    }

    public String listDriver() {

        return null;
    }
}
