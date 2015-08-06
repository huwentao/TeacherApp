package www.ht.com.ap.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.ap.R;
import www.ht.com.ap.base.BaseFragment;
import www.ht.com.ap.ui.fragment.adapter.CoursePagerAdapter;

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
        return inflater.inflate(R.layout.fragment_course, container, false);
    }

    @Bind(R.id.tabViewLayout) TabLayout tabViewLayout;
    @Bind(R.id.viewPager) ViewPager viewPager;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CoursePagerAdapter coursePagerAdapter = new CoursePagerAdapter((AppCompatActivity) getActivity());
        viewPager.setAdapter(coursePagerAdapter);
        tabViewLayout.setupWithViewPager(viewPager);

    }
}
