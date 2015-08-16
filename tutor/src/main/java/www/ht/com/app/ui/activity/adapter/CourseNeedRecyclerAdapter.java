package www.ht.com.app.ui.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;

/**
 * Created by mokey on 2015/8/16.
 */
public class CourseNeedRecyclerAdapter extends RecyclerView.Adapter<CourseNeedRecyclerAdapter.CourseNeed> {

    @Override
    public CourseNeed onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_course_need, parent, false
        );
        return new CourseNeed(view);
    }

    @Override
    public void onBindViewHolder(CourseNeed holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class CourseNeed extends RecyclerView.ViewHolder {
        public CourseNeed(View itemView) {
            super(itemView);
        }
    }
}
