package www.ht.com.app.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;
import www.ht.com.app.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeacherCourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherCourseFragment extends BaseFragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TeacherCourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherCourseFragment newInstance() {
        TeacherCourseFragment fragment = new TeacherCourseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setTitle("课程");
        return fragment;
    }

    public TeacherCourseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_course, container, false);
    }

}
