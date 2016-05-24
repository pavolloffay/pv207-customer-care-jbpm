package fi.muni.pv207.registration.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jbpm.process.workitem.email.EmailWorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.registration.Customer;
import fi.muni.pv207.registration.EmailValidationResult;

/**
 * @author Pavol Loffay
 */
public class VerifyEmailHandler extends EmailWorkItemHandler {

    private String url;
    private String port;

    private com.squareup.okhttp.OkHttpClient client = new com.squareup.okhttp.OkHttpClient();

    public VerifyEmailHandler(String port, String url) {
        this.port = port;
        this.url = url;
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

        Customer customer = (Customer) workItem.getParameter("userVariable");

        com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
                .url("http://localhost:" + port + url + "?email="+ customer.getEmail())
                .build();

        com.squareup.okhttp.Response response = null;
        try {
            response = client.newCall(request).execute();
            response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EmailValidationResult emailValidationResult = new EmailValidationResult();
        if (response != null && response.isSuccessful()) {
            emailValidationResult.valid = true;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("emailValidationVariable", emailValidationResult);
        manager.completeWorkItem(1, result);
    }
}
