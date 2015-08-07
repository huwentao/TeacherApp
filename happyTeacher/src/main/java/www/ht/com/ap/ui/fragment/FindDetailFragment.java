package www.ht.com.ap.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.ap.R;
import www.ht.com.ap.base.BaseFragment;
import www.ht.com.ap.ui.fragment.adapter.CourseRecylerAdapter;

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
