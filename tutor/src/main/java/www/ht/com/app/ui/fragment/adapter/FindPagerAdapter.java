/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import www.ht.com.app.R;
import www.ht.com.app.ui.core.BaseFragment;
import www.ht.com.app.ui.fragment.parent.FindDetailFragment;
import www.ht.com.app.ui.fragment.parent.MapFragment;

/**
 * Created by mokey on 2015/8/7.
 */
public class FindPagerAdapter extends FragmentPagerAdapter {
    List<BaseFragment> fragments = new ArrayList<>();

    public FindPagerAdapter(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
        fragments.add(FindDetailFragment.newInstance(
                activity.getResources().getString(R.string.findDetailTitle)
        ));
        fragments.add(MapFragment.newInstance(
                activity.getResources().getString(R.string.findMapNearTeacher)
        ));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position*100;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
