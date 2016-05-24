package fi.muni.pv207.registration.handler;

import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class ValidateEmail {

    private String url;
    private String port;

    private com.squareup.okhttp.OkHttpClient client = new com.squareup.okhttp.OkHttpClient();

    public ValidateEmail(String port, String url) {
        this.port = port;
        this.url = url;
    }

    public boolean validate(String email) {

        com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
                .url("http://localhost:" + port + url + "?email="+ email)
                .build();

        com.squareup.okhttp.Response response = null;
        try {
            response = client.newCall(request).execute();
            response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response != null && response.isSuccessful()) {
            return true;
        }

        return false;
    }
}
