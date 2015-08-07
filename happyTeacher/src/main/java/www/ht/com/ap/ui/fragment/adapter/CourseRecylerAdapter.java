package www.ht.com.ap.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.ap.R;

/**
 * Created by mokey on 2015/8/7.
 */
public class CourseRecylerAdapter extends RecyclerView.Adapter<CourseRecylerAdapter.CourseView> {

    @Override
    public CourseView onCreateViewHolder(ViewGroup parent, int viewType) {
        View courseView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_course_view, parent, false);
        return new CourseView(courseView);
    }

    @Override
    public void onBindViewHolder(CourseView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CourseView extends RecyclerView.ViewHolder {

        public CourseView(View itemView) {
            super(itemView);
        }
    }
}
