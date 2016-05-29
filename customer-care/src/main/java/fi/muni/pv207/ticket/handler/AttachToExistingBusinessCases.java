package fi.muni.pv207.ticket.handler;

import fi.muni.pv207.ticket.BusinessCase;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.HashMap;
import java.util.Map;

import static fi.muni.pv207.ticket.BusinessCasesStorage.addBusinessCase;

/**
 * @author Pavol Loffay
 */
public class AttachToExistingBusinessCases implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        addBusinessCase(businessCase);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("BusinessCase", businessCase);
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    }
}
