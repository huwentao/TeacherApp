package www.ht.com.ap.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.Bind;
import www.ht.com.ap.R;
import www.ht.com.ap.base.BaseFragment;
import www.ht.com.ap.ui.fragment.adapter.CourseRecylerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseDetailFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_COURSE_TYPE = "COURSE_TYPE";
    private static final String ARG_TITLE = "TITLE";
    public static final String WEEK_TYPE = "week_type";
    public static final String MONTH_TYPE = "month_type";
    // TODO: Rename and change types of parameters
    private String mParamCourseType;
    private String mParamTitle;

     RecyclerView recyclerView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param courseType Parameter 1.
     * @param Title      Parameter 2.
     * @return A new instance of fragment BaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseDetailFragment newInstance(String courseType, String Title) {
        CourseDetailFragment fragment = new CourseDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COURSE_TYPE, courseType);
        args.putString(ARG_TITLE, Title);
        fragment.setArguments(args);
        fragment.setTitle(Title);
        return fragment;
    }

    public CourseDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamCourseType = getArguments().getString(ARG_COURSE_TYPE);
            mParamTitle = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_course_detail, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        CourseRecylerAdapter recylerAdapter = new CourseRecylerAdapter();
        recyclerView.setAdapter(recylerAdapter);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
