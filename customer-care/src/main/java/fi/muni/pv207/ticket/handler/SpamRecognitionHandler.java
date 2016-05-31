package fi.muni.pv207.ticket.handler;

import fi.muni.pv207.ticket.BusinessCase;
import fi.muni.pv207.ticket.SpamEmailStorage;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavol Loffay
 */
public class SpamRecognitionHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        boolean resultStatus = businessCase.getDescription().contains("viagra");
        boolean blockedEmail = SpamEmailStorage.emailsBlacklist.contains(businessCase.getEmail());
        
        System.out.println("******************************************** RESULT MAP = " + resultStatus);
        System.out.println("******************************************** RESULT MAP = " + blockedEmail);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("ResultStatus", resultStatus && blockedEmail);
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    }
}
