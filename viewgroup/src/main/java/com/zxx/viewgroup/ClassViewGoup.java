package com.zxx.viewgroup;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/12/18.
 */
public class ClassViewGoup extends ViewGroup {

    private static String TAG = "ClassViewGoup";

    public ClassViewGoup(Context context) {
        super(context);
        Log.d(TAG,"ClassViewGoup(Context context)");
    }


    public ClassViewGoup(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG,"ClassViewGoup(Context context, AttributeSet attrs)");
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG,"onMeasure");
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        Log.d(TAG,"onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG,"onDraw");
    }
}
