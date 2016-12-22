package com.zxx.mvpPractice.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.zxx.mvpPractice.R;
import com.zxx.mvpPractice.base.BaseActivity;
import com.zxx.mvpPractice.presenter.MainPresenter;
import com.zxx.mvpPractice.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_view)
    MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        Log.d("zxx", "mainView:" + mainView);
        mPresenter = new MainPresenter(mainView);
    }
}
