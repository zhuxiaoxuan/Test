package com.zxx.mvpPractice.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.google.common.base.Preconditions;
import com.zxx.mvpPractice.R;
import com.zxx.mvpPractice.base.RootView;
import com.zxx.mvpPractice.component.ImageLoader;
import com.zxx.mvpPractice.presenter.contract.WelComeContract;
import com.zxx.mvpPractice.ui.WelcomeActivity;
import com.zxx.mvpPractice.utils.JumpUtil;
import com.zxx.mvpPractice.utils.StringUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/22 0022.
 */

public class WelcomeView extends RootView<WelComeContract.Presenter> implements WelComeContract.View {


    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;

    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showContent(List<String> list) {
        if (list != null) {
            int page = StringUtils.getRandomNumber(0, list.size() - 1);
            ImageLoader.load(mContext, list.get(page), ivWelcomeBg);
            ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        }
    }

    @Override
    public void jumpToMain() {
        JumpUtil.go2MainActivity(mContext);
        ((WelcomeActivity) mContext).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void setPresenter(WelComeContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        Log.d("zxx", "showError:" + msg);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_welcome_view, this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }
}
