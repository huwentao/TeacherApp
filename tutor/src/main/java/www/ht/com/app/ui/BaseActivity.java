package www.ht.com.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;

import butterknife.ButterKnife;
import www.ht.com.app.tools.DisplayUtil;

public class BaseActivity extends AppCompatActivity {
    private GestureDetector gestureDetector = null;
    private boolean isOpenFlingClose = true; // activity右滑关闭功能开关
    private float flingWidthPX = 0f;
    private TutorApplication tutorApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flingWidthPX = DisplayUtil.dip2px(this, 100);
        tutorApp = (TutorApplication) getApplication();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this, onGestureListener);
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
    public void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getTitle());
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private GestureDetector.SimpleOnGestureListener onGestureListener = new GestureDetector.SimpleOnGestureListener() {
        private float startFlingX = 0f;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            startFlingX = e1.getX();
            if (isOpenFlingClose && velocityX - startFlingX > flingWidthPX) {
                finish();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    /**
     * 是否打开右滑关闭功能
     * @param isOpenFlingClose
     */
    public void setIsOpenFlingClose(boolean isOpenFlingClose) {
        this.isOpenFlingClose = isOpenFlingClose;
    }

    public TutorApplication getTutorApp() {
        return tutorApp;
    }
}
