package com.zxx.mvpPractice.ui;

import android.os.Bundle;

import com.zxx.mvpPractice.R;
import com.zxx.mvpPractice.base.BaseActivity;
import com.zxx.mvpPractice.presenter.WelComePresenter;
import com.zxx.mvpPractice.view.WelcomeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/22 0022.
 */

public class WelcomeActivity extends BaseActivity{

    @BindView(R.id.welcome_view)
    WelcomeView welcomeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        unbinder = ButterKnife.bind(this);
        mPresenter = new WelComePresenter(welcomeView);
    }
}
