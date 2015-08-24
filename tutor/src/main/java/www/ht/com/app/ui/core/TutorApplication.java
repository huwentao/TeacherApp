/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import org.joda.time.DateTime;

import www.ht.com.app.BuildConfig;
import www.ht.com.app.config.AppType;
import www.ht.com.app.config.Config;
import www.ht.com.app.data.LoginUser;
import www.ht.com.app.db.DbUtils;

/**
 * Created by mokey on 2015/8/4.
 */
public class TutorApplication extends Application {
    private static String LOGTAG = null;
    private DbUtils dbUtils;
    private Config appConfig;
    private LoginUser mLoginUser;

    @Override
    public void onCreate() {
        super.onCreate();
        LOGTAG = getPackageName();
        initConfig(AppType.Parent);
        dbUtils = DbUtils.create(this);
        registerActivityLifecycleCallbacks(new HTActivityLifecycleCallbacks());
        SDKInitializer.initialize(getApplicationContext());//因此我们建议该方法放在Application的初始化方法中
    }

    /**
     * 初始化应用配置
     *
     * @param appType APP类型，家长视图or教师视图
     */
    private void initConfig(AppType appType) {
        if (BuildConfig.DEBUG) {
//            LayoutCast.init(this);
            appConfig = Config.getDebugIntance(appType);
            Logger.init(LOGTAG)               // default PRETTYLOGGER or use just init()
                    .setMethodCount(1)            // default 2
                    .hideThreadInfo()             // default shown
                    .setLogLevel(LogLevel.FULL);  // default LogLevel.FULL
        } else {
            appConfig = Config.getDebugIntance(appType);
            Logger.init(LOGTAG)               // default PRETTYLOGGER or use just init()
                    .setMethodCount(1)            // default 2
                    .hideThreadInfo()             // default shown
                    .setLogLevel(LogLevel.NONE);  // default LogLevel.FULL
        }
    }

    public DbUtils getDbUtils() {
        return dbUtils;
    }

    public Config getAppConfig() {
        return appConfig;
    }

    public void setAppConfig(AppType appType) {
        initConfig(appType);
    }

    /**
     * 保存用户登录信息
     *
     * @param loginUser 当前登录用户
     */
    public void login(LoginUser loginUser) {
        mLoginUser = loginUser;
        SharedPreferences sharedPref = getSharedPreferences(Config.LOGIN_LOGININFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPref.edit();
        edit.putString(Config.LOGIN_LOGINID, loginUser.getTelephone());
        edit.putString(Config.LOGIN_TOKEN, loginUser.getToken());
        edit.putString(Config.LOGIN_USERNAME, loginUser.getUserName());
//        edit.putString(Config.LOGIN_AGENT, loginUser.get());
//        edit.putLong(Config.LOGIN_REFRESHTIME, loginUser.getRefreshTime());
        edit.putInt(Config.LOGIN_TYPE, appConfig.getAppType().getType());
        edit.putLong(Config.LOGIN_LOGINEDTIME, DateTime.now().getMillis());
        edit.apply();
    }

    /**
     * 加载已登录用户 信息
     *
     * @return
     */
    public LoginUser initLoginInfo() {
        ///////////////////////////////
        ///////加载已登录用户 信息/////////
        SharedPreferences sharedPref = getSharedPreferences(Config.LOGIN_LOGININFO, Context.MODE_PRIVATE);
        long refreshTime = sharedPref.getLong(Config.LOGIN_REFRESHTIME, 0);
        long loginedTime = sharedPref.getLong(Config.LOGIN_LOGINEDTIME, 0);
        long tokenTime = refreshTime - DateTime.now().getMillis() + loginedTime;
        //失效前一天更新token
        if (tokenTime > 1000 * 60 * 60 * 24) {
            mLoginUser = new LoginUser();
            mLoginUser.setTelephone(sharedPref.getString(Config.LOGIN_LOGINID, null));
            mLoginUser.setToken(sharedPref.getString(Config.LOGIN_TOKEN, null));
            mLoginUser.setUserName(sharedPref.getString(Config.LOGIN_USERNAME, null));
//            mLoginUser.setAgent(sharedPref.getString(Config.LOGIN_AGENT, null));
//            mLoginUser.setRefreshTime(sharedPref.getLong(Config.LOGIN_REFRESHTIME, 0));
            ////////////////////////////////////
            ////////初始化登录用户类型/////////////
            int type = sharedPref.getInt(Config.LOGIN_TYPE, 1);
            initConfig(Config.getAppType(type));
        } else {
            //TODO refresh token
        }
        return mLoginUser;
    }

    /**
     * 取得当前登录用户
     *
     * @return
     */
    public LoginUser getLoginUser() {
        return mLoginUser;
    }

    public boolean isLogined() {
        return mLoginUser != null;
    }

    /**
     * 监听所有Acitivty的生命周期
     */
    public static class HTActivityLifecycleCallbacks implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Logger.d(activity.getTitle().toString() + "(" + ((BaseActivity) activity).getName() + ") onDestoryed");
        }
    }
}
