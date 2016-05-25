package fi.muni.pv207.ticket.handler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.ticket.BusinessCase;
import fi.muni.pv207.ticket.BusinessCasesStorage;

/**
 * @author Pavol Loffay
 */
public class AttachToExistingBusinessCases implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        List<BusinessCase> existingBusinessCases = BusinessCasesStorage.businessCasesMap.get(businessCase.getId());
        if (existingBusinessCases == null) {
            existingBusinessCases = new LinkedList<>();
            BusinessCasesStorage.businessCasesMap.put(businessCase.getId(), existingBusinessCases);
        }

        existingBusinessCases.add(businessCase);

        workItemManager.completeWorkItem(workItem.getId(), Collections.<String, Object>emptyMap());
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    }
}
