package com.topsec.bdc.mcu.engine.executor;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;
import com.topsec.bdc.platform.core.exception.PlatformException;


public interface IExecutor extends IConfiguration {

    public Object initExecutorContext(Object... configurations) throws PlatformException;

    public Object getExecutorContext();

    public void destroyExecutorContext() throws PlatformException;
}
