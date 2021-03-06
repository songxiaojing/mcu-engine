package com.topsec.bdc.mcu.engine.workflow.resource.input;

/**
 * 
 * 输入数据源类型.
 * 
 * .
 * 
 * @title InputResource
 * @package com.topsec.bdc.mcu.engine.resource.input
 * @author baiyanwei
 * @version
 * @date Feb 25, 2016
 * 
 */
public enum InputResourceType {
    INPUT_TXT_DIRECTORY("InputResource.txtDirectory"),
    INPUT_TXT_FILE("InputResource.txtFile");

    private final String _type;

    private InputResourceType(String type) {

        this._type = type;
    }

    public String type() {

        return this._type;
    }

    @Override
    public String toString() {

        return _type;
    }
}
