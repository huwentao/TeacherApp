package www.ht.com.app.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;

/**
 * Created by monkey on 2015/8/11.
 */
public class TeacherInfoRecyclerAdapter extends RecyclerView.Adapter<TeacherInfoRecyclerAdapter.TeacherInfoView> {

    @Override
    public TeacherInfoView onCreateViewHolder(ViewGroup parent, int viewType) {
        View courseView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_review_view, parent, false);
        return new TeacherInfoView(courseView);
    }

    @Override
    public void onBindViewHolder(TeacherInfoView holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class TeacherInfoView extends RecyclerView.ViewHolder {

        public TeacherInfoView(View itemView) {
            super(itemView);
        }
    }
}
