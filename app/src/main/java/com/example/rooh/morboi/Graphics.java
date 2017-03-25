package com.example.rooh.morboi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by rooh1 on 22-Mar-17.
 */

public class Graphics extends View {
    private Paint GreenOutline = new Paint();
    private Canvas c = null;
    private int w,h;
    private double angle = -90;
    private int delay = 0;

    public Graphics(Context context) {
        super(context);

        GreenOutline.setColor(Color.GREEN);
        GreenOutline.setStrokeWidth(2);
        GreenOutline.setStyle(Paint.Style.STROKE);
        GreenOutline.setAntiAlias(true);
        new MyTimer().start();

    }

    @Override
    protected void onDraw(Canvas canvas){

        c = canvas;
        //canvas.drawColor(Color.YELLOW); // Background
        // c.drawARGB(60,0,0,0);
        w = c.getWidth();
        h = c.getHeight();

        canvas.drawCircle(w/4,h/2,w/4,GreenOutline);
        if(delay <= 0)
            drawR(w/4,h/2,w/4);
    }
    public void drawR(int cx, int cy, int r){

        //r -= 120;
        double a = Math.toRadians(angle);

        c.drawText(Double.toString(angle),500,500,new Paint());
        c.drawText(Double.toString(r * Math.cos(a)) + "--" + Double.toString(r * Math.cos(a)),600,600,new Paint());

        if(angle >= 267 && angle < 270 ) {
            delay = 60;
            angle = -90;
            c.drawText("-----------------",600,600,new Paint());
        }
        angle+= 3;
        c.save();
        c.translate(cx,cy);
        c.drawLine(0,0, (float)(r * Math.cos(a) - 0 * Math.sin(a)),(float)(0 * Math.cos(a) + r * Math.sin(a)),GreenOutline);
        c.restore();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        angle = -90;
        return false;
    }
    class MyTimer extends CountDownTimer {

        public MyTimer() {
            super(Integer.MAX_VALUE, 1000/60);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            invalidate();
            delay--;
        }

        @Override
        public void onFinish() {

        }
    }
    private class Radius{
        double degAngle;
        int cx,cy,y;
        int opacity = 255;
        Radius(double degAngle){
            this.degAngle = degAngle;
        }
    }
}
