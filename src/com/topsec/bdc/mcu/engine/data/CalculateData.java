package com.topsec.bdc.mcu.engine.data;

/**
 * 
 * 计算数据对象.
 * 
 * 在RDD中使用BYTE为向下传递数据.
 * 
 * @title CalculateData
 * @package com.topsec.bdc.mcu.engine.calculate
 * @author baiyanwei
 * @version
 * @date Mar 1, 2016
 * 
 */
public class CalculateData {

    public byte[] _bytes = null;
    public Class<?> _type = null;

    public CalculateData(Object data) {

        transformat(data);
    }

    /**
     * Your Methods description is in here.
     * 
     * @param data
     */
    private void transformat(Object data) {

        //TODO IMP
    }

    public byte[] valueBytes() {

        return this._bytes;
    }

    public Class<?> valueType() {

        return this._type;
    }
}