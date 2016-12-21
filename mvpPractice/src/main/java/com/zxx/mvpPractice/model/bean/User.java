package com.zxx.mvpPractice.model.bean;

import com.zxx.mvpPractice.model.net.VideoHttpResponse;

/**
 * Created by xw on 2016/10/26.
 */
public class User{
    public String login;
    public String name;
    public int followers;
    public int following;

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
