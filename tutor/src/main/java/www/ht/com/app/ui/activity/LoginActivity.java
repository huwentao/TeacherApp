/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.config.AppType;
import www.ht.com.app.ui.activity.parent.ParentMainActivity;
import www.ht.com.app.ui.activity.teacher.TeacherMainActivity;
import www.ht.com.app.ui.core.BaseActivity;
import www.ht.com.app.view.segmentcontrol.SegmentControl;

public class LoginActivity extends BaseActivity {
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.segmentControl) SegmentControl segmentControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setToolBar(toolbar);
        setIsOpenFlingClose(false);
        //默认家长登录
        getTutorApp().setAppConfig(AppType.Parent);
        segmentControl.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                switch (index) {
                    case 0:
                        getTutorApp().setAppConfig(AppType.Parent);
                        break;
                    case 1:
                        getTutorApp().setAppConfig(AppType.Teacher);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.login, R.id.register})
    public void viewClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                if (getTutorApp().getAppConfig().getAppType() == AppType.Parent) {
                    callMe(ParentMainActivity.class);
                } else {
                    callMe(TeacherMainActivity.class);
                }
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
        callMe(ParentMainActivity.class);
        finish();
    }
}
