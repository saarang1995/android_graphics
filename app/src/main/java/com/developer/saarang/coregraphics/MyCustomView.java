package com.developer.saarang.coregraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;

public class MyCustomView extends View {
    private int height, width;
    private Paint paint;

    public MyCustomView(Context context) {
        super(context);
    }

    public void setDimensions_paint(int height, int width, Paint paint) {
        this.height = height;
        this.width = width;
        this.paint = paint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        // draw base biscuit
//        canvas.drawCircle(getX() + getWidth() / 2, getY() + getHeight() / 2, width / 2, paint);
//
//        // cut biscuit at the center
//        Path hole_path = new Path();
//        hole_path.reset();
//        hole_path.addCircle(getX() + getWidth() / 2, getY() + getHeight() / 2, width / 6, Path.Direction.CW);
//        canvas.clipPath(hole_path, Region.Op.DIFFERENCE);
        super.onDraw(canvas);


    }



}
