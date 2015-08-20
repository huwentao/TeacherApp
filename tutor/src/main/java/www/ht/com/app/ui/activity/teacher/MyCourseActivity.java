package www.ht.com.app.ui.activity.teacher;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.data.Course;
import www.ht.com.app.data.CourseFile;
import www.ht.com.app.ui.BaseActivity;
import www.ht.com.app.ui.activity.adapter.MyCourseFileRecyclerAdapter;
import www.ht.com.app.ui.fragment.adapter.CourseRecylerAdapter;

public class MyCourseActivity extends BaseActivity {
    @Bind(R.id.courseViewPager) RecyclerView recyclerView;
    @Bind(R.id.toolbar) Toolbar toolbar;
    List<Course> mCourseList = new ArrayList<>();
    List<Course> mWeekCourseList = new ArrayList<>();
    List<Course> mMonthCourseList = new ArrayList<>();
    private String mParamCourseType;
    public static final String WEEK_TYPE = "week_type";
    public static final String MONTH_TYPE = "month_type";
    private static final String ARG_COURSE_TYPE = "COURSE_TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_course);
        setToolBar(toolbar);

        mCourseList.addAll(testCourseList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        CourseRecylerAdapter recyclerAdapter = new CourseRecylerAdapter(mParamCourseType, mCourseList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
