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
 * Created by Administrator on 2016/12/21 0021.
 */

public class RetrofitManager {


    public void getByRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RequestSerives requestSerives = retrofit.create(RequestSerives.class);//这里采用的是java动态代理模式
        Call<String> call = requestSerives.getString("userName", "1234");//传入我们请求键值对的值
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
