package com.topsec.bdc.mcu.engine.driver;

import com.topsec.bdc.mcu.engine.workflow.IWorkflow;
import com.topsec.bdc.mcu.engine.workflow.WorkflowResult;
import com.topsec.bdc.platform.core.exception.PlatformException;
import com.topsec.bdc.platform.core.services.IService;


/**
 * 
 * 驱动接口.
 * 
 * 驱动接口.
 * 
 * @title SparkJavaContextClient
 * @package com.topsec.tss.dms.spark.client
 * @author baiyanwei
 * @version
 * @date Nov 10, 2015
 * 
 */
public interface IDriver extends IService {

    /**
     * 初始化驱动的上下文.
     * 
     * @param configurations
     * @return
     * @throws PlatformException
     */
    public Object initDriverContext(Object... configurations) throws PlatformException;

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
     * 报告驱动状态.
     * 
     * @return
     */
    public DriverStatus reportDriverStatus();

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

    /**
     * Your Methods description is in here.
     * 
     * @return
     */
    public String getVersion();

    /**
     * Your Methods description is in here.
     * 
     * @param version
     * @return
     */
    public String setVersion(String version);

}