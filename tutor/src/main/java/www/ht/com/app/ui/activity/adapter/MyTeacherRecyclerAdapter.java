package www.ht.com.app.ui.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.Bind;

import butterknife.ButterKnife;
import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.ui.activity.TeacherActivity;

/**
 * Created by mokey on 2015/8/16.
 */
public class MyTeacherRecyclerAdapter extends RecyclerView.Adapter<MyTeacherRecyclerAdapter.Teacher> {

    @Override
    public Teacher onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_myteacher, parent, false
        );
        return new Teacher(view);
    }

    @Override
    public void onBindViewHolder(Teacher holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class Teacher extends RecyclerView.ViewHolder {
        @Bind(R.id.itemViewLayout) RelativeLayout itemViewLayout;

        public Teacher(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.itemViewLayout)
        public void itemClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, TeacherActivity.class);
            context.startActivity(intent);
        }
    }
}
