package www.ht.com.app.ui.fragment.teacher;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherDiscoverFragment extends BaseFragment {
    @Bind(R.id.toolbar) Toolbar toolbar;

    public TeacherDiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_discover, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().initToolBar();
    }
}
