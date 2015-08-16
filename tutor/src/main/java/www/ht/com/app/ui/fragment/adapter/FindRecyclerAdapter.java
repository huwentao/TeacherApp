package www.ht.com.app.ui.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.ui.activity.NearTeacherActivity;
import www.ht.com.app.ui.activity.ParentAskActivity;

/**
 * Created by mokey on 2015/8/16.
 */
public class FindRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int AD_IMAGES = 1;
    private static final int FIND_TYPE = 2;
    private static final int POPULAR_TEACHER = 3;
    private static final int POPULAR_COURSE = 4;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case AD_IMAGES:
                View infoView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_ad_images, parent, false);
                viewHolder = new ADImages(infoView);
                break;
            case FIND_TYPE:
                View historyView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_find_type, parent, false);
                viewHolder = new FindType(historyView);
                break;
            case POPULAR_TEACHER:
                View shareView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_popular_teachers, parent, false);
                viewHolder = new PopularTeacher(shareView);
                break;
            case POPULAR_COURSE:
                View ratingView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_popular_course, parent, false);
                viewHolder = new PopularCourse(ratingView);
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
                return AD_IMAGES;
            case 1:
                return FIND_TYPE;
            case 2:
                return POPULAR_TEACHER;
            case 3:
                return POPULAR_COURSE;
        }
        return super.getItemViewType(position);
    }

    static class ADImages extends RecyclerView.ViewHolder {

        public ADImages(View itemView) {
            super(itemView);
        }
    }

    static class FindType extends RecyclerView.ViewHolder {
        @Bind(R.id.parentAsk) TextView parentAsk;
        @Bind(R.id.nearTeacher) TextView nearTeacher;

        public FindType(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.parentAsk, R.id.nearTeacher})
        public void findTypeClick(View view) {
            Context context = view.getContext();
            switch (view.getId()) {
                case R.id.parentAsk:
                    Intent parentAskIntent = new Intent(context, ParentAskActivity.class);
                    context.startActivity(parentAskIntent);
                    break;
                case R.id.nearTeacher:
                    Intent nearTeacherIntent = new Intent(context, NearTeacherActivity.class);
                    context.startActivity(nearTeacherIntent);
                    break;
            }
        }
    }

    static class PopularTeacher extends RecyclerView.ViewHolder {

        public PopularTeacher(View itemView) {
            super(itemView);
        }
    }

    static class PopularCourse extends RecyclerView.ViewHolder {

        public PopularCourse(View itemView) {
            super(itemView);
        }
    }

}
