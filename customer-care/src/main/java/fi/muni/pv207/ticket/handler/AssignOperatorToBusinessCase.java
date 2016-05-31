package fi.muni.pv207.ticket.handler;

import fi.muni.pv207.ticket.BusinessCase;
import fi.muni.pv207.ticket.db.EmployeeDatabase;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.HashMap;
import java.util.Map;

public class AssignOperatorToBusinessCase implements WorkItemHandler {
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        System.out.println("ASSIGN BC: " + businessCase);
        
        EmployeeDatabase.employees.get(1).setBusinessCase(businessCase);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("BusinessCase", businessCase);
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

    }
}
