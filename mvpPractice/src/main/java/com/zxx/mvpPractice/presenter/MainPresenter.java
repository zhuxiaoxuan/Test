package com.zxx.mvpPractice.presenter;


import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.common.base.Preconditions;
import com.zxx.mvpPractice.base.RxPresenter;
import com.zxx.mvpPractice.model.bean.User;
import com.zxx.mvpPractice.model.net.RetrofitHelper;
import com.zxx.mvpPractice.presenter.contract.MainContract;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/17.
 */
public class MainPresenter extends RxPresenter implements MainContract.Presenter {
    MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View oneView) {
        mView = Preconditions.checkNotNull(oneView);
        mView.setPresenter(this);
    }


    @Override
    public void searchUser(String loginName) {

        if (TextUtils.isEmpty(loginName.trim())) {
            mView.showErrorMessage("请输入合法登录名");
            return;
        }

        RetrofitHelper.getGithubServiceApi().getUser(loginName)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onStart() {  //先显示对话框
                        mView.showProgressDialog();
                    }

                    @Override
                    public void onCompleted() {  //请求结束，对话框消失
                        mView.hideProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {   //error时
                        Log.d("zxx", "showErrorMessage:" + e.getMessage());
                        mView.showErrorMessage("搜索失败");
                    }

                    @Override
                    public void onNext(User user) {
                        mView.showText(user);
                    }
                });
    }
}
