package www.ht.com.app.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.tools.AppHandler;
import www.ht.com.app.ui.BaseActivity;

/**
 * APP载入页面，可以作为广告加载页
 */
public class LoadingActivity extends BaseActivity {
    private final static int INTO_APP = 0x000001;
    AppHandler appHandler = new AppHandler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == INTO_APP) {
                callMe(LoginActivity.class);
                finish();
            }
        }
    };

    Handler handler = appHandler.getHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.sendEmptyMessageDelayed(INTO_APP, 3000);
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