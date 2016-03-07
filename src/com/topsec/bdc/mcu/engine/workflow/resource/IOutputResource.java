package com.topsec.bdc.mcu.engine.workflow.resource;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;


public interface IOutputResource extends IConfiguration {

    public Object writeResource() throws Exception;
}
