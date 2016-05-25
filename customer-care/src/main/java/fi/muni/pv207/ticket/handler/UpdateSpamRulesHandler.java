package fi.muni.pv207.ticket.handler;

import java.util.Collections;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.ticket.BusinessCase;
import fi.muni.pv207.ticket.SpamEmailStorage;

/**
 * @author Pavol Loffay
 */
public class UpdateSpamRulesHandler implements WorkItemHandler {
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        BusinessCase businessCase = (BusinessCase) workItem.getParameter("BusinessCase");

        SpamEmailStorage.emailsBlacklist.add(businessCase.getEmail());

        workItemManager.completeWorkItem(workItem.getId(), Collections.<String, Object>emptyMap());
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

    }
}
