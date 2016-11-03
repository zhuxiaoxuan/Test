package mvp.test.retrofit;

import mvp.test.bean.User;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public interface GithubService {
    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String username);
}