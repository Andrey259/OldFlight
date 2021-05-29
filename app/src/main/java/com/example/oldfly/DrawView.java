package com.example.oldfly;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import androidx.core.app.ActivityCompat;

import java.io.IOException;


public class DrawView extends SurfaceView implements SurfaceHolder.Callback {
    private static DrawThread drawThread;

    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }


@Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawThread = new DrawThread(getContext(),getHolder());
        drawThread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        DrawThread.setFlying(10);
        return false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // изменение размеров SurfaceView
    }

@Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        drawThread.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                transition.setPlane(1);
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
                //
            }
        }
    Intent i = new Intent(getContext(), MainActivity.class);
    getContext().startActivity(i);
    transition.mus_for_game.stop();
    }

}

