package www.ht.com.app.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;
import www.ht.com.app.base.BaseFragment;
import www.ht.com.app.ui.fragment.adapter.CoursePagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends BaseFragment {


    public CourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        tabViewLayout = (TabLayout) view.findViewById(R.id.courseTabViewLayout);
        viewPager = (ViewPager) view.findViewById(R.id.courseViewPager);
        return view;
    }

    TabLayout tabViewLayout;
    ViewPager viewPager;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CoursePagerAdapter coursePagerAdapter = new CoursePagerAdapter((AppCompatActivity) getActivity());
        viewPager.setAdapter(coursePagerAdapter);
        tabViewLayout.setupWithViewPager(viewPager);

    }
}
