package mvp.test.mvp.presenter.contract;

import mvp.test.mvp.base.BasePresenter;
import mvp.test.mvp.base.BaseView;
import mvp.test.mvp.bean.User;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface MainContract {
    interface View extends BaseView<Presenter> {
        boolean isActive();

        void showProgressDialog();

        void hideProgressDialog();

        void showText(User userbean);

        void showErrorMessage(String text);
    }


    interface Presenter extends BasePresenter {
        void searchUser(String loginName);
    }
}
