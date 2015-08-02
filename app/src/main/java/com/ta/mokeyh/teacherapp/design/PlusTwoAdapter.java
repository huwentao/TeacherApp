package com.ta.mokeyh.teacherapp.design;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ta.mokeyh.teacherapp.R;

/**
 * Created by mokey on 2015/8/2.
 */
public class PlusTwoAdapter extends RecyclerView.Adapter<PlusTwoAdapter.PTViewHolder> {


    @Override
    public PlusTwoAdapter.PTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.layout_plus_two, null);

        return new PTViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlusTwoAdapter.PTViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class PTViewHolder extends RecyclerView.ViewHolder {
        public PTViewHolder(View itemView) {
            super(itemView);
        }
    }
}
