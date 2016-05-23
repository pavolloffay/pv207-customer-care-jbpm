package fi.muni.pv207.registration.handler;

import java.util.HashMap;

import org.jbpm.process.workitem.email.Email;
import org.jbpm.process.workitem.email.EmailWorkItemHandler;
import org.jbpm.process.workitem.email.SendHtml;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.registration.Customer;

/**
 * @author Pavol Loffay
 */
public class EmailForCustomerHandler extends EmailWorkItemHandler {

    public EmailForCustomerHandler(String host, String port, String userName, String password) {
        super(host, port, userName, password);
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        if(this.getConnection() == null) {
            throw new IllegalArgumentException("Connection not initialized for Email");
        } else {
            Customer customer = (Customer) workItem.getParameter("Customer");
            workItem.getParameters().put("To", customer.getEmail());

            try {
                Email e = createEmail(workItem, this.getConnection());
                SendHtml.sendHtml(e, this.getDebugFlag(workItem));
                if(manager != null) {
                    manager.completeWorkItem(workItem.getId(), new HashMap<String, Object>());
                }
            } catch (Exception var4) {
                this.handleException(var4);
            }
        }
    }
}
