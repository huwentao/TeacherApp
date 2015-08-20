package www.ht.com.app.view.tabview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.ht.com.app.R;

/**
 * Created by mokey on 2015/8/5.
 */
public class TeacherTabViewLayout extends LinearLayout {

    @Bind({R.id.tabView_1, R.id.tabView_2, R.id.tabView_3, R.id.tabView_4})
    List<TabView> mTabViews;
    @Bind(R.id.tabViewLayout) LinearLayout tabViewLayout;

    private int checkedIndex = 0;
    private OnTabViewChangeListener mOnTabViewChangeListener;

    public TeacherTabViewLayout(Context context) {
        super(context);
    }

    public TeacherTabViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.layout_teacher_tab_layout, this);
        ButterKnife.bind(this, view);
        mTabViews.get(0).init(context.getResources().getString(R.string.icon_review_text));
        mTabViews.get(1).init(context.getResources().getString(R.string.icon_course_text));
        mTabViews.get(2).init(context.getResources().getString(R.string.icon_discover_text));
        mTabViews.get(3).init(context.getResources().getString(R.string.icon_person_text));
        checkIndex(0);
    }

    public TeacherTabViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @NonNull
    @OnClick({R.id.tabView_1, R.id.tabView_2, R.id.tabView_3, R.id.tabView_4})
    public void onClick(TabView view) {
        int index = check(view);
        if (mOnTabViewChangeListener != null) {
            mOnTabViewChangeListener.onChange(index);
        }
    }

    /**
     * 设置选中项
     *
     * @param index {@link TeacherTabViewLayout#checkedIndex}
     */
    public void checkIndex(int index) {
        checkedIndex = index;
        check(mTabViews.get(checkedIndex));
        if (mOnTabViewChangeListener != null) {
            mOnTabViewChangeListener.onChange(index);
        }
    }

    /**
     * 设置要选中的View
     *
     * @param view {@link TabView}
     */
    private int check(View view) {
        int index = 0;
        for (int i = 0; i < mTabViews.size(); i++) {
            if (view.getId() == mTabViews.get(i).getId()) {
                if (!mTabViews.get(i).isChecked()) {
                    mTabViews.get(i).checked(true);
                }
                index = i;
            } else {
                if (mTabViews.get(i).isChecked()) {
                    mTabViews.get(i).checked(false);
                }
            }
        }
        return index;
    }

    /**
     * 监听Tab切换（请在checkIndex方法之前设置）
     *
     * @param onTabViewChangeListener {@link TeacherTabViewLayout.OnTabViewChangeListener}
     */
    public void setOnTabViewChangeListener(OnTabViewChangeListener onTabViewChangeListener) {
        mOnTabViewChangeListener = onTabViewChangeListener;
    }

    public interface OnTabViewChangeListener {
        public void onChange(int index);
    }
}
