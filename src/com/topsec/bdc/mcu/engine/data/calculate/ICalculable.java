package com.topsec.bdc.mcu.engine.data.calculate;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;
import com.topsec.bdc.mcu.engine.data.CalculateData;
import com.topsec.bdc.mcu.engine.exception.CalculateException;


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
     * 执行数据计算动作.
     * 
     * @param calculateType
     * @param calculateData
     * @return
     * @throws CalculateException
     */
    public ICalculable calculate(String calculateType, CalculateData calculateData) throws CalculateException;

    /**
     * 取得最后计算类别.
     * 
     * @return
     */
    public String lastCalculateType();

    /**
     * 设置当前值.
     * 
     * @param calculateType
     */
    public void setCalculateData(CalculateData calculateData);

    /**
     * 取得当前值.
     * 
     * @return
     */
    public CalculateData getCalculateData();
}
