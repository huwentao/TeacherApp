package www.ht.com.ap.ui.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import www.ht.com.ap.R;
import www.ht.com.ap.ui.fragment.CourseDetailFragment;

/**
 * Created by mokey on 2015/8/7.
 */
public class CoursePagerAdapter extends FragmentPagerAdapter {
    List<CourseDetailFragment> fragments = new ArrayList<>();

    public CoursePagerAdapter(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
        fragments.add(CourseDetailFragment.newInstance(
                CourseDetailFragment.WEEK_TYPE,
                activity.getResources().getString(R.string.courseWeekType)
        ));
        fragments.add(CourseDetailFragment.newInstance(
                CourseDetailFragment.MONTH_TYPE,
                activity.getResources().getString(R.string.courseMonthType)
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
    public long getItemId(int position) {
        return position * 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }


}
