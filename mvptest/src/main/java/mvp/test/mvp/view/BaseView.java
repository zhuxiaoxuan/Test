package mvp.test.mvp.view;

import mvp.test.bean.User;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public interface BaseView {
    void showProgressDialog();
    void hideProgressDialog();
    void showText(User userbean);
    void showErrorMessage(String text);
}
