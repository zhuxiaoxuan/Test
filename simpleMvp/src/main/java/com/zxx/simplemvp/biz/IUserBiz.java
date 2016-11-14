package com.zxx.simplemvp.biz;

/**
 * Created by Administrator on 2016/11/14.
 */
public interface IUserBiz {

    public void login(String username,String password,OnLoginListener loginListener);
}
