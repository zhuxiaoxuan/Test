package mvp.test.retrofit.okhttp;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/12/20 0020.
 */

public class OkHttpManager {

    public static OkHttpManager mOkHttpManager;

    public static OkHttpManager getInstance() {
        if (mOkHttpManager == null)
            mOkHttpManager = new OkHttpManager();
        return mOkHttpManager;
    }


    public static void getOk(String url) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("zxx", "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("zxx", "onResponse:"+response.toString());
            }
        });
    }

}
