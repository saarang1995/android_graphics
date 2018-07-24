package com.developer.saarang.coregraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;

import java.util.Random;

public class MyCustomView extends View {
    private int height, width;
    private Paint base_paint, icing_paint, sprinkle_paint;
    private float mod_distance, padding = 12f, distance = 3f, angle = 30f, rotation = 20f, holeradius, ringRadius;
    private float centerX, centerY;
    private int j;

    public MyCustomView(Context context) {
        super(context);
    }

    public void setDimensions_paint(int height, int width, Paint base_paint, Paint icing_paint, Paint sprinkle_paint) {
        this.height = height;
        this.width = width;
        this.base_paint = base_paint;
        this.icing_paint = icing_paint;
        this.sprinkle_paint = sprinkle_paint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        centerX = getX() + width / 2;
        centerY = getY() + height / 2;
        holeradius = width / 6.5f;
        ringRadius = width / 2.8f;


        // draw base biscuit:
        // cut biscuit at the center
        Path hole_path = new Path();
        hole_path.reset();
        hole_path.addCircle(centerX, centerY, width / 6.5f, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(hole_path, Region.Op.DIFFERENCE);

        canvas.drawCircle(centerX, centerY, width / 2.5f, base_paint);
        //canvas.restore();             // move the canvas back to the original state.


        // drawing icing using path effect:
        DiscretePathEffect discretePathEffect = new DiscretePathEffect(60f, 25f);
        CornerPathEffect cornerPathEffect = new CornerPathEffect(40f);
        ComposePathEffect composePathEffect = new ComposePathEffect(cornerPathEffect, discretePathEffect);
        icing_paint.setPathEffect(composePathEffect);
        canvas.drawCircle(centerX, centerY, width / 2.8f, icing_paint);
        canvas.save();

        //move the canvas
        int i = 0;
        while (mod_distance < ringRadius - 110) {
            mod_distance = i+10;
            System.out.println("Dis: " + mod_distance);
            //move the canvas
            canvas.save();
            canvas.rotate(angle + i * 2f, centerX, centerY);
            canvas.translate(0f, mod_distance);
            canvas.rotate(rotation-i, centerX, centerY);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            sprinkle_paint.setColor(color);
            canvas.drawRoundRect(centerX - 7f, centerY - 22f, centerX + 7f, centerY + 22f, 10f, 10f, sprinkle_paint);
            i++;

        }
        //  rotateCanvas(canvas);


    }

    public void rotateCanvas(Canvas canvas) {
        canvas.rotate(10);
    }


}
