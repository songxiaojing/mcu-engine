package com.topsec.bdc.mcu.engine.workflow.resource.input;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;


public interface IInputResource extends IConfiguration {

    public Object readResource() throws Exception;
}
