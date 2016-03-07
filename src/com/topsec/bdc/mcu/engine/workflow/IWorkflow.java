package com.topsec.bdc.mcu.engine.workflow;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;
import com.topsec.bdc.mcu.engine.workflow.driver.IDriverEngin;
import com.topsec.bdc.mcu.engine.workflow.resource.IInputResource;
import com.topsec.bdc.mcu.engine.workflow.resource.IOutputResource;
import com.topsec.bdc.platform.core.exception.PlatformException;
import com.topsec.bdc.platform.core.services.IService;


public interface IWorkflow extends IConfiguration, IService {

    public void setDriver(Class<? extends IDriverEngin> driver);

    public boolean doWork() throws PlatformException;

    public boolean caneclWork() throws PlatformException;

    public WorkflowResult workflowResult();

    public IInputResource[] getInResources();

    public IOutputResource[] getOutResource();
}
