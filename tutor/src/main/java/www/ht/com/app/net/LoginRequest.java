/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.net;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import www.ht.com.app.ui.core.AppHandler;

/**
 * Created by monkey on 2015/8/25.
 */
public class LoginRequest extends AppRequest {
    private final int what;
    private AppHandler appHandler;
    private Request loginRequest;

    public LoginRequest(AppHandler appHandler, int what) {
        this.appHandler = appHandler;
        this.what = what;
    }

    public void login(String mobile,
                      String password,
                      String deviceId) {
        loginRequest = TestRequest.login(mobile, password, deviceId);
    }

    @Override
    public void excute() {
        okHttpClient.newCall(loginRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }
}
