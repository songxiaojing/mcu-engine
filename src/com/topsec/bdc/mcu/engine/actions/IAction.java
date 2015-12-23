package com.topsec.bdc.mcu.engine.actions;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;
import com.topsec.bdc.mcu.engine.resource.IInResource;
import com.topsec.bdc.mcu.engine.resource.IOutResource;
import com.topsec.bdc.platform.core.exception.PlatformException;


/**
 * 
 * 数据处理接口.
 * 
 * 数据处理接口.
 * 
 * @title IAction
 * @package com.topsec.bdc.mcu.engine.actions
 * @author baiyanwei
 * @version
 * @date Dec 22, 2015
 * 
 */
public interface IAction extends IConfiguration {

    /**
     * 设置运行时的环境上下文如HADOOP，SPARK的配置.
     * 
     * @param context
     */
    public void setContext(Object... context);

    /**
     * 运行时的环境上下.
     * 
     * @return
     */
    public Object[] getContext();

    /**
     * 设置输入源.
     * 
     * @param inputResource
     */
    public void setInResource(IInResource... inResource);

    /**
     * 取得输入源.
     * 
     * @return
     */
    public IInResource[] getInputResource();

    /**
     * 设置输入源.
     * 
     * @param inputResource
     */
    public void setOutResource(IOutResource... outResources);

    /**
     * 取得输入源.
     * 
     * @return
     */
    public IOutResource[] getOutResource();

    /**
     * 生效动作与配置内容.
     * 
     * @param config
     * @return
     * @throws PlatformException
     */
    public Object[] fireAction(Object... referent) throws PlatformException;
}
