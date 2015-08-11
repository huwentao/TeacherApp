package www.ht.com.app.view.tabview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;

import www.ht.com.app.R;

/**
 * Created by mokey on 2015/8/5.
 */
public class TabImageView extends ImageView {
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
    private int mBitmapColor;
    private int mBitmapColorPress;
    private float mImageSize;
    private Bitmap mBitmap;
    private Paint mPaint;
    private boolean isChecked = false;

    public TabImageView(Context context) {
        super(context);
    }

    public TabImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabImageView);
        Drawable drawable = typedArray.getDrawable(R.styleable.TabImageView_TabImageImageSrc);
        if (drawable != null) {
            mBitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        mImageSize = typedArray.getDimension(R.styleable.TabImageView_TabImageImageTargetWidth, 0);
        mBitmapColor = typedArray.getColor(R.styleable.TabImageView_TabImageImageColor, 0);
        mBitmapColorPress = typedArray.getColor(R.styleable.TabImageView_TabImageImageColorPress, 0);

        typedArray.recycle();
    }

    public TabImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        if (mBitmap == null) {
            super.onDraw(canvas);
            return;
        }
        if (!isChecked) {
            drawAlphaBitmap(canvas, mBitmap, mImageSize, mBitmapColor);
        } else {
            drawAlphaBitmap(canvas, mBitmap, mImageSize, mBitmapColorPress);
        }
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void checked(boolean isChecked) {
        this.isChecked = isChecked;
        invalidate();
    }


    public void init(Bitmap bitmap, int bitmapColor, int bitmapColorPress, float imageSize) {
        mBitmap = bitmap;
        mBitmapColor = bitmapColor;
        mBitmapColorPress = bitmapColorPress;
        mImageSize = imageSize;
    }

    /**
     * 提取图像Alpha位图
     *
     * @param mBitmap
     * @param mColor
     * @return
     */
    public void drawAlphaBitmap(Canvas mCanvas, Bitmap mBitmap, float imageSize, int mColor) {
        if (mBitmap != null) {
            mPaint.reset();
            mPaint.setColor(mColor);
            /*抗锯齿设置*/
            mPaint.setAntiAlias(true);
//            mCanvas.setDrawFilter(mPaintFlagsDrawFilter);
            //从原位图中提取只包含alpha的位图
            Bitmap alphaBitmap = mBitmap.extractAlpha();
            Matrix matrix = new Matrix();
            float scalex = imageSize / mBitmap.getWidth();
            matrix.setScale(scalex, scalex);

            Bitmap mAlphaBitmap = Bitmap.createBitmap(alphaBitmap,
                    0, 0,
                    mBitmap.getWidth(), mBitmap.getHeight(),
                    matrix,
                    false);
            float offsetx = ((float) mCanvas.getWidth() - (float) mAlphaBitmap.getWidth()) / 2;
            //在画布上（mAlphaBitmap）绘制alpha位图
            mCanvas.drawBitmap(mAlphaBitmap, offsetx, 0, mPaint);
        }
    }
}
