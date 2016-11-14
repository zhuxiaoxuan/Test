package com.zxx.simplemvp.presenter;

import android.os.Handler;

import com.zxx.simplemvp.bean.User;
import com.zxx.simplemvp.biz.IUserBiz;
import com.zxx.simplemvp.biz.OnLoginListener;
import com.zxx.simplemvp.biz.UserBiz;
import com.zxx.simplemvp.view.IUserLoginView;


/**
 * Created by Administrator on 2016/11/14.
 */
public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;

    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();

        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFaileError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearUserPassword();
    }
}
