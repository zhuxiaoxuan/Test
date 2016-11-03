package app.myapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private BaseViewGroup mBaseViewGroup;
    private Button take_photo;

    private ArrayList<String> mBeautyList = new ArrayList<String>();
    private ArrayList<Integer> mMagicList = new ArrayList<Integer>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBaseViewGroup = (BaseViewGroup) findViewById(R.id.root_layout);
        take_photo = (Button) findViewById(R.id.take_photo);
        mBeautyList.add("典雅");
        mBeautyList.add("RISE");
        mBeautyList.add("甜美");
        mBeautyList.add("浪漫");
        mBeautyList.add("Lomo");


        mMagicList.add(R.mipmap.aiqing_icon);
        mMagicList.add(R.mipmap.haizei_icon);
        mMagicList.add(R.mipmap.huoyin_icon);
        mMagicList.add(R.mipmap.mengtu_icon);
        mMagicList.add(R.mipmap.nenya_icon);
//        mMagicList.add(R.mipmap.shengri_icon);
//        mMagicList.add(R.mipmap.yanjing_icon);
//        mMagicList.add(R.mipmap.yaogun_icon);


        for (int i = 0; i < mBaseViewGroup.getChildCount(); i++) {
            mBaseViewGroup.getChildAt(i).setFocusable(true);
            mBaseViewGroup.getChildAt(i).setFocusableInTouchMode(true);
        }


//        mBaseViewGroup.setMagicData(mMagicList);
//        mBaseViewGroup.setMode(BaseViewGroup.MAGIC_MODE);

        mBaseViewGroup.setBeautyData(mBeautyList);
        mBaseViewGroup.setMode(BaseViewGroup.BEAUTY_MODE);

    }

}
