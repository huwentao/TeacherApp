package www.ht.com.app.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import www.ht.com.app.db.DbUtils;

/**
 * Created by mokey on 2015/8/4.
 */
public class HTApplication extends Application {
    private DbUtils dbUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        String LogTag = getPackageName().toLowerCase();
        Logger.init(LogTag)               // default PRETTYLOGGER or use just init()
                .setMethodCount(3)            // default 2
                .hideThreadInfo()             // default shown
                .setLogLevel(LogLevel.NONE);  // default LogLevel.FULL
//                .setMethodOffset(2);          // default 0

        dbUtils = DbUtils.create(this);

        registerActivityLifecycleCallbacks(new HTActivityLifecycleCallbacks());
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
            Logger.d(activity.getTitle().toString()+"onDestoryed");
        }
    }


}
