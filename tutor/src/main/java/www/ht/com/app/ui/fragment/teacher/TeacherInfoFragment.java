package www.ht.com.app.ui.fragment.teacher;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.ht.com.app.R;
import www.ht.com.app.ui.BaseFragment;
import www.ht.com.app.ui.fragment.adapter.TeacherInfoRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeacherInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherInfoFragment extends BaseFragment {


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TeacherInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherInfoFragment newInstance() {
        TeacherInfoFragment fragment = new TeacherInfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setTitle("主页");
        return fragment;
    }

    public TeacherInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView recyclerView = null;
    private LinearLayoutManager layoutManager = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teacher_info, container, false);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TeacherInfoRecyclerAdapter infoRecyclerAdapter = new TeacherInfoRecyclerAdapter();
        recyclerView.setAdapter(infoRecyclerAdapter);
    }
}
