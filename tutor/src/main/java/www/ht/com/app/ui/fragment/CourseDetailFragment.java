package www.ht.com.app.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import www.ht.com.app.R;
import www.ht.com.app.ui.BaseFragment;
import www.ht.com.app.data.Course;
import www.ht.com.app.data.CourseFile;
import www.ht.com.app.ui.fragment.adapter.CourseRecylerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseDetailFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_COURSE_TYPE = "COURSE_TYPE";
    private static final String ARG_TITLE = "ARG_TITLE";
    public static final String WEEK_TYPE = "week_type";
    public static final String MONTH_TYPE = "month_type";
    // TODO: Rename and change types of parameters
    private String mParamCourseType;
    private String mParamTitle;

    RecyclerView recyclerView;
    List<Course> mCourseList = new ArrayList<>();
    List<Course> mWeekCourseList = new ArrayList<>();
    List<Course> mMonthCourseList = new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param courseType Parameter 1.
     * @param Title      Parameter 2.
     * @return A new instance of fragment BaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseDetailFragment newInstance(String courseType, String Title) {
        CourseDetailFragment fragment = new CourseDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COURSE_TYPE, courseType);
        args.putString(ARG_TITLE, Title);
        fragment.setArguments(args);
        fragment.setTitle(Title);
        return fragment;
    }

    public CourseDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamCourseType = getArguments().getString(ARG_COURSE_TYPE);
            mParamTitle = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_course_detail, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCourseList.addAll(testCourseList);
        CourseRecylerAdapter recylerAdapter = new CourseRecylerAdapter(mParamCourseType,mCourseList);
        recyclerView.setAdapter(recylerAdapter);
        if (MONTH_TYPE.equals(mParamCourseType)) {

        } else if (WEEK_TYPE.equals(mParamCourseType)) {

        }
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
