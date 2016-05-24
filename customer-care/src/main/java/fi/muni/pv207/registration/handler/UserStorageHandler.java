package fi.muni.pv207.registration.handler;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.registration.Customer;
import fi.muni.pv207.registration.db.CustomerDatabase;

/**
 * @author Pavol Loffay
 */
public class UserStorageHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

        Customer customer = (Customer) workItem.getParameter("Customer");

        Boolean resultStatus = false;
        Customer customerFromDb = CustomerDatabase.customerMap.get(customer.getEmail());
        if (customerFromDb == null) {
            CustomerDatabase.customerMap.put(customer.getEmail(), customer);
            resultStatus = true;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("ResultStatus", resultStatus);
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    }
}
