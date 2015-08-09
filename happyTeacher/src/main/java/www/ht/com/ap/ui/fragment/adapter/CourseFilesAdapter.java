package www.ht.com.ap.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.ap.R;

/**
 * Created by mokey on 2015/8/9.
 */
public class CourseFilesAdapter extends RecyclerView.Adapter<CourseFilesAdapter.CourseFileView> {

    @Override
    public CourseFileView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.layout_coursefiles_view,parent );
        return new CourseFileView(view);
    }

    @Override
    public void onBindViewHolder(CourseFileView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class CourseFileView extends RecyclerView.ViewHolder{
        public CourseFileView(View itemView) {
            super(itemView);
        }
    }

}
