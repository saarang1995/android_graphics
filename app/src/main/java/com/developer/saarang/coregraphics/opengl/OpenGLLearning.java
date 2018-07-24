package com.developer.saarang.coregraphics.opengl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OpenGLLearning extends AppCompatActivity {
    private CustomGLSurfaceView customGLSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customGLSurfaceView = new CustomGLSurfaceView(this);
        setContentView(customGLSurfaceView);
    }
}
