package www.ht.com.app.view.teacherrating;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import www.ht.com.app.R;

/**
 * Created by mokey on 2015/8/15.
 */
public class TeacherInfoView extends LinearLayout {
    public TeacherInfoView(Context context) {
        super(context);
    }

    public TeacherInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_teacherinfo,this);
    }

    public TeacherInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
