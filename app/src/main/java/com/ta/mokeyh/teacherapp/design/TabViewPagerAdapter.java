package com.ta.mokeyh.teacherapp.design;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mokey on 2015/8/2.
 */
public class TabViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();

    public TabViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (fragmentList.size() > position) {
            fragment = fragmentList.get(position);
        } else {
//            if (position == 0) {
//                fragmentList.add(position, fragment = PlusTwoFragment.newInstance(null, null));
//            } else {
//                fragmentList.add(position, fragment = PlusOneFragment.newInstance(null,null));
//            }
                fragmentList.add(position, fragment = PlusTwoFragment.newInstance(null, null));
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab " + position;
    }
}
