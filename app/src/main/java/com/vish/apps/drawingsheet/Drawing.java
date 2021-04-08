package com.vish.apps.drawingsheet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import android.graphics.Bitmap;


/**
 * Created by Vish on 12/3/2016.
 */

public class Drawing extends View {

    private Canvas mCanvas;
    public Paint mPaint, mCanvasPaint;
    private Path mPath;
    private Bitmap canvasBitmap;
    private float xPos;
    private float yPos;

    public Drawing(Context context, AttributeSet attributeSet){
        super(context, attributeSet);

        setUpDrawing();
    }



    public void setUpDrawing(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#FFC738"));
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(14);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mCanvasPaint = new Paint();
        mCanvasPaint.setAntiAlias(true);
        mCanvasPaint.setColor(Color.parseColor("#FFC738"));
        mCanvasPaint.setStrokeJoin(Paint.Join.ROUND);
        mCanvasPaint.setStyle(Paint.Style.FILL);
        mCanvasPaint.setStrokeWidth(14);
        mCanvasPaint.setStrokeCap(Paint.Cap.ROUND);

        mPath = new Path();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(canvasBitmap);
    }


    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(canvasBitmap, 0 , 0, mCanvasPaint);
        canvas.drawPath(mPath, mPaint);

    }


    public void touch_down(float x, float y){
        mPath.moveTo(x, y);

        xPos = x;
        yPos = y;
    }
    public void touch_move(float x, float y){
        mPath.lineTo(x, y);

        xPos = x;
        yPos = y;
    }
    public void touch_up(){
        mCanvas.drawCircle(xPos, yPos, 8, mCanvasPaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        xPos = motionEvent.getX();
        yPos = motionEvent.getY();

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                touch_down(xPos, yPos);
                return true;
            case MotionEvent.ACTION_MOVE:
                touch_move(xPos, yPos);
                break;
            case MotionEvent.ACTION_UP:
                touch_up();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }


    public void clear(){
    }

    public void undo(){
    }
}
