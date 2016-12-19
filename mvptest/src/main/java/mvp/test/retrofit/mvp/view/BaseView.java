package mvp.test.retrofit.mvp.view;


import mvp.test.retrofit.bean.User;

/**
 * Created by xw on 2016/11/1.
 */
public interface BaseView {
    void showProgressDialog();
    void hideProgressDialog();
    void showText(User userbean);
    void showErrorMessage(String text);
}
