/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.fragment.teacher;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.data.Course;
import www.ht.com.app.data.CourseFile;
import www.ht.com.app.ui.core.BaseFragment;
import www.ht.com.app.ui.fragment.adapter.CourseRecylerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeacherCourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherCourseFragment extends BaseFragment {
    @Bind(R.id.courseViewPager) RecyclerView recyclerView;
    @Bind(R.id.toolbar) Toolbar toolbar;
    List<Course> mCourseList = new ArrayList<>();
    List<Course> mWeekCourseList = new ArrayList<>();
    List<Course> mMonthCourseList = new ArrayList<>();
    private String mParamCourseType;
    public static final String WEEK_TYPE = "week_type";
    public static final String MONTH_TYPE = "month_type";
    private static final String ARG_COURSE_TYPE = "COURSE_TYPE";

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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().initToolBar();

        mCourseList.addAll(testCourseList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        CourseRecylerAdapter recyclerAdapter = new CourseRecylerAdapter(mParamCourseType, mCourseList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private static List<Course> testCourseList = new ArrayList<>();

    static {
        Course course = new Course();
        course.setStartTime("2018/08/01 20:00");
        course.setEndTime("2018/08/01 21:00");
        course.setCourseTitle("奥数培训");
        course.setCourseDesc("习题练习");
        course.setStudentName("王小二");
        CourseFile courseFile = new CourseFile();
        courseFile.setFileTitle("参考书籍");
        courseFile.setFileDesc("小学语言（二年级）上册");
        courseFile.setDownloadUrl("http://www.baidu.com");
        course.setCourseFile(courseFile);
        testCourseList.add(course);

        course = new Course();
        course.setStartTime("2018/08/01 21:00");
        course.setEndTime("2018/08/01 21:00");
        course.setCourseTitle("奥数培训");
        course.setCourseDesc("习题练习");
        course.setStudentName("王小二");
        course.setCourseFile(courseFile);
        testCourseList.add(course);

        course = new Course();
        course.setStartTime("2018/08/02 20:00");
        course.setEndTime("2018/08/02 21:00");
        course.setCourseTitle("奥数培训");
        course.setCourseDesc("习题练习");
        course.setStudentName("王小二");
        courseFile = new CourseFile();
        courseFile.setFileTitle("参考书籍");
        courseFile.setFileDesc("小学语言（二年级）上册");
        courseFile.setDownloadUrl("http://www.baidu.com");
        course.setCourseFile(courseFile);
        testCourseList.add(course);
    }
}
