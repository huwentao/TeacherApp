/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app;

import android.test.ApplicationTestCase;

import com.orhanobut.logger.Logger;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import www.ht.com.app.config.Config;
import www.ht.com.app.net.APPRequest;
import www.ht.com.app.net.LoggingInterceptor;
import www.ht.com.app.ui.core.TutorApplication;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class RegisterTest extends ApplicationTestCase<TutorApplication> {
    private OkHttpClient okHttpClient = null;

    public RegisterTest() {
        super(TutorApplication.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //获取application之前必须调用的方法
        createApplication();
        TutorApplication tutorApplication = getApplication();
        Config config = tutorApplication.getAppConfig();
        APPRequest.serverConfig = config.getmServerConfig();
        okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new LoggingInterceptor());
        Logger.init();
    }

    public void testRegister() {
        getVerfyCode();
        register();
    }

    public void getVerfyCode() {
        Request request = APPRequest.getRegisterCode("18566295788");
        try {
            Response response = okHttpClient.newCall(request).execute();
            Logger.d(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void register() {
        Request request = APPRequest.getRegister("1", "18566295788", "123456", "柳红", "123456");
        try {
            Response response = okHttpClient.newCall(request).execute();
            Logger.d(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}