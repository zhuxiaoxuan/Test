package com.zxx.mvpPractice.model.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Description: RetrofitHelper
 * Creator: yxc
 * date: 2016/9/21 10:03
 */
public class RetrofitHelper {

    private static GithubServiceApi githubServiceApi;
    private static Retrofit retrofit;
    private static final int DEFAULT_TIMEOUT = 5;

    public static GithubServiceApi getGithubServiceApi() {
        if (githubServiceApi == null) {
            init();
        }
        return githubServiceApi;
    }

    public static void init() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //支持Gson实体类的返回
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(GithubServiceApi.BASE_URL)
                .build();

        githubServiceApi = retrofit.create(GithubServiceApi.class);
    }

}
