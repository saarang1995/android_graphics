package com.developer.saarang.coregraphics.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class CustomGLSurfaceView extends GLSurfaceView {
    private final CustomGLRenderer customGLRenderer;

    public CustomGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        customGLRenderer = new CustomGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(customGLRenderer);
    }
}
