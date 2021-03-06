/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.fragment.parent;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.activity.SettingActivity;
import www.ht.com.app.ui.activity.parent.MyCourseNeedActivity;
import www.ht.com.app.ui.activity.parent.MyHomeworkActivity;
import www.ht.com.app.ui.activity.parent.MyTeacherActivity;
import www.ht.com.app.ui.activity.parent.ParentActivity;
import www.ht.com.app.ui.core.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class PersonFragment extends BaseFragment {
    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Bind(R.id.navigationView) NavigationView navigationView;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.myInfo:
                                getBaseActivity().callMe(ParentActivity.class);
                                break;
                            case R.id.myTeacher:
                                getBaseActivity().callMe(MyTeacherActivity.class);
                                break;
                            case R.id.myCondition:
                                getBaseActivity().callMe(MyCourseNeedActivity.class);
                                break;
                            case R.id.myHomework:
                                getBaseActivity().callMe(MyHomeworkActivity.class);
                                break;
                            case R.id.setting:
                                getBaseActivity().callMe(SettingActivity.class);
                                break;
                            default:
                                return false;
                        }
                        return true;
                    }

                }

        );
    }
}
