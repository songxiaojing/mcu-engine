package com.topsec.bdc.mcu.engine.workflow;

import com.topsec.bdc.mcu.engine.configuration.IConfiguration;
import com.topsec.bdc.platform.core.services.ILife;


/**
 * @author baiyanwei Jul 18, 2013
 * 
 * 
 *         The main Logic unit in MCA, work to create operation resource ,handle operation , execute job on sort, collect operation return message, limit running time.
 * 
 */
public interface IWorkflow extends IConfiguration, ILife {

}
