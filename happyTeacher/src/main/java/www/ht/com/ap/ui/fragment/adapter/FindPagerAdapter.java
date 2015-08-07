package www.ht.com.ap.ui.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import www.ht.com.ap.R;
import www.ht.com.ap.base.BaseFragment;
import www.ht.com.ap.ui.fragment.CourseDetailFragment;
import www.ht.com.ap.ui.fragment.FindDetailFragment;
import www.ht.com.ap.ui.fragment.MapFragment;

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
                activity.getResources().getString(R.string.findMapNearbyTitle)
        ));
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
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
