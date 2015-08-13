package www.ht.com.app.ui.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

import www.ht.com.app.R;

/**
 * Created by mokey on 2015/8/14.
 */
public class TeacherRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TEACHER_INFO = 4;
    private static final int TEACHER_HISTORY = 1;
    private static final int TEACHER_SHARE = 2;
    private static final int TEACHER_RATING = 3;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TEACHER_INFO:
                View infoView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_teacher_info, parent, false);
                viewHolder = new TeacherInfoView(infoView);
                break;
            case TEACHER_HISTORY:
                View historyView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_teacherhistory_info, parent, false);
                viewHolder = new TeacherHistory(historyView);
                break;
            case TEACHER_SHARE:
                View shareView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_teachershare_info, parent, false);
                viewHolder = new TeacherShare(shareView);
                break;
            case TEACHER_RATING:
                View ratingView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_teacherrating_info, parent, false);
                viewHolder = new TeacherRating(ratingView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TEACHER_INFO;
            case 1:
                return TEACHER_HISTORY;
            case 2:
                return TEACHER_SHARE;
            case 3:
                return TEACHER_RATING;
        }
        return super.getItemViewType(position);
    }

    static class TeacherInfoView extends RecyclerView.ViewHolder {

        public TeacherInfoView(View itemView) {
            super(itemView);
        }
    }

    static class TeacherHistory extends RecyclerView.ViewHolder {

        public TeacherHistory(View itemView) {
            super(itemView);
        }
    }

    static class TeacherShare extends RecyclerView.ViewHolder {

        public TeacherShare(View itemView) {
            super(itemView);
        }
    }

    static class TeacherRating extends RecyclerView.ViewHolder {

        public TeacherRating(View itemView) {
            super(itemView);
        }
    }
}
