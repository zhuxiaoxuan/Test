package com.zxx.mvpPractice.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.zxx.mvpPractice.app.App;

import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;


/**
 * Description: BaseActivity
 * Creator: yxc
 * date: 2016/9/7 11:45
 */
public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity {

    protected Unbinder unbinder;
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    protected void init() {
        setTranslucentStatus(true);
        App.getInstance().registerActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().unregisterActivity(this);
        if (unbinder != null)
            unbinder.unbind();
        mPresenter = null;
    }

    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }


    protected static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }
}
