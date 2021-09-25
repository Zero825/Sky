package com.news.sky.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.news.sky.R;
import com.news.sky.util.AppUtil;
import com.news.sky.util.UIUtil;

import static android.graphics.Paint.Align.CENTER;
import static android.graphics.Paint.Align.RIGHT;

public class LinearColorsView extends View {
    private Paint paint;
    private Rect rect;
    private int[] colors;

    public LinearColorsView(Context context) {
        super(context);
        init();
    }

    public LinearColorsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearColorsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public LinearColorsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setAntiAlias(true);
        rect = new Rect();
        colors = new int[]{
                getResources().getColor(R.color.primary_color_1),
                getResources().getColor(R.color.primary_color_2),
                getResources().getColor(R.color.primary_color_3),
                getResources().getColor(R.color.primary_color_4),
                getResources().getColor(R.color.primary_color_5),
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int splitWidth = width / 5;
        rect.set(0,0,splitWidth,height);
        canvas.save();
        for (int color : colors) {
            paint.setColor(color);
            canvas.drawRect(rect, paint);
            canvas.translate(splitWidth, 0);
        }
        canvas.restore();
//        paint.setColor(Color.WHITE);
//        paint.setTextSize(AppUtil.sp2px(getContext(),20));
//        paint.setTextAlign(RIGHT);
//
//        Paint.FontMetrics fontMetrics=paint.getFontMetrics();
//        float distance=(fontMetrics.descent - fontMetrics.ascent)/2 - fontMetrics.descent;
//        float baseline=height / 2f + distance;
//        canvas.drawText("超级敏感",width - AppUtil.dip2px(getContext(),16),baseline,paint);
    }
}
