package www.ht.com.ap.ui.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import www.ht.com.ap.R;
import www.ht.com.ap.base.BaseFragment;
import www.ht.com.ap.view.TabImageView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FindTeacherFM#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FindTeacherFM extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_teacher_fm, container, false);
    }

    @Bind(R.id.imageview) TabImageView tabImageView;
    @Bind(R.id.imageviewPress) TabImageView tabImageviewPress;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabImageView.setImageResource(R.drawable.icon_review);
        tabImageView.invalidate();
        tabImageviewPress.setImageResource(R.drawable.icon_review);


        tabImageviewPress.checked(true);
        tabImageView.checked(false);


    }
}
