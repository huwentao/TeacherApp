package www.ht.com.ap.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;

import www.ht.com.ap.R;
import www.ht.com.ap.tools.DisplayUtil;

/**
 * Created by mokey on 2015/8/5.
 */
public class TabImageView extends ImageView {
    private float imageSize;
    private static Bitmap mBitmap;
    private static Bitmap mBitmapPress;
    private Paint paint;
    private boolean isChecked = false;

    public TabImageView(Context context) {
        super(context);
    }

    public TabImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabImageView);
        Bitmap mBitmap = null;
        Bitmap mBitmapPress = null;
        Bitmap tempBitmap = null;

        Drawable drawable = typedArray.getDrawable(R.styleable.TabImageView_TabImageImageSrc);
        if (drawable != null) {
            tempBitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        imageSize = typedArray.getDimension(R.styleable.TabImageView_TabImageImageTargetWidth, 0);
        int bitmapColor = typedArray.getColor(R.styleable.TabImageView_TabImageImageColor, 0);
        if (bitmapColor > 0) {
            mBitmap = getAlphaBitmap(tempBitmap, imageSize, bitmapColor);
        }
        int bitmapColorPress = typedArray.getColor(R.styleable.TabImageView_TabImageImageColor, 0);
        if (bitmapColorPress > 0) {
            mBitmapPress = getAlphaBitmap(tempBitmap, imageSize, bitmapColorPress);
        }

        init(mBitmap, mBitmapPress);
        typedArray.recycle();
    }

    public TabImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        if (!isChecked && mBitmap != null) {
            float left =  Math.abs(imageSize - mBitmap.getWidth())/2;
            System.out.println("left=>"+left);
            canvas.drawBitmap(mBitmap, 0, 0, paint);
        } else if (mBitmapPress != null) {
            float left =  Math.abs(imageSize - mBitmapPress.getWidth())/2;
            System.out.println("left=>"+left);
            canvas.drawBitmap(mBitmapPress, 0, 0, paint);
        } else {
            super.onDraw(canvas);
        }
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void checked(boolean isChecked) {
        this.isChecked = isChecked;
        invalidate();
    }


    public void init(Bitmap bitmap, Bitmap bitmapPress) {
        mBitmap = bitmap;
        mBitmapPress = bitmapPress;
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
