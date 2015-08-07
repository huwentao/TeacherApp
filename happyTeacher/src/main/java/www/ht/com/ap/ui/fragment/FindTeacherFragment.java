package www.ht.com.ap.ui.fragment;

import android.os.Bundle;
import android.app.Fragment;
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
import www.ht.com.ap.ui.fragment.adapter.FindPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class FindTeacherFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        tabViewLayout = (TabLayout) view.findViewById(R.id.tabViewLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        return view;
    }

    TabLayout tabViewLayout;
    ViewPager viewPager;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FindPagerAdapter findPagerAdapter = new FindPagerAdapter((AppCompatActivity) getActivity());
        viewPager.setAdapter(findPagerAdapter);
        tabViewLayout.setupWithViewPager(viewPager);

    }


}
