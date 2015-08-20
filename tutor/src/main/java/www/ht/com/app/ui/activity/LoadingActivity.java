package www.ht.com.app.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.config.AppType;
import www.ht.com.app.tools.AppHandler;
import www.ht.com.app.ui.BaseActivity;
import www.ht.com.app.ui.activity.parent.ParentMainActivity;
import www.ht.com.app.ui.activity.teacher.TeacherMainActivity;

/**
 * APP载入页面，可以作为广告加载页
 */
public class LoadingActivity extends BaseActivity {
    private final static int INTO_APP = 0x000001;
    AppHandler appHandler = new AppHandler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == INTO_APP) {
                //已登录用户直接进入主界面，未登录用户进行登录
                if (getTutorApp().isLogined()) {
                    if (getTutorApp().getAppConfig().getAppType() == AppType.Parent) {
                        callMe(ParentMainActivity.class);
                    } else {
                        callMe(TeacherMainActivity.class);
                    }
                } else {
                    callMe(LoginActivity.class);
                }
                finish();
            }
        }
    };

    Handler handler = appHandler.getHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        setIsOpenFlingClose(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.sendEmptyMessageDelayed(INTO_APP, 3000);
        //加载已登录用户 信息
        getTutorApp().initLoginInfo();
    }

    @Override
    protected void onDestroy() {
        appHandler.interrup();
        super.onDestroy();
    }

    @OnClick(R.id.skip)
    public void skip() {
        callMe(LoginActivity.class);
        appHandler.interrup();
        finish();
    }


}
