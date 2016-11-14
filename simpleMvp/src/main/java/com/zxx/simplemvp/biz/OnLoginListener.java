package com.zxx.simplemvp.biz;

import com.zxx.simplemvp.bean.User;

/**
 * Created by Administrator on 2016/11/14.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
