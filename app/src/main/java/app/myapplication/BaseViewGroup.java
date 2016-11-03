package app.myapplication;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zxx on 2016/8/18 0018.
 */
public class BaseViewGroup extends ViewGroup {

    private static final String TAG = "BaseViewGroup";

    private ObjectAnimator leftKeyAnim;
    private ObjectAnimator rightKeyAnim;
    private boolean isLeftKeyAnimFinish = true;
    private boolean isRightKeyAnimFinish = true;
    private static float rotationValues = 45f;
    private ObjectAnimator leftItemKeyAnim_0;
    private ObjectAnimator rightItemKeyAnim_0;
    private ObjectAnimator leftItemKeyAnim_1;
    private ObjectAnimator rightItemKeyAnim_1;
    private ObjectAnimator leftItemKeyAnim_2;
    private ObjectAnimator rightItemKeyAnim_2;
    private ObjectAnimator leftItemKeyAnim_3;
    private ObjectAnimator rightItemKeyAnim_3;
    private ObjectAnimator leftItemKeyAnim_4;
    private ObjectAnimator rightItemKeyAnim_4;
    private ObjectAnimator leftItemKeyAnim_5;
    private ObjectAnimator rightItemKeyAnim_5;
    private ObjectAnimator leftItemKeyAnim_6;
    private ObjectAnimator rightItemKeyAnim_6;
    private ObjectAnimator leftItemKeyAnim_7;
    private ObjectAnimator rightItemKeyAnim_7;
    private ArrayList<ObjectAnimator> leftItemAnimList = new ArrayList<ObjectAnimator>();
    private ArrayList<ObjectAnimator> rightItemAnimList = new ArrayList<ObjectAnimator>();

    private float leftStartValues;
    private float leftEndValues;
    private float rightStartValues;
    private float rightEndValues;
    private float leftItemStartValues;
    private float leftItemEndValues;
    private float rightItemStartValues;
    private float rightItemEndValues;


    private static final int RADIUS = 200;//半径

    private static int CIRCLE_X = 0;
    private static int CIRCLE_Y = 0;

    private ArrayList<String> mBeautyList = new ArrayList<String>();
    private ArrayList<Integer> mMagicList = new ArrayList<Integer>();
    private int DATA_LIST_SIZE = 0;

    public static final int BEAUTY_MODE = 0;
    public static final int MAGIC_MODE = 1;
    private int CUR_MODE;
    private boolean isNeedInit = true;

    public BaseViewGroup(Context context, AttributeSet attrs) {

        super(context, attrs);
        init();

    }

    /**
     * 设置当前的模式
     *
     * @param mode
     */
    public void setMode(int mode) {
        this.CUR_MODE = mode;
        if (CUR_MODE == BEAUTY_MODE) {
            for (int i = 0; i < this.getChildCount(); i++) {
                ((FrameLayout) this.getChildAt(i)).getChildAt(0).setVisibility(View.GONE);
                ((FrameLayout) this.getChildAt(i)).getChildAt(1).setVisibility(View.VISIBLE);
            }
        }

        if (CUR_MODE == MAGIC_MODE) {
            for (int i = 0; i < this.getChildCount(); i++) {
                ((FrameLayout) this.getChildAt(i)).getChildAt(0).setVisibility(View.VISIBLE);
                ((FrameLayout) this.getChildAt(i)).getChildAt(1).setVisibility(View.GONE);
            }
        }
    }


    public void init() {
        Log.i(TAG, "init: CIRCLE_X:" + CIRCLE_X + ",CIRCLE_Y:" + CIRCLE_Y);
        TopAtIndex = 0;
        leftAtViewIndex = 3;
        rightAtViewIndex = 5;
//        Log.i(TAG, "CIRCLE_X:" + CIRCLE_X + "CIRCLE_Y:" + CIRCLE_Y);
    }


    public void setMagicData(ArrayList<Integer> list) {
        this.mMagicList = list;
        this.DATA_LIST_SIZE = mMagicList.size();
        notifyMagicDataChange();
    }

