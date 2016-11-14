package com.zxx.simplemvp.biz;

import com.zxx.simplemvp.bean.User;

/**
 * Created by Administrator on 2016/11/14.
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("zxx".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
