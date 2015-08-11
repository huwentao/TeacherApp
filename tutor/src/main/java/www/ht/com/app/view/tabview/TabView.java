package www.ht.com.app.view.tabview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.ht.com.app.R;

/**
 * Created by mokey on 2015/8/5.
 */
public class TabView extends LinearLayout {
    private Bitmap mBitmap;
    private int mBitmapColor;
    private int mBitmapColorPress;

    @Bind(R.id.tabViewImage) TabImageView mTabViewImage;
    @Bind(R.id.tabViewText) TextView mTabViewText;
    @Bind(R.id.tabView) LinearLayout mTabView;
    private boolean isChecked;

    public TabView(Context context) {
        super(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.layout_tab_view, this);
        ButterKnife.bind(this, view);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabView);
        mBitmap = null;

        Drawable drawable = typedArray.getDrawable(R.styleable.TabView_TabImageSrc);
        if (drawable != null) {
            mBitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        float imageSize = typedArray.getDimension(R.styleable.TabView_TabImageTargetWidth, 0);
        mBitmapColor = typedArray.getColor(R.styleable.TabView_TabImageColor, 0);
        mBitmapColorPress = typedArray.getColor(R.styleable.TabView_TabImageColorPress, 0);

        mTabViewImage.init(mBitmap, mBitmapColor, mBitmapColorPress, imageSize);

        typedArray.recycle();

    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化显示
     *
     * @param imageResId
     * @param tabText
     */
    public TabView init(String tabText) {
        mTabViewText.setText(tabText);
        return this;
    }

    /**
     * 设置为选中状态
     */
    public void checked(boolean isChecked) {
        mTabViewImage.checked(isChecked);
        this.isChecked = isChecked;
        if (isChecked) {
            mTabViewText.setTextColor(mBitmapColorPress);
        } else {
            mTabViewText.setTextColor(mBitmapColor);
        }
    }

    public boolean isChecked() {
        return isChecked;
    }


}
