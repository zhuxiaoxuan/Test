package mvp.test.mvp.presenter;

import mvp.test.mvp.view.BaseView;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
    void searchUser(String loginName);
}
