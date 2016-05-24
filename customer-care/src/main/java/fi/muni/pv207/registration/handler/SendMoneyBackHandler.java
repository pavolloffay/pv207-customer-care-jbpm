package fi.muni.pv207.registration.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import fi.muni.pv207.registration.Customer;

/**
 * @author Pavol Loffay
 */
public class SendMoneyBackHandler implements WorkItemHandler {

    private String url;
    private String port;

    private com.squareup.okhttp.OkHttpClient client = new com.squareup.okhttp.OkHttpClient();

    public SendMoneyBackHandler(String port, String url) {
        this.port = port;
        this.url = url;
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
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

        Boolean resultStatus = false;
        if (response != null && response.isSuccessful()) {
            resultStatus = true;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("resultStatus", resultStatus);
        workItemManager.completeWorkItem(workItem.getId(), result);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    }
}
