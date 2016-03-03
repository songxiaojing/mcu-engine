package com.topsec.bdc.mcu.engine.data.transformat;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;
import com.topsec.bdc.mcu.engine.data.CalculateData;
import com.topsec.bdc.mcu.engine.exception.TransformatException;


/**
 * 
 * 列转换接口.
 * 
 * 各种去列进行转换与派生都需要实现此接口.
 * 
 * @title ITransformat
 * @package com.topsec.bdc.mcu.engine.data.transformat
 * @author baiyanwei
 * @version
 * @date Mar 3, 2016
 * 
 */
public interface ITransformat extends IConfiguration {

    /**
     * 转换列值.
     * 
     * @param rowData
     * @return
     * @throws TransformatException
     */
    public CalculateData[] transformat(CalculateData[] rowData) throws TransformatException;

}