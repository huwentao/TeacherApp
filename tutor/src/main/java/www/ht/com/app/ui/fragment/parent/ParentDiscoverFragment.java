/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.fragment.parent;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.activity.CommunicationActivity;
import www.ht.com.app.ui.activity.ParentTalkActivity;
import www.ht.com.app.ui.activity.StudyInfoActivity;
import www.ht.com.app.ui.activity.TeacherTalkActivity;
import www.ht.com.app.ui.activity.parent.NearTeacherActivity;
import www.ht.com.app.ui.core.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParentDiscoverFragment extends BaseFragment {
    @Bind(R.id.toolbar) Toolbar toolbar;

    public ParentDiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parent_discover, container, false);
    }

    @Bind(R.id.navigationView) NavigationView navigationView;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().initToolBar();

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.studyInfo:
                                getBaseActivity().callMe(StudyInfoActivity.class);
                                break;
                            case R.id.parentTalk:
                                getBaseActivity().callMe(ParentTalkActivity.class);
                                break;
                            case R.id.teacherTalk:
                                getBaseActivity().callMe(TeacherTalkActivity.class);
                                break;
                            case R.id.communication:
                                getBaseActivity().callMe(CommunicationActivity.class);
                                break;
                            case R.id.findMapNearbyTitle:
                                getBaseActivity().callMe(NearTeacherActivity.class);
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
