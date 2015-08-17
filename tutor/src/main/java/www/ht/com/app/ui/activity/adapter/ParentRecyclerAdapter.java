package www.ht.com.app.ui.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;

/**
 * Created by mokey on 2015/8/14.
 */
public class ParentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int PARENT_SIGN = 1;
    private static final int PARENT_LAST = 2;
    private static final int LAST_COURSE = 3;
    private static final int LAST_RECOMMENT = 4;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case PARENT_SIGN:
                View infoView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_parent_sign, parent, false);
                viewHolder = new ParentSign(infoView);
                break;
            case PARENT_LAST:
                View historyView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_parent_last_info, parent, false);
                viewHolder = new ParentLast(historyView);
                break;
            case LAST_COURSE:
                View shareView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_parentlastcourse_info, parent, false);
                viewHolder = new LastCourse(shareView);
                break;
            case LAST_RECOMMENT:
                View ratingView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_lastrecomment_info, parent, false);
                viewHolder = new LastRecomment(ratingView);
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
                return PARENT_SIGN;
            case 1:
                return PARENT_LAST;
            case 2:
                return LAST_COURSE;
            case 3:
                return LAST_RECOMMENT;
        }
        return super.getItemViewType(position);
    }

    static class ParentSign extends RecyclerView.ViewHolder {

        public ParentSign(View itemView) {
            super(itemView);
        }
    }

    static class ParentLast extends RecyclerView.ViewHolder {

        public ParentLast(View itemView) {
            super(itemView);
        }
    }

    static class LastCourse extends RecyclerView.ViewHolder {

        public LastCourse(View itemView) {
            super(itemView);
        }
    }

    static class LastRecomment extends RecyclerView.ViewHolder {

        public LastRecomment(View itemView) {
            super(itemView);
        }
    }


}
