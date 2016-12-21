package com.zxx.mvpPractice.presenter;


import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.common.base.Preconditions;
import com.zxx.mvpPractice.base.RxPresenter;
import com.zxx.mvpPractice.model.bean.User;
import com.zxx.mvpPractice.model.net.RetrofitHelper;
import com.zxx.mvpPractice.model.net.VideoHttpResponse;
import com.zxx.mvpPractice.presenter.contract.MainContract;
import com.zxx.mvpPractice.utils.RxUtil;
import com.zxx.mvpPractice.utils.StringUtils;

import rx.Subscription;
import rx.functions.Action1;

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

        Subscription rxSubscription = RetrofitHelper.getGithubServiceApi().getUser(loginName)
                .compose(RxUtil.<VideoHttpResponse<User>>rxSchedulerHelper())
                .compose(RxUtil.<User>handleResult())
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        if (user != null) {
                            if (mView.isActive()) {
                                mView.hideProgressDialog();
                                mView.showText(user);
                            }
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d("zxx", "showErrorMessage:" + throwable.getMessage());
                        mView.showErrorMessage("搜索失败");
                    }
                });

        addSubscribe(rxSubscription);
    }
}
