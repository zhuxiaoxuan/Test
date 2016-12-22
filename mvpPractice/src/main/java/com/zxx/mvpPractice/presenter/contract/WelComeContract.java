package com.zxx.mvpPractice.presenter.contract;

import com.zxx.mvpPractice.base.BasePresenter;
import com.zxx.mvpPractice.base.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/22 0022.
 */

public interface WelComeContract {

    interface View extends BaseView<Presenter> {
        boolean isActive();

        void showContent(List<String> list);

        void jumpToMain();
    }


    interface Presenter extends BasePresenter {
        void getWelcomeData();
    }
}