    private void notifyMagicDataChange() {

        for (int i = 0; i < DATA_LIST_SIZE; i++) {
            if (i < 3) {
                ((ImageButton) ((FrameLayout) this.getChildAt(i)).getChildAt(0)).setImageResource(mMagicList.get(i));
            }

            if (i == DATA_LIST_SIZE - 1) {
                ((ImageButton) ((FrameLayout) this.getChildAt(this.getChildCount() - 1)).getChildAt(0)).setImageResource(mMagicList.get(DATA_LIST_SIZE - 1));
            }
            if (i == DATA_LIST_SIZE - 2) {
                ((ImageButton) ((FrameLayout) this.getChildAt(this.getChildCount() - 2)).getChildAt(0)).setImageResource(mMagicList.get(DATA_LIST_SIZE - 2));
            }
        }
    }

    public void setBeautyData(ArrayList<String> list) {
        this.mBeautyList = list;
        this.DATA_LIST_SIZE = mBeautyList.size();
        notifyBeautyDataChange();
    }

    private void notifyBeautyDataChange() {
        for (int i = 0; i < DATA_LIST_SIZE; i++) {
            if (i < 3) {
                ((TextView) ((FrameLayout) this.getChildAt(i)).getChildAt(1)).setText(mBeautyList.get(i));
            }

            if (i == DATA_LIST_SIZE - 1) {
                ((TextView) ((FrameLayout) this.getChildAt(this.getChildCount() - 1)).getChildAt(1)).setText(mBeautyList.get(DATA_LIST_SIZE - 1));
            }
            if (i == DATA_LIST_SIZE - 2) {
                ((TextView) ((FrameLayout) this.getChildAt(this.getChildCount() - 2)).getChildAt(1)).setText(mBeautyList.get(DATA_LIST_SIZE - 2));
            }
        }
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void initAnim() {
        leftStartValues = 0f;
        leftEndValues = -45f;
        leftItemStartValues = 0f;
        leftItemEndValues = 45f;

        rightStartValues = 0f;
        rightEndValues = 45f;
        rightItemStartValues = 0f;
        rightItemEndValues = -45f;

        leftKeyAnim = ObjectAnimator.ofFloat(this, "rotation", leftStartValues, leftEndValues);
        rightKeyAnim = ObjectAnimator.ofFloat(this, "rotation", rightStartValues, rightEndValues);

        leftItemKeyAnim_0 = ObjectAnimator.ofFloat(this.getChildAt(0), "rotation", leftItemStartValues, leftItemEndValues);
        rightItemKeyAnim_0 = ObjectAnimator.ofFloat(this.getChildAt(0), "rotation", rightItemStartValues, rightItemEndValues);

        leftItemKeyAnim_1 = ObjectAnimator.ofFloat(this.getChildAt(1), "rotation", leftItemStartValues, leftItemEndValues);
        rightItemKeyAnim_1 = ObjectAnimator.ofFloat(this.getChildAt(1), "rotation", rightItemStartValues, rightItemEndValues);

        leftItemKeyAnim_2 = ObjectAnimator.ofFloat(this.getChildAt(2), "rotation", leftItemStartValues, leftItemEndValues);
        rightItemKeyAnim_2 = ObjectAnimator.ofFloat(this.getChildAt(2), "rotation", rightItemStartValues, rightItemEndValues);

        leftItemKeyAnim_3 = ObjectAnimator.ofFloat(this.getChildAt(3), "rotation", leftItemStartValues, leftItemEndValues);
        rightItemKeyAnim_3 = ObjectAnimator.ofFloat(this.getChildAt(3), "rotation", rightItemStartValues, rightItemEndValues);

        leftItemKeyAnim_4 = ObjectAnimator.ofFloat(this.getChildAt(4), "rotation", leftItemStartValues, leftItemEndValues);
        rightItemKeyAnim_4 = ObjectAnimator.ofFloat(this.getChildAt(4), "rotation", rightItemStartValues, rightItemEndValues);

        leftItemKeyAnim_5 = ObjectAnimator.ofFloat(this.getChildAt(5), "rotation", leftItemStartValues, leftItemEndValues);
        rightItemKeyAnim_5 = ObjectAnimator.ofFloat(this.getChildAt(5), "rotation", rightItemStartValues, rightItemEndValues);

        leftItemKeyAnim_6 = ObjectAnimator.ofFloat(this.getChildAt(6), "rotation", leftItemStartValues, leftItemEndValues);
        rightItemKeyAnim_6 = ObjectAnimator.ofFloat(this.getChildAt(6), "rotation", rightItemStartValues, rightItemEndValues);

        leftItemKeyAnim_7 = ObjectAnimator.ofFloat(this.getChildAt(7), "rotation", leftItemStartValues, leftItemEndValues);
        rightItemKeyAnim_7 = ObjectAnimator.ofFloat(this.getChildAt(7), "rotation", rightItemStartValues, rightItemEndValues);


        leftItemAnimList.add(leftItemKeyAnim_0);
        leftItemAnimList.add(leftItemKeyAnim_1);
        leftItemAnimList.add(leftItemKeyAnim_2);
        leftItemAnimList.add(leftItemKeyAnim_3);
        leftItemAnimList.add(leftItemKeyAnim_4);
        leftItemAnimList.add(leftItemKeyAnim_5);
        leftItemAnimList.add(leftItemKeyAnim_6);
        leftItemAnimList.add(leftItemKeyAnim_7);

        rightItemAnimList.add(rightItemKeyAnim_0);
        rightItemAnimList.add(rightItemKeyAnim_1);
        rightItemAnimList.add(rightItemKeyAnim_2);
        rightItemAnimList.add(rightItemKeyAnim_3);
        rightItemAnimList.add(rightItemKeyAnim_4);
        rightItemAnimList.add(rightItemKeyAnim_5);
        rightItemAnimList.add(rightItemKeyAnim_6);
        rightItemAnimList.add(rightItemKeyAnim_7);

        for (int i = 0; i < leftItemAnimList.size(); i++) {
            leftItemAnimList.get(i).setDuration(500);
            rightItemAnimList.get(i).setDuration(500);
        }
        rightKeyAnim.setDuration(500);
        leftKeyAnim.setDuration(500);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setListener() {
        rightKeyAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                leftStartValues = rightEndValues;
                leftEndValues = rightStartValues;
                leftItemStartValues = rightItemEndValues;
                leftItemEndValues = rightItemStartValues;
                initleftItemAnimValue();
                leftKeyAnim.setFloatValues(leftStartValues, leftEndValues);

                rightStartValues = rightStartValues + rotationValues;
                rightEndValues = rightEndValues + rotationValues;
                rightItemStartValues = rightItemStartValues - rotationValues;
                rightItemEndValues = rightItemEndValues - rotationValues;


                isRightKeyAnimFinish = true;
                rightKeyAnim.setFloatValues(rightStartValues, rightEndValues);

                initrightItemAnimValue();
//                Log.i(TAG, "rightKeyAnim : onAnimationEnd rightStartValues:" + rightStartValues + ",rightEndValues:" + rightEndValues);


            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        leftKeyAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
//                Button preItem = (Button) BaseViewGroup.this.getChildAt(TopAtIndex - 1);
//                Button curItem = (Button) BaseViewGroup.this.getChildAt(TopAtIndex);
//                if (preItem != null && !preItem.getText().equals("")) {
//                    preItem.setTextColor(Color.parseColor("#FFFFFF"));
//                }
//                if (curItem != null && !curItem.getText().equals("")) {
//                    curItem.setTextColor(Color.parseColor("#00b7ee"));
//                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                rightStartValues = leftEndValues;
                rightEndValues = leftStartValues;
                rightItemStartValues = leftItemEndValues;
                rightItemEndValues = leftItemStartValues;
                initrightItemAnimValue();
                rightKeyAnim.setFloatValues(rightStartValues, rightEndValues);

                leftStartValues = leftStartValues - rotationValues;
                leftEndValues = leftEndValues - rotationValues;
                leftItemStartValues = leftItemStartValues + rotationValues;
                leftItemEndValues = leftItemEndValues + rotationValues;


                isLeftKeyAnimFinish = true;
                leftKeyAnim.setFloatValues(leftStartValues, leftEndValues);

                initleftItemAnimValue();

//                Log.i(TAG, "rightKeyAnim : onAnimationEnd leftStartValues:" + leftStartValues + ",leftEndValues:" + leftEndValues);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
//        Log.i(TAG, "setListener: getChildCount:" + this.getChildCount());
        for (int i = 0; i < this.getChildCount() - 1; i++) {
            this.getChildAt(i).setOnFocusChangeListener(new MyItemOnFocusListener());
        }
    }

    private class MyItemOnFocusListener implements OnFocusChangeListener {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
//            if (hasFocus) {
//                ((Button) v).setTextColor(Color.parseColor("#00b7ee"));
//            }
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void initleftItemAnimValue() {
        for (int i = 0; i < leftItemAnimList.size(); i++) {
            leftItemAnimList.get(i).setFloatValues(leftItemStartValues, leftItemEndValues);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void initrightItemAnimValue() {
        for (int i = 0; i < rightItemAnimList.size(); i++) {
            rightItemAnimList.get(i).setFloatValues(rightItemStartValues, rightItemEndValues);
        }
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    /**
     * 计算所有ChildView的宽度和高度 然后根据ChildView的计算结果，设置自己的宽和高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Log.i(TAG, "onMeasure: widthMeasureSpec:" + widthMeasureSpec + ",heightMeasureSpec:" + heightMeasureSpec);
        /**
         * 获得此ViewGroup上级容器为其推荐的宽和高，以及计算模式
         */
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);


        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        /**
         * 记录如果是wrap_content是设置的宽和高
         */
        int width = 0;
        int height = 0;

        int cCount = getChildCount();

        int cWidth = 0;
        int cHeight = 0;
        MarginLayoutParams cParams = null;

        // 用于计算左边两个childView的高度
        int lHeight = 0;
        // 用于计算右边两个childView的高度，最终高度取二者之间大值
        int rHeight = 0;

        // 用于计算上边两个childView的宽度
        int tWidth = 0;
        // 用于计算下面两个childiew的宽度，最终宽度取二者之间大值
        int bWidth = 0;

        /**
         * 根据childView计算的出的宽和高，以及设置的margin计算容器的宽和高，主要用于容器是warp_content时
         */
        Log.i(TAG, "onMeasure: cCount:" + cCount);
        for (int i = 0; i < cCount; i++) {
            View childView = getChildAt(i);
            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParams = (MarginLayoutParams) childView.getLayoutParams();

            if (i == 0 || i == 4) {
                height += RADIUS + cHeight / 2;
            }
            if (i == 2 || i == 6) {
                width += RADIUS + cWidth / 2;
            }
        }


        Log.i(TAG, "onMeasure: width:" + width + ",height:" + height);

        /**
         * 如果是wrap_content设置为我们计算的值
         * 否则：直接设置为父容器计算的值
         */
        setMeasuredDimension((widthMode == MeasureSpec.EXACTLY) ? sizeWidth
                : width, (heightMode == MeasureSpec.EXACTLY) ? sizeHeight
                : height);
        CIRCLE_X = getWidth() / 2;
        CIRCLE_Y = getHeight() / 2;
//        Log.i(TAG, "onMeasure: sizeWidth:" + sizeWidth + ",width:" + width + ",sizeHeight:" + sizeHeight + ",height:" + height);


    }


    // abstract method in viewgroup
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        Log.i(TAG, "onLayout: changed:" + changed + ",left :" + l + "top:" + t + ",right:" + r + ",bottom:" + b);
        int cCount = getChildCount();
        int cWidth = 0;
        int cHeight = 0;
        MarginLayoutParams cParams = null;
        /**
         * 遍历所有childView根据其宽和高，以及margin进行布局
         */
        for (int i = 0; i < cCount; i++) {
            View childView = getChildAt(i);
            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParams = (MarginLayoutParams) childView.getLayoutParams();

//            Log.i(TAG, "onLayout: cWidth" + cWidth + ",cHeight:" + cHeight +
//                    ",leftMargin:" + cParams.leftMargin + ",topMargin:" + cParams.topMargin +
//                    ",rightMargin:" + cParams.rightMargin + ",bottomMargin:" + cParams.bottomMargin +
//                    ",getWidth:" + getWidth() + ",getHeight:" + getHeight());


            int cl = 0, ct = 0, cr = 0, cb = 0;

            switch (i) {
                case 0:
                    cl = CIRCLE_X - (int) (Math.cos(Math.PI / 2) * RADIUS)
                            - cParams.rightMargin - cWidth / 2;
                    ct = CIRCLE_Y - (int) (Math.sin(Math.PI / 2) * RADIUS) - cParams.topMargin - cHeight / 2;
                    break;
                case 1:
                    cl = CIRCLE_X - (int) (-Math.cos(Math.PI / 4) * RADIUS)
                            - cParams.rightMargin - cWidth / 2;
                    ct = CIRCLE_Y - (int) (Math.sin(Math.PI / 4) * RADIUS) - cParams.topMargin - cHeight / 2;
                    break;
                case 2:
                    cl = CIRCLE_X + RADIUS - cParams.leftMargin - cWidth / 2;
                    ct = CIRCLE_Y - cParams.topMargin - cHeight / 2;
                    break;
                case 3:
                    cl = CIRCLE_X - (int) (-Math.cos(Math.PI / 4) * RADIUS)
                            - cParams.rightMargin - cWidth / 2;
                    ct = CIRCLE_Y - (int) (-Math.sin(Math.PI / 4) * RADIUS) - cParams.topMargin - cHeight / 2;
                    break;
                case 4:
                    cl = CIRCLE_X - (int) (Math.cos(Math.PI / 2) * RADIUS)
                            - cParams.rightMargin - cWidth / 2;
                    ct = CIRCLE_Y - (int) (-Math.sin(Math.PI / 2) * RADIUS) - cParams.topMargin - cHeight / 2;
                    break;
                case 5:
                    cl = CIRCLE_X - (int) (Math.cos(Math.PI / 4) * RADIUS)
                            - cParams.rightMargin - cWidth / 2;
                    ct = CIRCLE_Y - (int) (-Math.sin(Math.PI / 4) * RADIUS) - cParams.topMargin - cHeight / 2;
                    break;
                case 6:
                    cl = CIRCLE_X - RADIUS - cParams.leftMargin - cWidth / 2;
                    ct = CIRCLE_Y - cParams.topMargin - cHeight / 2;
                    break;
                case 7:
                    cl = CIRCLE_X - (int) (Math.cos(Math.PI / 4) * RADIUS)
                            - cParams.rightMargin - cWidth / 2;
                    ct = CIRCLE_Y - (int) (Math.sin(Math.PI / 4) * RADIUS) - cParams.topMargin - cHeight / 2;
                    break;
            }
            cr = cl + cWidth;
            cb = cHeight + ct;
            childView.layout(cl, ct, cr, cb);
//            Log.i(TAG, "onLayout: left" + cl + ",top:" + ct + ",right:" + cr + ",bottom:" + cb);
        }

        if (isNeedInit) {
            initAnim();
            setListener();
            isNeedInit = false;
        }
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
//        Log.i(TAG, "dispatchKeyEvent: BaseViewGroup");

        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT && event.getAction() == KeyEvent.ACTION_DOWN) {
//            Log.i(TAG, "KEYCODE_DPAD_LEFT isLeftKeyAnimFinish:" + isLeftKeyAnimFinish + ",leftKeyAnim:" + leftKeyAnim);
            if (isLeftKeyAnimFinish && isRightKeyAnimFinish) {
                keyLeftDataAdapter();
                keyCodeLeft();
                return true;
            }
        }

        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT && event.getAction() == KeyEvent.ACTION_DOWN) {
//            Log.i(TAG, "KEYCODE_DPAD_RIGHT isRightKeyAnimFinish:" + isRightKeyAnimFinish + ",rightKeyAnim:" + rightKeyAnim);
            if (isRightKeyAnimFinish && isLeftKeyAnimFinish) {
                keyRightDataAdapter();
                keyCodeRight();
                return true;
            }
        }


        return super.dispatchKeyEvent(event);
    }

    private static int TopAtIndex;
    private int leftAtViewIndex;
    private int rightAtViewIndex;
    private FrameLayout AtButtonItem;

    private void keyLeftDataAdapter() {
        Log.i(TAG, "keyLeftDataAdapter: TopAtIndex:" + TopAtIndex);
        TopAtIndex = TopAtIndex + 1;

        TopAtIndex = TopAtIndex > DATA_LIST_SIZE - 1 ? 0 : TopAtIndex;

        Log.i(TAG, "keyLeftDataAdapter: TopAtIndex:" + TopAtIndex);
        Log.i(TAG, "keyLeftDataAdapter: leftAtViewIndex:" + leftAtViewIndex);
        Log.i(TAG, "keyLeftDataAdapter: getChildCount" + this.getChildCount());
        Log.i(TAG, "keyLeftDataAdapter: DATA_LIST_SIZE:" + DATA_LIST_SIZE);
        AtButtonItem = ((FrameLayout) this.getChildAt(leftAtViewIndex));


        if (CUR_MODE == MAGIC_MODE) {
//            ((ImageButton) AtButtonItem.getChildAt(0)).setImageResource(mMagicList.get((TopAtIndex + 2) % DATA_LIST_SIZE));
        }

        if (CUR_MODE == BEAUTY_MODE) {
            ((TextView) AtButtonItem.getChildAt(1)).setText("");
            ((TextView) AtButtonItem.getChildAt(1)).setText(mBeautyList.get((TopAtIndex + 2) % DATA_LIST_SIZE));
        }

        leftAtViewIndex = leftAtViewIndex + 1;
        rightAtViewIndex = rightAtViewIndex + 1;
        rightAtViewIndex = rightAtViewIndex > this.getChildCount() - 1 ? 0 : rightAtViewIndex;
        leftAtViewIndex = leftAtViewIndex > this.getChildCount() - 1 ? 0 : leftAtViewIndex;
    }

    private void keyRightDataAdapter() {
        Log.i(TAG, "keyRightDataAdapter: TopAtIndex:" + TopAtIndex);
        TopAtIndex = TopAtIndex - 1;

        TopAtIndex = TopAtIndex < 0 ? DATA_LIST_SIZE - 1 : TopAtIndex;

        Log.i(TAG, "keyRightDataAdapter: TopAtIndex:" + TopAtIndex);
        Log.i(TAG, "keyRightDataAdapter: rightAtViewIndex:" + rightAtViewIndex);
        Log.i(TAG, "keyRightDataAdapter: getChildCount" + this.getChildCount());
        Log.i(TAG, "keyRightDataAdapter: DATA_LIST_SIZE:" + DATA_LIST_SIZE);
        AtButtonItem = ((FrameLayout) this.getChildAt(rightAtViewIndex));


        if (CUR_MODE == MAGIC_MODE) {
            ((ImageButton) AtButtonItem.getChildAt(0)).setImageResource(mMagicList.get((TopAtIndex + (DATA_LIST_SIZE - 2)) % DATA_LIST_SIZE));
        }

        if (CUR_MODE == BEAUTY_MODE) {
            ((TextView) AtButtonItem.getChildAt(1)).setText("");
            ((TextView) AtButtonItem.getChildAt(1)).setText(mBeautyList.get((TopAtIndex + (DATA_LIST_SIZE - 2)) % DATA_LIST_SIZE));
        }

        rightAtViewIndex = rightAtViewIndex - 1;
        leftAtViewIndex = leftAtViewIndex - 1;
        leftAtViewIndex = leftAtViewIndex < 0 ? this.getChildCount() - 1 : leftAtViewIndex;
        rightAtViewIndex = rightAtViewIndex < 0 ? this.getChildCount() - 1 : rightAtViewIndex;

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void keyCodeRight() {
        Log.i(TAG, "keyCodeRight: isRightKeyAnimFinish:" + isRightKeyAnimFinish + ",isLeftKeyAnimFinish:" + isLeftKeyAnimFinish
                + ",rightKeyAnim:" + rightKeyAnim);

        if (rightKeyAnim != null) {
            isRightKeyAnimFinish = false;
            rightKeyAnim.start();
            for (int i = 0; i < rightItemAnimList.size(); i++) {
                rightItemAnimList.get(i).start();
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void keyCodeLeft() {
//        Log.i(TAG, "keyCodeLeft: isLeftKeyAnimFinish:" + isLeftKeyAnimFinish + ",isRightKeyAnimFinish:" + isRightKeyAnimFinish +
//                ",leftKeyAnim:" + leftKeyAnim);
        if (leftKeyAnim != null) {
            isLeftKeyAnimFinish = false;
            leftKeyAnim.start();
            for (int i = 0; i < leftItemAnimList.size(); i++) {
                leftItemAnimList.get(i).start();
            }
        }
    }
}
