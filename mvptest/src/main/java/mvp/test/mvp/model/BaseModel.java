package mvp.test.mvp.model;

import mvp.test.mvp.bean.User;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public interface BaseModel {
    void getUser(Subscriber<User> subscribe, String loginName);
}
