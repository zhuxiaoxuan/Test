package app.retrofit.utils;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class RetrofitManager {

    public static void get() {
        //这里的baseUrl加上之前@POST("mobileLogin/submit.html")定义的参数形成完整的请求地址；
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://106.3.227.33/pulamsi/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        RequestSerives requestSerives = retrofit.create(RequestSerives.class);//这里采用的是Java的动态代理模式
        Call<String> call = requestSerives.getString("userName", "1234");//传入我们请求的键值对的值


        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("===", "return:" + response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("===", "失败");
            }
        });

    }
}
