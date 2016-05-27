package fi.muni.pv207.ticket.handler;

import fi.muni.pv207.registration.Customer;
import fi.muni.pv207.registration.db.CustomerDatabase;
import fi.muni.pv207.ticket.BusinessCase;
import fi.muni.pv207.ticket.SpamEmailStorage;
import org.drools.core.process.instance.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SubscriptionHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        Customer customer = CustomerDatabase.customerMap.get(businessCase.getEmail());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("HasValidSubscription", customer.getSubscriptionTill().after(new Date()));
        resultMap.put("TypeOfSubscription", customer.getSubscriptionType());
        resultMap.put("Customer", customer);
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

    }

}
