package mvp.test.retrofit.mvp.model;

import mvp.test.retrofit.bean.User;
import rx.Subscriber;

/**
 * Created by xw on 2016/11/1.
 */
public interface BaseModel {
    void getUser(Subscriber<User> subscribe, String loginName);
}
