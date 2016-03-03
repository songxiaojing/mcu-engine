package com.topsec.bdc.mcu.engine.workflow.driver;

import com.topsec.bdc.mcu.engine.workflow.IWorkflow;
import com.topsec.bdc.mcu.engine.workflow.WorkflowResult;
import com.topsec.bdc.platform.core.exception.PlatformException;


/**
 * 
 * 数据汇入引擎接口.
 * 
 * .
 * 
 * @title IDriverEngin
 * @package com.topsec.bdc.mcu.engine.workflow.driver
 * @author baiyanwei
 * @version
 * @date Mar 3, 2016
 * 
 */
public interface IDriverEngin {

    public void setConfiguration();

    public void readInputStream();

    public void persistToOutputStream();

    public void start();

    public void stop();

    public void execute();

    /**
     * 初始化驱动的上下文.
     * 
     * @param configurations
     * @return
     * @throws PlatformException
     */
    public void initDriverContext() throws PlatformException;

    /**
     * 取得的配置上下文.
     * 
     * @return
     */
    public Object getDriverContext();

    /**
     * 销毁驱动.
     * 
     * @throws PlatformException
     */
    public void destroyDriverContext() throws PlatformException;

    /**
     * 执行工作流.
     * 
     * @param workflow
     * @return
     * @throws PlatformException
     */
    public WorkflowResult runWorkflow(IWorkflow workflow) throws PlatformException;

    /**
     * 转化生成驱动适合的工作流.
     * 
     * @param workflowContext
     * @return
     * @throws PlatformException
     */
    public IWorkflow transformWorkflow(String workflowContext) throws PlatformException;

    /**
     * 注消驱动.
     * 
     * @param driverHolder
     */
    public void unregisterDriver(String driverHolder);

    /**
     * 注册驱动到引擎服务中.
     * 
     * @param driverHolder
     */
    public void registerDriver(String driverHolder);

}