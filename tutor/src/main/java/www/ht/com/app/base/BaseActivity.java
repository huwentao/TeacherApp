package www.ht.com.app.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import www.ht.com.app.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    public CharSequence getName() {
        return getTitle();
    }

    /**
     * 页面跳转
     *
     * @param aClass
     */
    public void callMe(Class<? extends BaseActivity> aClass) {
        Intent intent = new Intent(this, aClass);
        startActivity(intent);
    }

    /**
     * 设置Toolbar
     *
     * @param toolBar
     */
    protected void setToolBar(Toolbar toolBar) {
        if (toolBar != null) {
            setSupportActionBar(toolBar);
        }
        initToolBar();
    }

    /**
     * 初始化Toolbar的初始配置
     */
    protected void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getTitle());
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
