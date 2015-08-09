package www.ht.com.ap.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.ht.com.ap.R;
import www.ht.com.ap.data.Course;
import www.ht.com.ap.ui.fragment.CourseDetailFragment;

/**
 * Created by mokey on 2015/8/7.
 */
public class CourseRecylerAdapter extends RecyclerView.Adapter<CourseRecylerAdapter.CourseView> {

    private final DateTimeFormatter timeFormat;
    private String mParamCourseType;
    private List<Course> mCourseList;

    public CourseRecylerAdapter(String paramCourseType, List<Course> courseList) {
        mCourseList = courseList;
        mParamCourseType = paramCourseType;
        timeFormat = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm");
        for (int i = 0; i < courseList.size(); i++) {
            if (i > 0) {
                Course courseBefore = courseList.get(i - 1);
                Course course = courseList.get(i);
                DateTime dateTimeBefore = timeFormat.parseDateTime(courseBefore.getStartTime());
                DateTime dateTime = timeFormat.parseDateTime(course.getStartTime());
                if (dateTimeBefore.getDayOfWeek() == dateTime.getDayOfWeek()) {
                    course.setIsShowDayStr(false);
                } else {
                    course.setIsShowDayStr(true);
                }
            }
        }
    }

    @Override
    public CourseView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_course_view, parent, false);
        return new CourseView(view);
    }

    @Override
    public void onBindViewHolder(CourseView holder, int position) {
        Course course = mCourseList.get(position);
        if (!course.isShowDayStr()) {
            isCenter(holder);
        } else {
            isFirst(holder);
            holder.shadowLine.setVisibility(View.VISIBLE);
            DateTime dateTime = getCourseDateTime(course);
            String weekStr = getCourseDay(dateTime);
            if (CourseDetailFragment.WEEK_TYPE.equals(mParamCourseType)) {
                holder.courseDay.setText(weekStr);
            } else {
                int dayOfMonth = dateTime.getDayOfMonth();
                holder.courseDay.setText(dayOfMonth + "\n" + weekStr);
            }
        }
        if (position == mCourseList.size() - 1) {
            isLast(holder);
        }
        holder.studentName.setText(course.getStudentName());
        holder.courseTitle.setText(course.getCourseTitle());
        holder.courseTime.setText(course.getStartTime() + "~" + course.getEndTime());
        if (course.getCourseFile() != null) {
            holder.fileTitle.setText(course.getCourseFile().getFileTitle());
            holder.fileDesc.setText(course.getCourseFile().getFileDesc());
        }
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    public class CourseView extends RecyclerView.ViewHolder {
        @Bind(R.id.courseDay) TextView courseDay;
        @Bind(R.id.studentName) TextView studentName;
        @Bind(R.id.courseTitle) TextView courseTitle;
        @Bind(R.id.fileTitle) TextView fileTitle;
        @Bind(R.id.fileDesc) TextView fileDesc;
        @Bind(R.id.courseTime) TextView courseTime;
        @Bind(R.id.lineContent) TextView lineContent;
        @Bind(R.id.lineup) TextView lineup;
        @Bind(R.id.fileImage) ImageView fileImage;
        @Bind(R.id.shadowLine) ImageView shadowLine;
        @Bind(R.id.shadowDown) ImageView shadowDown;

        public CourseView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public DateTime getCourseDateTime(Course course) {
        return timeFormat.parseDateTime(course.getStartTime());
    }

    public String getCourseDay(DateTime dateTime) {
        String weekStr = null;
        switch (dateTime.getDayOfWeek()) {
            case 0:
                weekStr = "周日";
                break;
            case 1:
                weekStr = "周一";
                break;
            case 2:
                weekStr = "周三";
                break;
            case 3:
                weekStr = "周三";
                break;
            case 4:
                weekStr = "周四";
                break;
            case 5:
                weekStr = "周五";
                break;
            case 6:
                weekStr = "周六";
                break;
        }

        return weekStr;
    }

    public void isFirst(CourseView courseView) {
        courseView.courseDay.setVisibility(View.VISIBLE);
        courseView.lineContent.setVisibility(View.GONE);
        courseView.lineup.setVisibility(View.VISIBLE);
        courseView.shadowLine.setVisibility(View.GONE);
        courseView.shadowDown.setVisibility(View.GONE);
    }

    public void isCenter(CourseView courseView) {
        courseView.courseDay.setVisibility(View.INVISIBLE);
        courseView.lineContent.setVisibility(View.VISIBLE);
        courseView.lineup.setVisibility(View.GONE);
        courseView.shadowLine.setVisibility(View.GONE);
        courseView.shadowDown.setVisibility(View.GONE);
    }

    public void isLast(CourseView courseView) {
        courseView.shadowDown.setVisibility(View.VISIBLE);
    }
}
