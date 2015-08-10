package www.ht.com.app;

import android.test.InstrumentationTestCase;

import com.orhanobut.logger.Logger;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import www.ht.com.app.data.Course;
import www.ht.com.app.data.CourseFile;

/**
 * Created by mokey on 2015/8/10.
 */
public class CourseTest extends InstrumentationTestCase {
    List<Course> courseList = new ArrayList<>();

    public void testHandleDate() {
        DateTimeFormatter timeFormat = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm");
        DateTime dateTime = timeFormat.parseDateTime("2018/08/01 20:00");
        String time = dateTime.toString();
    }


    @Override
    protected void setUp() throws Exception {
        Logger.init();

        super.setUp();
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
        courseList.add(course);

        course = new Course();
        course.setStartTime("2018/08/01 21:00");
        course.setEndTime("2018/08/01 21:00");
        course.setCourseTitle("奥数培训");
        course.setCourseDesc("习题练习");
        course.setStudentName("王小二");
        course.setCourseFile(courseFile);
        courseList.add(course);

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
        courseList.add(course);
    }
}


