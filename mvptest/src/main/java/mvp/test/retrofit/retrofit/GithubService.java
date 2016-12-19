package mvp.test.retrofit.retrofit;

import mvp.test.retrofit.bean.User;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xw on 2016/11/1.
 */
public interface GithubService {
    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String username);
}
