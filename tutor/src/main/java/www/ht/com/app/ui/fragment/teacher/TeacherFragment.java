package www.ht.com.app.ui.fragment.teacher;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.BaseFragment;
import www.ht.com.app.ui.activity.SettingActivity;
import www.ht.com.app.ui.activity.parent.TeacherActivity;
import www.ht.com.app.ui.activity.teacher.MyCourseActivity;
import www.ht.com.app.ui.activity.teacher.StudentHomeworkActivity;
import www.ht.com.app.ui.activity.teacher.StudentParentActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class TeacherFragment extends BaseFragment {
    public TeacherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher, container, false);
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
                                getBaseActivity().callMe(TeacherActivity.class);
                                break;
                            case R.id.myCourses:
                                getBaseActivity().callMe(MyCourseActivity.class);
                                break;
                            case R.id.myStudentHomework:
                                getBaseActivity().callMe(StudentHomeworkActivity.class);
                                break;
                            case R.id.studentParent:
                                getBaseActivity().callMe(StudentParentActivity.class);
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
