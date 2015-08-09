package www.ht.com.ap.data;

/**
 * Created by mokey on 2015/8/9.
 * 课程
 */
public class Course {
    private String startTime;
    private String endTime;
    private String studentName;
    private String courseTitle;
    private String courseDesc;
    private String courseContent;
    private boolean isShowDayStr = true;
    private CourseFile courseFile;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
    }

    public boolean isShowDayStr() {
        return isShowDayStr;
    }

    public void setIsShowDayStr(boolean isShowDayStr) {
        this.isShowDayStr = isShowDayStr;
    }

    public CourseFile getCourseFile() {
        return courseFile;
    }

    public void setCourseFile(CourseFile courseFile) {
        this.courseFile = courseFile;
    }
}
