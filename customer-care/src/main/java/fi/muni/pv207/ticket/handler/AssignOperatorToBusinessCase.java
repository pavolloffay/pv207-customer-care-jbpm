package fi.muni.pv207.ticket.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.ticket.BusinessCase;
import fi.muni.pv207.ticket.Employee;
import fi.muni.pv207.ticket.db.EmployeeDatabase;

public class AssignOperatorToBusinessCase implements WorkItemHandler {

    private Random random = new Random();

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        Employee employee = EmployeeDatabase.employees.get(random.nextInt(EmployeeDatabase.employees.size()));
        businessCase.employee = employee;

        System.out.println("Assigning business case : " + businessCase + ", to " + employee);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("BusinessCase", businessCase);
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    }
}
