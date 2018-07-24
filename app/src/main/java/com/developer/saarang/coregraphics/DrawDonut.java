package com.developer.saarang.coregraphics;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.util.HashMap;
import java.util.Map;

public class DrawDonut extends AppCompatActivity {
    private MyCustomView myCustomView;
    private Map<String, Integer> dimen = new HashMap();
    Paint base_paint = new Paint();
    Paint icing_paint = new Paint();
    Paint sprinkle_paint = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_donut);
        myCustomView = new MyCustomView(this);
        setContentView(myCustomView);
        dimen = getScreenDimensions();
        drawDonut(dimen);

    }

    private void drawDonut(Map dimen) {
        if (dimen != null) {
            base_paint.setColor(0xFFc6853b);
            icing_paint.setColor(0xFF542A0C);
            sprinkle_paint.setColor(Color.RED);
            // sprinkle_paint.setColor(0xFFFFFFFF);

            myCustomView.setDimensions_paint((int) dimen.get("height"), (int) dimen.get("width"), base_paint, icing_paint, sprinkle_paint);

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
