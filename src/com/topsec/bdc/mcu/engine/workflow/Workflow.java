package com.topsec.bdc.mcu.engine.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.DynamicMBean;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;

import com.topsec.bdc.mcu.engine.actions.DataAction;
import com.topsec.bdc.mcu.engine.driver.hadoop.hdfs.HadoopHDFSDriver;
import com.topsec.bdc.mcu.engine.operations.DataOperation;
import com.topsec.bdc.mcu.engine.operations.IDataOperation;
import com.topsec.bdc.platform.core.configuration.GenericConfiguration;
import com.topsec.bdc.platform.core.exception.PlatformException;
import com.topsec.bdc.platform.core.metrics.AbstractMetricMBean;
import com.topsec.bdc.platform.core.metrics.Metric;
import com.topsec.bdc.platform.core.services.IService;
import com.topsec.bdc.platform.log.PlatformLogger;


/**
 * @author baiyanwei Jul 18, 2013
 * 
 * 
 *         The main Logic unit in MCA, work to create operation resource ,handle operation , execute job on sort, collect operation return message, limit running time.
 * 
 */
public class Workflow extends AbstractMetricMBean implements IService, DynamicMBean {

    //
    //
    // Logging Object
    private static PlatformLogger theLogger = PlatformLogger.getLogger(Workflow.class);

    //
    // PUBLIC STATIC FINAL INSTANCE VARIABLES
    //
    public static final String OPERATION_EXTENSION_POINT_ID = "com.secpro.platform.monitoring.agent.metrics_collect_agent_operations";

    //
    // PRIVATE INSTANCE VARIABLES
    //
    private List<DataAction> _dataActionList = new ArrayList<DataAction>();
    private HashMap<String, String> _runtimeENV = new HashMap<String, String>();

    /*
     * Contains the list of operations that still need to be completed.
     */
    private HadoopHDFSDriver _driver = null;
    private Queue<DataAction> _completeActionList = new LinkedList<DataAction>();

    private DataAction _currentAction = null;

    private long _startTime = 0;

    private boolean _isBundle = true;

    //
    // TOTAL INFORMATION FIELDS
    //
    public static long _totalErrors = 0;
    @Metric(description = "total tasks")
    public static long _totalTasks = 0;
    @Metric(description = "total time of processing")
    public static long _totalTimeOfProcessing = 0;

    // objectName associates with this instance
    public String _jmxObjectName = null;

    public long totalErrors = 0;

    public long totalTasks = 0;

    protected Date _executedAt = null;
    //
    private Thread timer = null;

    //
    // CONSTRUCTOR
    //
    public Workflow() {

    }

    //
    // PUBLIC GETTER & SETTERS
    //

    public String toString() {

        return "";
    }

    //
    public boolean isBundle() {

        return this._isBundle;
    }

    public long getStartTime() {

        return _startTime;
    }

    public long getTotalTime() {

        return System.currentTimeMillis() - getStartTime();
    }

    public double getAverageTaskTime() {

        return (double) _totalTimeOfProcessing / (double) _totalTasks;
    }

    //
    // PUBLIC IService METHODS
    //
    @Override
    public void start() throws PlatformException {

        //_storageAdapter = ServiceHelper.findService(StorageAdapterService.class);

        IExtensionRegistry registry = RegistryFactory.getRegistry();
        IExtensionPoint point = registry.getExtensionPoint(OPERATION_EXTENSION_POINT_ID);
        if (point == null) {
            throw new PlatformException("The extension POINT for " + OPERATION_EXTENSION_POINT_ID + " could not be found!!");
        }

        IExtension[] extensions = point.getExtensions();
        if (extensions == null) {
            throw new PlatformException("No extensions for " + OPERATION_EXTENSION_POINT_ID + " could not be found!!");
        }

        for (int index = 0; index < extensions.length; index++) {
            IConfigurationElement[] elements = extensions[index].getConfigurationElements();
            for (int elementIndex = 0; elementIndex < elements.length; elementIndex++) {
                try {
                    IConfigurationElement configurationElement = elements[elementIndex];
                    // This is where we create the server object that will be

                    DataOperation operation = (DataOperation) configurationElement.createExecutableExtension("class");
                    GenericConfiguration operationConfiguration = new GenericConfiguration();

                    String id = configurationElement.getAttribute("id");
                    String reSetIDStr = configurationElement.getAttribute("reSetID");

                    // Populate the configuration properties.
                    operationConfiguration.populateProperties(configurationElement);
                    //operation.configure(operationConfiguration, _monitoringService, this);
                    //operation.addOperationListener(this);
                    //
                    if (reSetIDStr == null || reSetIDStr.length() == 0 || "true".equals(reSetIDStr.toLowerCase())) {
                        operation.setOperationID(id);
                    }
                    //
                    //_runtimeENV.put(operation.getOperationsID(), operation);
                    //
                    //operation.start();
                    // We will keep track of these, and will
                    //_dataActionList.add(operation);
                } catch (Exception e) {
                    theLogger.exception("start", e);
                }
            }
        }
        // mark ready.
        // start the timer watch.
    }

    @Override
    public void stop() throws PlatformException {

    }

    /**
     * This method is called when the Queue checking task has found a new monitoring task that needs to be performed. This method should only be called when the isComplete method returns true.
     * 
     * @param message
     * @param bDeleteFormQueue
     * @throws PlatformException
     * @throws WORKFLOW_WAIT
     *             =>WORKFLOW_INPROCESSING.
     */
    public synchronized void doIt() throws PlatformException {

    }

    /**
     * This method creates a scheduled task's raw data message and send to dpu directly. This method is called when either a error or finished method is called.
     * 
     * @param state
     * @param messageString
     */
    public void logScheduledFinishedMessage(String messageType, String messageString) {

    }

    /**
     * send the data to dpu if it's a realtime task, otherwise put it into scheduledResult
     * 
     * @param type
     * @param messageInputAndRequestHeaders
     * 
     * @author wlan
     */
    public void createResultsMessage(String type, HashMap<String, String> messageInputAndRequestHeaders) {

    }

    /**
     * This method logs an error that occurred in the monitoring workflow.
     * 
     * @param operationError
     */
    private void logErrorMessage(IDataOperation operation, boolean isCheckOperation) {

    }

    private static void createMessageFormatters() {

    }

    /**
     * This method will remove the finished operation and
     */
    private void actionFinished(IDataOperation operation) {

    }

    /**
     * This method is called when the workflow has completed.
     * 
     * @param resultQueue
     * @param rawData
     * @param messageType
     */
    protected void workflowCompleted(boolean bError) {

    }

    /**
     * This method upload the .
     * 
     * @param type
     * @param messageInputAndRequestHeaders
     */
    protected void storeResultsMessage(String type, HashMap<String, String> messageInputAndRequestHeaders) {

    }

    /**
     * This is called when there is an error in the workflow. At this point we should clear the messages and finish
     */
    private void completeWorkflowOnError() {

    }

}
