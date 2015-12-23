package com.topsec.bdc.mcu.engine.operations;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;
import com.topsec.bdc.platform.core.exception.PlatformException;


/**
 * 
 * 基于平台的所有可计算行为的规定.
 * 
 * 所有平台中的计算行为必须实现此接口定义.
 * 
 * @title ICalculable
 * @package com.topsec.bdc.mcu.engine.actions
 * @author baiyanwei
 * @version
 * @date Oct 8, 2015
 * 
 */
public interface ICalculable extends IConfiguration {

    /**
     * 数字型计算类别.
     */
    public final static int CALCUATE_TYPE_NUMBER = 0;
    /**
     * 字符型计算类别.
     */
    public final static int CALCUATE_TYPE_TEXT = 1;
    /**
     * 集合型计算类别.
     */
    public final static int CALCUATE_TYPE_RANGE = 2;

    /**
     * 执行数据计算动作.
     * 
     * @param task
     * @return
     * @throws PlatformException
     */
    public Object[] calculate(Object... elements) throws PlatformException;

    /**
     * 取得计算类别.
     * 
     * @return
     */
    public int getCalculateType();

    /**
     * 设置计算类别.
     * 
     * @param calculateType
     */
    public void setCalculateType(int calculateType);
}
