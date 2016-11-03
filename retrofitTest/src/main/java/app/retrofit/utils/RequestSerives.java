package app.retrofit.utils;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public interface RequestSerives {

    //与Okhttp不同的是，Retrofit需要定义一个接口，用来返回我们的Call对象，这里示范的是Post请求：
    @POST("mobileLogin/submit.html")
    Call<String> getString(@Query("loginname") String loginname, @Query("nloginpwd") String nloginpwd);
}
