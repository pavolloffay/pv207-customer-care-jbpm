package fi.muni.pv207.ticket.handler;

import fi.muni.pv207.ticket.BusinessCase;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.HashMap;
import java.util.Map;

import static fi.muni.pv207.registration.db.EmployeeDatabase.employees;

public class AssignOperatorToBusinessCase implements WorkItemHandler {
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        employees.get(1).setBusinessCase(businessCase);

        Map<String, Object> resultMap = new HashMap<>();
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

    }
}
