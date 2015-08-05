package www.ht.com.ap.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.ht.com.ap.R;
import www.ht.com.ap.tools.DisplayUtil;

/**
 * Created by mokey on 2015/8/5.
 */
public class TabView extends LinearLayout {
    private static Bitmap mBitmap;
    private static Bitmap mBitmapPress;
    private int bitmapColor;
    private int bitmapColorPress;
    @Bind(R.id.tabViewImage) TabImageView mTabViewImage;
    @Bind(R.id.tabViewText) TextView mTabViewText;
    @Bind(R.id.tabView) LinearLayout mTabView;
    private int mBackgroundColor = -1;
    private int mBackgroundDrawable = -1;
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
        mBitmapPress = null;
        Bitmap tempBitmap = null;

        Drawable drawable = typedArray.getDrawable(R.styleable.TabView_TabImageSrc);
        if (drawable != null) {
            tempBitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        float imageSize = typedArray.getDimension(R.styleable.TabView_TabImageTargetWidth, 0);
        bitmapColor = typedArray.getColor(R.styleable.TabView_TabImageColor, 0);
        if (bitmapColor != 0) {
            mBitmap = getAlphaBitmap(tempBitmap, imageSize, bitmapColor);
        }
        bitmapColorPress = typedArray.getColor(R.styleable.TabView_TabImageColor, 0);
        if (bitmapColorPress != 0) {
            mBitmapPress = getAlphaBitmap(tempBitmap, imageSize, bitmapColorPress);
        }

        mTabViewImage.init(mBitmap, mBitmapPress);

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
    public TabView init(int imageResId, String tabText) {
        mTabViewImage.setImageResource(imageResId);
        mTabViewText.setText(tabText);
        return this;
    }

    /**
     * 设置为选中状态
     */
    public void checked(boolean isChecked) {
        mTabViewImage.init(mBitmap, mBitmapPress);
        mTabViewImage.checked(isChecked);
        if (isChecked) {
            mTabViewText.setTextColor(bitmapColorPress);
        } else {
            mTabViewText.setTextColor(bitmapColor);
        }
    }

    public boolean isChecked() {
        return isChecked;
    }

    /**
     * 提取图像Alpha位图
     *
     * @param mBitmap
     * @param mColor
     * @return
     */
    public Bitmap getAlphaBitmap(Bitmap mBitmap, float imageSize, int mColor) {
        if (mBitmap != null) {
            Bitmap mAlphaBitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);

            Matrix matrix = new Matrix();
            float scalex = (float) DisplayUtil.dip2px(getContext(), imageSize) / mAlphaBitmap.getWidth();
            matrix.setScale(scalex, scalex);

            Canvas mCanvas = new Canvas(mAlphaBitmap);
            Paint mPaint = new Paint();

            mPaint.setColor(mColor);
            //从原位图中提取只包含alpha的位图
            Bitmap alphaBitmap = mBitmap.extractAlpha();
            //在画布上（mAlphaBitmap）绘制alpha位图
            mCanvas.drawBitmap(alphaBitmap, matrix, mPaint);

            return mAlphaBitmap;
        }
        return null;
    }
}
