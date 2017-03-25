package com.example.rooh.morboi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by rooh1 on 22-Mar-17.
 */

public class RadarSpin extends View {
    private int BG_COLOR = Color.BLACK;
    private int UI_COLOR = Color.GREEN;
    private Paint GreenOutline = new Paint();
    private Paint pRadius = new Paint();
    private Canvas c = null;
    private int w,h,r;
    private double angle = -90;
    private int delay = 0;
    private boolean first = true;
    String[] Abc = new String[]{"A","B","C","D","E","F","G","H","I","J"};

    RectF rect = new RectF();

    public RadarSpin(Context context) {
        super(context);

        GreenOutline.setColor(UI_COLOR);
        GreenOutline.setStrokeWidth(2);
        GreenOutline.setStyle(Paint.Style.STROKE);
        GreenOutline.setAntiAlias(true);

        int[] colors = {Color.TRANSPARENT, UI_COLOR};
        float[] positions = {0, 0.25F};
        SweepGradient gradient = new SweepGradient(0, 0, colors , positions);
        pRadius.setShader(gradient);


        new MyTimer().start();

    }

    @Override
    protected void onDraw(Canvas canvas){


        c = canvas;
        c.drawColor(BG_COLOR); // Background

        // c.drawARGB(60,0,0,0);
        w = canvas.getWidth();
        h = canvas.getHeight();
        r = w/4;
        if(first){
            first = false;

            rect.set(-r, -r,r, r);
        }

        c.translate(w/4,h/2);    //Radar block start

        //c.drawRect(0,0,100,100,GreenOutline);
        drawCoordinates();
        drawCircleField();
        c.rotate((float) angle);
       // c2.rotate((float) -angle);

        drawR(w/4,h/2,w/4);

        c.translate(-w/4,-h/2); //Radar block end
        canvas.drawCircle(w/4,h/2,w/4,GreenOutline);
    }
    public void drawCoordinates() {
        int sub_r = r / 10;
        for(int i = 1; i <= 10; i++)
            c.drawCircle(0,0,i*sub_r,GreenOutline);
        for(int i = 0; i <= 360; i+= 36) {
            double a = Math.toRadians(i);
            c.drawLine(0, 0, (float) (r * Math.cos(a) - 0 * Math.sin(a)), (float) (0 * Math.cos(a) + r * Math.sin(a)), GreenOutline);
            if(i == 0 || i == 180){
                int row = 1;
                for(float j = 1.5F; j < 10.5; j++) {
                    c.drawText(Integer.toString(row), (float) (sub_r * j * Math.cos(a)), (float) (sub_r * j * Math.sin(a)), GreenOutline);
                    row++;
                }
            }
        }

    }
    public void drawCircleField() {

        int sub_r = r / 10;
        int line = 0;
        int row = 0;
        for(int i = 18; i < 378; i+= 36) {
            if(true)//angle check
            for(float j = 1.5F; j < 11.5; j++) {
                double a = Math.toRadians(i);
                if(j == 10.5)
                    c.drawText(Abc[line],(float)(sub_r * j * Math.cos(a)),(float) (sub_r * j * Math.sin(a)), GreenOutline);
                else
                    c.drawText("X", (float) (sub_r * j * Math.cos(a)), (float) (sub_r * j * Math.sin(a)), GreenOutline);
            row++;
            }
        line++;
        }

    }
    public void drawR(int cx, int cy, int r){

        //r -= 120;
        //double a = Math.toRadians(angle);
       // c.drawText(Double.toString(angle),0,0,new Paint());
       // c.drawText(Double.toString(r * Math.cos(a)) + "--" + Double.toString(r * Math.cos(a)),0,100,new Paint());

        /*if(angle >= 267 && angle < 270 ) {
            delay = 60;
            angle = -90;
            c.drawText("-----------------",600,600,new Paint());
        }*/
        angle+= 3;
        //c.save();

        //Example values
        c.drawArc(rect, 0, 90, true, pRadius);
        //c.drawLine(0,0, (float)(r * Math.cos(a) - 0 * Math.sin(a)),(float)(0 * Math.cos(a) + r * Math.sin(a)),GreenOutline);

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
