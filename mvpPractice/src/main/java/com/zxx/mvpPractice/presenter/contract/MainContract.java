package com.zxx.mvpPractice.presenter.contract;

import com.zxx.mvpPractice.base.BasePresenter;
import com.zxx.mvpPractice.base.BaseView;
import com.zxx.mvpPractice.model.bean.User;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/12/17.
 */
public interface MainContract {


    interface View extends BaseView<Presenter> {

        void showProgressDialog();

        void hideProgressDialog();

        void showText(User userbean);

        void showErrorMessage(String text);
    }

    interface Presenter extends BasePresenter {
        void searchUser(String loginName);
    }
}
