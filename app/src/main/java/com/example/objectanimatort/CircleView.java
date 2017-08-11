package com.example.objectanimatort;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/11.
 */

public class CircleView extends View {
    private Point point=new Point(100);
    private Paint paint=new Paint();
    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(point!=null){
            paint.setAntiAlias(true);

            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,point.getRadius(),paint);
        }
    }
    void setPointRadius(int radius){
        point.setRadius(radius);
        invalidate();
    }
    void setPointColor(int color){
        paint.setColor(color);
        invalidate();
    }
}
