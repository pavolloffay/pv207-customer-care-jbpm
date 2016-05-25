package fi.muni.pv207.ticket.handler;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.ticket.BusinessCase;

/**
 * @author Pavol Loffay
 */
public class SpamRecognitionHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        boolean resultStatus = businessCase.getDescription().contains("viagra") ? true : false;

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("ResultStatus", resultStatus);
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    }
}
