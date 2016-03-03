package com.topsec.bdc.mcu.engine.data.calculate;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;
import com.topsec.bdc.mcu.engine.data.CalculateData;


/**
 * 
 * 集合计算接口.
 * 
 * .
 * 
 * @title IAggregateCalculable
 * @package com.topsec.bdc.mcu.engine.data.calculate
 * @author baiyanwei
 * @version
 * @date Mar 3, 2016
 * 
 */
public interface IAggregateCalculable extends IConfiguration {

    public void setCalculateData(CalculateData[] calculateData);

    public CalculateData[] getCalculateData();

    public String lastCalculateType();

    public IAggregateCalculable calculate(String typeCalculate, CalculateData[] calculateData);
}