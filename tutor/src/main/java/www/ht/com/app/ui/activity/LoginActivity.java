package www.ht.com.app.ui.activity;

import android.os.Bundle;

import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.ui.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @OnClick(R.id.login)
    public void login() {
        callMe(MainActivity.class);
        finish();
    }

    @OnClick(R.id.skip)
    public void skip() {
        callMe(MainActivity.class);
        finish();
    }
}
