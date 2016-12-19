package mvp.test.retrofit.mvp.model;

import mvp.test.retrofit.bean.User;
import mvp.test.retrofit.retrofit.HttpMethods;
import rx.Subscriber;

/**
 * Created by xw on 2016/11/1.
 */
public class MainModel implements BaseModel{
    @Override
    public void getUser(Subscriber<User> subscriber , String loginName) {
        HttpMethods.getInstance().getUser(subscriber,loginName);
    }
}
