package fi.muni.pv207.registration.handler;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

/**
 * @author Pavol Loffay
 */
public class DummyHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        // extract parameters
        System.out.println("\n\n\nDUMMY  Handler\n\n\n");
        manager.completeWorkItem(workItem.getId(), new HashMap<String, Object>());
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
    }

}
