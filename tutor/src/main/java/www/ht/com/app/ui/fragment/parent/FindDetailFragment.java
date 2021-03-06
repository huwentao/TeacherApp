/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.fragment.parent;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;
import www.ht.com.app.ui.core.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindDetailFragment extends BaseFragment {
    private static final String ARG_TITLE = "ARG_TITLE";
    private String mParamTitle;


    public static FindDetailFragment newInstance(String Title) {
        FindDetailFragment fragment = new FindDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, Title);
        fragment.setArguments(args);
        fragment.setTitle(Title);
        return fragment;
    }

    public FindDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamTitle = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
