package com.topsec.bdc.mcu.engine.data.transformat.ip;

import com.topsec.bdc.mcu.engine.data.CalculateData;
import com.topsec.bdc.mcu.engine.data.transformat.ITransformat;
import com.topsec.bdc.mcu.engine.exception.TransformatException;


/**
 * 
 * IP地址V4版本转换器.
 * 
 * 192.168.69.6->565255.
 * 
 * @title IPv4Transformat
 * @package com.topsec.bdc.mcu.engine.data.transformat.ip
 * @author baiyanwei
 * @version
 * @date Mar 3, 2016
 * 
 */
public class IPv4Transformat implements ITransformat {

    /**
     * Your field description in here.
     */
    private static final long serialVersionUID = -6289636550588341640L;

    @Override
    public String getType() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setType(String type) {

        // TODO Auto-generated method stub

    }

    @Override
    public String getConfiguration() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setConfiguration(String configuration) {

        // TODO Auto-generated method stub

    }

    @Override
    public CalculateData[] transformat(CalculateData[] rowData) throws TransformatException {

        // TODO Auto-generated method stub
        return null;
    }

}