package com.developer.saarang.coregraphics;

import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class DrawDonut extends AppCompatActivity {
    private MyCustomView myCustomView;
    private Map<String, Integer> dimen = new HashMap();
    private MyCustomDrawable myCustomDrawable;
    Paint base_paint = new Paint();
    private ImageView image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_donut);
        //myCustomView = new MyCustomView(this);
        setContentView(R.layout.activity_main);
        image_view=findViewById(R.id.imageView);

        myCustomDrawable=new MyCustomDrawable(this);
        //setContentView(myCustomView);
        dimen = getScreenDimensions();
        drawDonut(dimen);

    }

    private void drawDonut(Map dimen) {
        if (dimen != null) {
            base_paint.setColor(0xFFc6853b);
            myCustomDrawable.setDimensions_paint((int) dimen.get("height"), (int) dimen.get("width"), (int)image_view.getX(),(int) image_view.getY(), base_paint);
            image_view.setImageDrawable(myCustomDrawable);

           // myCustomView.setDimensions_paint((int) dimen.get("height"), (int) dimen.get("width"), base_paint);
        }



    }

    public Map<String, Integer> getScreenDimensions() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        dimen.put("width", displayMetrics.widthPixels);
        dimen.put("height", displayMetrics.heightPixels);
        return dimen;
    }
}
