package com.developer.saarang.coregraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MyCustomDrawable extends Drawable {
    Context context;
    private int height, width;
    private Paint paint;
    private int X, Y;
    private Canvas canvas;
    private  Path hole_path;
    public MyCustomDrawable(Context context) {
        this.context = context;
    }


    public void setDimensions_paint(int height, int width, int X, int Y, Paint paint) {
        this.height = height;
        this.width = width;
        this.paint = paint;
        this.X = X;
        this.Y = Y;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        // draw base biscuit
        this.canvas = canvas;
        canvas.drawCircle(X + width / 2, Y + height / 2, width / 3, paint);
        canvas.clipPath(hole_path);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
       if(bounds!=null) {
           // cut biscuit at the center
           hole_path = new Path();
           hole_path.reset();
           hole_path.addCircle(X + width / 2, Y + height / 2, width / 6, Path.Direction.CW);

        }
        super.onBoundsChange(bounds);
    }
}
