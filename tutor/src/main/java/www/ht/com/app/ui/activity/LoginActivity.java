package www.ht.com.app.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.ui.BaseActivity;

public class LoginActivity extends BaseActivity {
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setToolBar(toolbar);
        setIsOpenFlingClose(false);
    }

    @OnClick({R.id.login, R.id.register})
    public void viewClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                callMe(MainActivity.class);
//                finish();
                break;
            case R.id.register:
                callMe(RegisterActivity.class);
//                finish();
                break;
        }

    }

    @OnClick(R.id.skip)
    public void skip() {
        callMe(MainActivity.class);
        finish();
    }
}
