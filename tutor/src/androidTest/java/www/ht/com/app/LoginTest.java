/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.test.ApplicationTestCase;

import com.orhanobut.logger.Logger;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import www.ht.com.app.config.Config;
import www.ht.com.app.net.TestRequest;
import www.ht.com.app.net.LoggingInterceptor;
import www.ht.com.app.ui.core.TutorApplication;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class LoginTest extends ApplicationTestCase<TutorApplication> {
    private OkHttpClient okHttpClient = null;
    private String deviceId = null;

    public LoginTest() {
        super(TutorApplication.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //获取application之前必须调用的方法
        createApplication();
        TutorApplication tutorApplication = getApplication();
        Config config = tutorApplication.getAppConfig();
        TestRequest.serverConfig = config.getServerConfig();
        okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new LoggingInterceptor());
        Logger.init();
        TelephonyManager tm = (TelephonyManager) tutorApplication.getSystemService(Context.TELEPHONY_SERVICE);
        deviceId = tm.getDeviceId();
    }

    public void testLogin() {
        Request request = TestRequest.login("18566295788", "123450", deviceId);
        try {
            Response response = okHttpClient.newCall(request).execute();
            String bodyString = response.body().string();
            Logger.json(bodyString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testChangePasswd() {
        getNewPasswdCode();
        setNewPassword();
    }

    public void getNewPasswdCode() {
        Request request = TestRequest.getNewPasswdCode("18566295788");
        try {
            Response response = okHttpClient.newCall(request).execute();
            Logger.d(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNewPassword() {
        Request request = TestRequest.setNewPassword("18566295788", "123458", "111111");
        try {
            Response response = okHttpClient.newCall(request).execute();
            Logger.json(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}