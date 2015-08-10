package www.ht.com.app.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.base.BaseActivity;
import www.ht.com.app.base.BaseFragment;
import www.ht.com.app.ui.fragment.CourseFragment;
import www.ht.com.app.ui.fragment.DiscoverFragment;
import www.ht.com.app.ui.fragment.FindTeacherFragment;
import www.ht.com.app.ui.fragment.ReviewFragment;
import www.ht.com.app.view.TabViewLayout;

public class MainActivity extends BaseActivity {

    /**
     * Used to store the last screen title. For use in {@link #initToolBar()} ()}.
     */

    @Bind(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @Bind(R.id.navigationView) NavigationView navigationView;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tabViewLayout) TabViewLayout tabViewLayout;

    private ActionBarDrawerToggle mDrawerToggle;
    private List<BaseFragment> fragments = new ArrayList<>();
    private FragmentManager fragmentManager;
    private int showIndex = 0; //初始化显示的fragment位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolBar(toolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        setupDrawerContent(navigationView);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragments.add(new FindTeacherFragment());
        fragments.add(new ReviewFragment());
        fragments.add(new CourseFragment());
        fragments.add(new DiscoverFragment());
        transaction.add(R.id.container, fragments.get(0), fragments.get(0).getName());
        transaction.add(R.id.container, fragments.get(1), fragments.get(1).getName());
        transaction.add(R.id.container, fragments.get(2), fragments.get(2).getName());
        transaction.add(R.id.container, fragments.get(3), fragments.get(3).getName());
        for (int i = 0; i < fragments.size(); i++) {
            if (i != showIndex)
                transaction.hide(fragments.get(i));
        }
        transaction.commit();

        tabViewLayout.setmOnTabViewChangeListener(new TabViewLayout.OnTabViewChangeListener() {
            @Override
            public void onChange(int index) {
                showFragment(index);
            }
        });
        tabViewLayout.checkIndex(showIndex);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.myInfo:
                        break;
                    case R.id.myTeacher:
                        break;
                    case R.id.myCondition:
                        break;
                    case R.id.myCourseware:
                        break;
                    case R.id.setting:
                        callMe(SettingActivity.class);
                        break;
                    default:
                        return false;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    protected void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
            if (Build.VERSION.SDK_INT > 21) {
                actionBar.setLogo(getDrawable(R.drawable.logo));
            } else {
                actionBar.setLogo(getResources().getDrawable(R.drawable.logo));
            }
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    /**
     * 切换fragment
     *
     * @param index 需要显示出来的fragment的位置{@link MainActivity#fragments}
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.message) {
            callMe(MessageActivity.class);
        }

        return super.onOptionsItemSelected(item);
    }


}
