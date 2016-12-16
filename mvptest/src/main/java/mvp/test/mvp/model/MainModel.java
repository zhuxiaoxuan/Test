package mvp.test.mvp.model;

import mvp.test.mvp.bean.User;
import mvp.test.retrofit.HttpMethods;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public class MainModel implements BaseModel{
    @Override
    public void getUser(Subscriber<User> subscriber , String loginName) {
        HttpMethods.getInstance().getUser(subscriber,loginName);
    }
}
