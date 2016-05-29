package fi.muni.pv207.registration.handler;

import fi.muni.pv207.registration.Customer;
import fi.muni.pv207.registration.db.CustomerDatabase;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavol Loffay
 */
public class RemoveUserFromDBHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

        Customer customer = (Customer) workItem.getParameter("Customer");

        CustomerDatabase.customerMap.remove(customer.getEmail());

        Map<String, Object> resultMap = new HashMap<>();
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    }
}
