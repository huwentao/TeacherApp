package www.ht.com.app.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.UUID;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    private String mName = UUID.randomUUID().toString();
    private String mTitle = "";

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 取到Fragment Name
     * @return
     */
    public String getName() {
        return mName;
    }

    /**
     * 设置Fragment标题
     * @return
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * 取到Fragment标题
     * @param title
     */
    public void setTitle(String title) {
        mTitle = title;
    }
}
