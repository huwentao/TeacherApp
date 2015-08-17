package www.ht.com.app.ui.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.BaseFragment;
import www.ht.com.app.ui.fragment.adapter.FindRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class FindTeacherFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_teacher, container, false);
        return view;
    }

    @Bind(R.id.recyclerView)RecyclerView recyclerView;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().initToolBar();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        FindRecyclerAdapter recyclerAdapter = new FindRecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
    }


}
