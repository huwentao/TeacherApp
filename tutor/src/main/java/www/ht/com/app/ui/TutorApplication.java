package www.ht.com.app.ui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.github.mmin18.layoutcast.LayoutCast;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import www.ht.com.app.BuildConfig;
import www.ht.com.app.db.DbUtils;

/**
 * Created by mokey on 2015/8/4.
 */
public class TutorApplication extends Application {
    private DbUtils dbUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        String LogTag = getPackageName().toLowerCase();
        Logger.init(LogTag)               // default PRETTYLOGGER or use just init()
                .setMethodCount(1)            // default 2
                .hideThreadInfo()             // default shown
                .setLogLevel(LogLevel.FULL);  // default LogLevel.FULL
//                .setMethodOffset(2);          // default 0

        dbUtils = DbUtils.create(this);

        registerActivityLifecycleCallbacks(new HTActivityLifecycleCallbacks());

        SDKInitializer.initialize(getApplicationContext());//因此我们建议该方法放在Application的初始化方法中

        if (BuildConfig.DEBUG) {
            LayoutCast.init(this);
        }
    }

    public DbUtils getDbUtils() {
        return dbUtils;
    }


    /**
     *
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
