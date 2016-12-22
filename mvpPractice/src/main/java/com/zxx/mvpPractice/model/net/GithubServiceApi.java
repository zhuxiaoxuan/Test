package com.zxx.mvpPractice.model.net;

import com.zxx.mvpPractice.model.bean.User;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xw on 2016/11/1.
 */
public interface GithubServiceApi {

    public static final String BASE_URL = "https://api.github.com";

    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String username);
}
