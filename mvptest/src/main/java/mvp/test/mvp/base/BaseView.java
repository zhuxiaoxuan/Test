package mvp.test.mvp.base;

import mvp.test.mvp.bean.User;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public interface BaseView<T> {
    void setPresenter(T presenter);

    void showError(String msg);
}
