package com.topsec.bdc.mcu.engine.configuration;

import java.io.Serializable;


/**
 * 
 * 数据汇入元素配置接口.
 * 
 * 数据汇入元素配置接口.
 * 
 * @title IConfiguration
 * @package com.topsec.bdc.mcu.engine.configuration
 * @author baiyanwei
 * @version
 * @date Dec 21, 2015
 * 
 */
public interface IConfiguration extends Serializable {

    /**
     * 取得类型.
     * 
     * @return
     */
    public String getType();

    /**
     * 设置类型.
     * 
     * @param type
     */
    public void setType(String type);

    /**
     * 取得配置内容.
     * 
     * @return
     */
    public String getConfiguration();

    /**
     * 设置配置内容.
     * 
     * @param configuration
     */
    public void setConfiguration(String configuration);

}
