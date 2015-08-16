package www.ht.com.app.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.BaseFragment;
import www.ht.com.app.ui.activity.MainActivity;
import www.ht.com.app.ui.fragment.adapter.CoursePagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        return view;
    }

    @Bind(R.id.courseTablayout) TabLayout tabViewLayout;
    @Bind(R.id.courseViewPager) ViewPager viewPager;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().initToolBar();

        CoursePagerAdapter coursePagerAdapter = new CoursePagerAdapter(getBaseActivity());
        viewPager.setAdapter(coursePagerAdapter);
        tabViewLayout.setupWithViewPager(viewPager);
    }
}
