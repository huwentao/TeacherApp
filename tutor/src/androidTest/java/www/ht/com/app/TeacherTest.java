/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.test.ApplicationTestCase;

import com.alibaba.fastjson.JSON;
import com.orhanobut.logger.Logger;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import www.ht.com.app.config.Config;
import www.ht.com.app.data.AppResponse;
import www.ht.com.app.data.LoginUser;
import www.ht.com.app.data.Teacher;
import www.ht.com.app.net.APPRequest;
import www.ht.com.app.net.LoggingInterceptor;
import www.ht.com.app.ui.core.TutorApplication;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TeacherTest extends ApplicationTestCase<TutorApplication> {
    private LoginUser loginUser;
    private OkHttpClient okHttpClient = null;
    private String deviceId = null;

    public TeacherTest() {
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
        TelephonyManager tm = (TelephonyManager) tutorApplication.getSystemService(Context.TELEPHONY_SERVICE);
        deviceId = tm.getDeviceId();
        testLogin();
    }

    public void testLogin() {
        Request request = APPRequest.login("18566295788", "123450", deviceId);
        try {
            Response response = okHttpClient.newCall(request).execute();
            String bodyString = response.body().string();
            AppResponse appResponse = JSON.parseObject(bodyString, AppResponse.class);
            loginUser = JSON.parseObject(appResponse.getData(), LoginUser.class);
            Logger.json(bodyString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testUpdateTeacherinfo() {
        Teacher teacher = new Teacher();
        teacher.setExperience("" +
                "");
        teacher.setFeature("关注中等生的提分|语言逻辑基友|践行最简单的方法|K12英语语法");
        teacher.setIntroduction("最简单的方法，分数+能力，语言+逻辑");
        teacher.setOrganization("开心教育");
        teacher.setPraiseRate("5.0");
        teacher.setSeniority(5l);
    }
}