package www.ht.com.app.ui.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import www.ht.com.app.ui.BaseFragment;
import www.ht.com.app.ui.fragment.TeacherCourseFragment;
import www.ht.com.app.ui.fragment.TeacherInfoFragment;

/**
 * Created by monkey on 2015/8/11.
 */
public class TeacherInfoPagerAdapter extends FragmentPagerAdapter {
    List<BaseFragment> fragments = new ArrayList<>();

    public TeacherInfoPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(TeacherInfoFragment.newInstance());
        fragments.add(TeacherCourseFragment.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public long getItemId(int position) {
        return position * 1000;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
