package com.example.customviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CircleView extends View {

    private Paint mPaint;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(getContext().getResources().getColor(R.color.colorAccent));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int hM=MeasureSpec.getMode(heightMeasureSpec);
        int hS=MeasureSpec.getSize(heightMeasureSpec);
        int wM=MeasureSpec.getMode(widthMeasureSpec);
        int wS=MeasureSpec.getSize(widthMeasureSpec);

        if (wM==MeasureSpec.AT_MOST&&hM==MeasureSpec.AT_MOST){
            setMeasuredDimension(200,200);
        }else if (wM==MeasureSpec.AT_MOST){
            setMeasuredDimension(200,hS);
        }else if (hM==MeasureSpec.AT_MOST){
            setMeasuredDimension(wS,200);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w=getWidth()-getPaddingLeft()-getPaddingRight();
        int h=getHeight()-getPaddingTop()-getPaddingBottom();
        int r=Math.min(w,h)/2;
        canvas.drawCircle(w/2+getPaddingRight(),h/2+getPaddingTop(),r,mPaint);
    }



    /**
     * 移动方式一
     */
    int currentX =0;
    int currentY =0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentX= (int) event.getX();
                currentY= (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int x2= (int) event.getX();
                int y2= (int) event.getY();
                scrollBy(currentX - x2, currentY - y2);
                currentY=y2;
                currentX=x2;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }


//    /**
//     * 移动方式二,不推荐
//     */
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_MOVE:
//                moveViewByLayout((int) event.getX(),(int) event.getX());
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return true;
//    }
//    private void moveViewByLayout( int rawX, int rawY) {
//        int left = rawX;
//        int top = rawY;
//        int width = left + getWidth();
//        int height = top + getHeight();
//        layout(left, top, width, height);
//    }
}
