package com.developer.saarang.coregraphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas canvas;
    private Paint paint = new Paint();
    private Paint paint_text = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap bitmap;

    private ImageView image_view;

    private Rect rect = new Rect();
    private Rect bounds = new Rect();

    private static final int OFFSET = 120;
    private int offset = OFFSET;
    private static final int MULTIPLIER = 100;

    private int color_background;
    private int color_rectangle;
    private int color_accent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init Image View and its click event:
        int_imageView();

        // set color of paint to color_background
        paint.setColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, null));
        // set text size for paint_text
        paint_text.setTextSize(70);

        init_color_res();
    }

    private void int_imageView() {
        image_view = findViewById(R.id.imageView);
        image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawSomething(v);
            }
        });
    }

    private void drawSomething(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        int half_width = width / 2;
        int half_height = height / 2;


        if (offset == OFFSET) {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            image_view.setImageBitmap(bitmap);
            canvas = new Canvas(bitmap);
            canvas.drawColor(color_background);
            canvas.drawText(getString(R.string.keep_tapping), 100, 100, paint_text);
            offset += OFFSET;
        } else {
            if (offset < half_width && offset < half_height) {
                // Change the color by subtracting an integer.
                paint.setColor(color_rectangle - MULTIPLIER * offset);
                rect.set(
                        offset, offset, width - offset, height - offset);
                canvas.drawRect(rect, paint);
                // Increase the indent.
                offset += OFFSET;
            } else {
                paint.setColor(color_accent);
                canvas.drawCircle(half_width, half_height, half_width / 3, paint);
                String text = getString(R.string.done);
                // Get bounding box for text to calculate where to draw it.
                paint_text.getTextBounds(text, 0, text.length(), bounds);
                // Calculate x and y for text so it's centered.
                int x = half_width - bounds.centerX();
                int y = half_height - bounds.centerY();
                canvas.drawText(text, x, y, paint_text);
            }
        }
        view.invalidate();
    }

    private void init_color_res() {
        color_background = ResourcesCompat.getColor(getResources(), R.color.colorBackground, null);
        color_rectangle = ResourcesCompat.getColor(getResources(), R.color.colorRectangle, null);
        color_accent = ResourcesCompat.getColor(getResources(), R.color.colorAccent, null);
    }


}
