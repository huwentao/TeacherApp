package www.ht.com.ap.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.ht.com.ap.R;

/**
 * Created by mokey on 2015/8/5.
 */
public class TabViewLayout extends LinearLayout {

    @Bind({R.id.tabView_1, R.id.tabView_2, R.id.tabView_3, R.id.tabView_4}) List<TabView> mTabViews;
    @Bind(R.id.tabViewLayout) LinearLayout tabViewLayout;

    public TabViewLayout(Context context) {
        super(context);
    }

    public TabViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.layout_tab_layout, this);
        ButterKnife.bind(this, view);
        mTabViews.get(0).init(R.drawable.icon_find, context.getResources().getString(R.string.icon_find_text));
        mTabViews.get(1).init(R.drawable.icon_review, context.getResources().getString(R.string.icon_review_text));
        mTabViews.get(2).init(R.drawable.icon_course, context.getResources().getString(R.string.icon_course_text)).checked(true);
        mTabViews.get(3).init(R.drawable.icon_heart, context.getResources().getString(R.string.icon_discover_text));
    }

    public TabViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @OnClick({R.id.tabView_1, R.id.tabView_2, R.id.tabView_3, R.id.tabView_4})
    public void onClick(TabView view) {
        for (int i = 0; i < mTabViews.size(); i++) {
            if (view.getId() == mTabViews.get(i).getId()) {
                mTabViews.get(i).checked(true);
            } else {
                mTabViews.get(i).checked(false);
            }
        }
    }
}
