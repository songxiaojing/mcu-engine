package com.topsec.bdc.mcu.driver.spark;

import com.topsec.bdc.mcu.engine.workflow.IWorkflow;
import com.topsec.bdc.mcu.engine.workflow.WorkflowResult;
import com.topsec.bdc.mcu.engine.workflow.driver.IDriverEngin;
import com.topsec.bdc.platform.core.exception.PlatformException;


/**
 * 
 * SPARK驱动引擎.
 * 
 * .
 * 
 * @title SparkDriverEngine
 * @package com.topsec.bdc.mcu.engine.workflow.driver.spark
 * @author baiyanwei
 * @version
 * @date Mar 3, 2016
 * 
 */
public class SparkDriverEngine implements IDriverEngin {

    @Override
    public void setConfiguration() {

        // TODO Auto-generated method stub

    }

    @Override
    public void readInputStream() {

        // TODO Auto-generated method stub

    }

    @Override
    public void persistToOutputStream() {

        // TODO Auto-generated method stub

    }

    @Override
    public void start() {

        // TODO Auto-generated method stub

    }

    @Override
    public void stop() {

        // TODO Auto-generated method stub

    }

    @Override
    public void execute() {

        // TODO Auto-generated method stub

    }

    @Override
    public void initDriverContext() throws PlatformException {

        // TODO Auto-generated method stub

    }

    @Override
    public Object getDriverContext() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void destroyDriverContext() throws PlatformException {

        // TODO Auto-generated method stub

    }

    @Override
    public WorkflowResult runWorkflow(IWorkflow workflow) throws PlatformException {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IWorkflow transformWorkflow(String workflowContext) throws PlatformException {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void unregisterDriver(String driverHolder) {

        // TODO Auto-generated method stub

    }

    @Override
    public void registerDriver(String driverHolder) {

        // TODO Auto-generated method stub

    }
}