package www.ht.com.app.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;
import www.ht.com.app.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends BaseFragment {


    private static final String ARG_TITLE = "ARG_TITLE";
    private String mParamTitle;

    public static MapFragment newInstance(String Title) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, Title);
        fragment.setArguments(args);
        fragment.setTitle(Title);
        return fragment;
    }

    public MapFragment() {

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
        return inflater.inflate(R.layout.fragment_map, container, false);
    }


}
