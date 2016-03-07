package com.topsec.bdc.mcu.engine.workflow.resource;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;


public interface IInputResource extends IConfiguration {

    public Object readResource() throws Exception;
}
