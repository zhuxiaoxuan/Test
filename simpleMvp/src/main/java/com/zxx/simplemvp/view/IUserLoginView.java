package com.zxx.simplemvp.view;

import com.zxx.simplemvp.bean.User;

/**
 * Created by Administrator on 2016/11/14.
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserPassword();

    void clearUserName();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFaileError();

    void sayHelloWord();
}
