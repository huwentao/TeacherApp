/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.activity.teacher;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.activity.MessageActivity;
import www.ht.com.app.ui.core.BaseActivity;
import www.ht.com.app.ui.core.BaseFragment;
import www.ht.com.app.ui.fragment.parent.ParentDiscoverFragment;
import www.ht.com.app.ui.fragment.teacher.ParentReviewFragment;
import www.ht.com.app.ui.fragment.teacher.TeacherCourseFragment;
import www.ht.com.app.ui.fragment.teacher.TeacherFragment;
import www.ht.com.app.view.tabview.TeacherTabViewLayout;

public class TeacherMainActivity extends BaseActivity {

    /**
     * Used to store the last screen title. For use in {@link #initToolBar()} ()}.
     */
    @Bind(R.id.tabViewLayout) TeacherTabViewLayout tabViewLayout;

    private List<BaseFragment> fragments = new ArrayList<>();
    private FragmentManager fragmentManager;
    private int showIndex = 0; //初始化显示的fragment位置
    private List<MenuItem> courseMenus = new ArrayList<>();//多个toolbar

    @Override
    public void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("");
            if (Build.VERSION.SDK_INT > 21) {
                actionBar.setLogo(getDrawable(R.drawable.logo_2));
            } else {
                actionBar.setLogo(getResources().getDrawable(R.drawable.logo_2));
            }
        }
    }

    /**
     * 切换fragment
     *
     * @param index 需要显示出来的fragment的位置{@link TeacherMainActivity#fragments}
     */
    public void showFragment(int index) {
        BaseFragment fragment = fragments.get(index);
        if (!fragment.isHidden()) {
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if (i == index) {
                transaction.show(fragments.get(index));
            } else {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_teacher_main, menu);
        courseMenus.add(menu.findItem(R.id.courseMenu));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.messageMenu) {
            callMe(MessageActivity.class);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);
        setIsOpenFlingClose(false);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragments.add(new ParentReviewFragment());
        fragments.add(new TeacherCourseFragment());
        fragments.add(new ParentDiscoverFragment());
        fragments.add(new TeacherFragment());
        transaction.add(R.id.container, fragments.get(0), fragments.get(0).getName());
        transaction.add(R.id.container, fragments.get(1), fragments.get(1).getName());
        transaction.add(R.id.container, fragments.get(2), fragments.get(2).getName());
        transaction.add(R.id.container, fragments.get(3), fragments.get(3).getName());
        for (int i = 0; i < fragments.size(); i++) {
            if (i != showIndex)
                transaction.hide(fragments.get(i));
        }
        transaction.commit();

        tabViewLayout.setOnTabViewChangeListener(new TeacherTabViewLayout.OnTabViewChangeListener() {
            @Override
            public void onChange(int index) {
                showFragment(index);
                if (courseMenus.size() > index && index == 1) {
                    courseMenus.get(index).setVisible(true);
                }
            }
        });
        tabViewLayout.checkIndex(showIndex);
    }
}
