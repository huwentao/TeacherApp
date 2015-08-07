package www.ht.com.ap.ui.activity;

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
import www.ht.com.ap.R;
import www.ht.com.ap.base.BaseActivity;
import www.ht.com.ap.base.BaseFragment;
import www.ht.com.ap.ui.fragment.CourseDetailFragment;
import www.ht.com.ap.ui.fragment.CourseFragment;
import www.ht.com.ap.ui.fragment.DiscoverFragment;
import www.ht.com.ap.ui.fragment.FindTeacherFragment;
import www.ht.com.ap.ui.fragment.ReviewFragment;
import www.ht.com.ap.view.TabViewLayout;

public class MainActivity extends BaseActivity {

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar(String)} ()}.
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
        restoreActionBar(getTitle().toString());

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
            if(i!=showIndex) {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();

        tabViewLayout.setmOnTabViewChangeListener(new TabViewLayout.OnTabViewChangeListener() {
            @Override
            public void onChange(int index) {
                showFragment(index);
            }
        });
        tabViewLayout.checkIndex(showIndex);
    }

    public void restoreActionBar(String mTitle) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(mTitle);
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
        return super.onCreateOptionsMenu(menu);
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
