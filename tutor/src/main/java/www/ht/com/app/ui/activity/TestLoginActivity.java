/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.ui.core.BaseActivity;

public class TestLoginActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_login, menu);
        return true;
    }

    @OnClick({R.id.weibo, R.id.weixin, R.id.qqLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.weixin:
                break;
            case R.id.weibo:
                break;
            case R.id.qqLogin:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
