package com.ta.mokeyh.teacherapp.ui;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by korey on 2015/7/31.
 */
public class TAApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        String loggerTag = getPackageName();
        Logger.init(loggerTag)               // default PRETTYLOGGER or use just init()
                .setMethodCount(3)            // default 2
                .hideThreadInfo()             // default shown
                .setLogLevel(LogLevel.NONE)  // default LogLevel.FULL
                .setMethodOffset(2);           // default 0
    }
}
