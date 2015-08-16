package www.ht.com.app.ui.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;

/**
 * Created by mokey on 2015/8/16.
 */
public class MyCourseFileRecyclerAdapter extends RecyclerView.Adapter<MyCourseFileRecyclerAdapter.CourseFiles> {

    @Override
    public CourseFiles onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_mycoursefiles, parent, false
        );
        return new CourseFiles(view);
    }

    @Override
    public void onBindViewHolder(CourseFiles holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class CourseFiles extends RecyclerView.ViewHolder {
        public CourseFiles(View itemView) {
            super(itemView);
        }
    }

}
