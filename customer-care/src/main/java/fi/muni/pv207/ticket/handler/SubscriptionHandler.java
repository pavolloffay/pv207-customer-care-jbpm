package fi.muni.pv207.ticket.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.drools.core.process.instance.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.registration.Customer;
import fi.muni.pv207.registration.db.CustomerDatabase;
import fi.muni.pv207.ticket.BusinessCase;

public class SubscriptionHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        System.out.println("BUSINESS CASE: " + businessCase);

        Customer customer = CustomerDatabase.customerMap.get(businessCase.getEmail());
        businessCase.customer = customer;

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("HasValidSubscription", customer != null ?
                customer.getSubscriptionTill().after(new Date()) : false);
        resultMap.put("TypeOfSubscription", customer != null ? customer.getSubscriptionType() : null);

        resultMap.put("Customer", customer);
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

    }

}
