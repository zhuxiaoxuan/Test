package mvp.test.mvp.view;

import android.content.Context;
import android.util.AttributeSet;

import mvp.test.R;
import mvp.test.mvp.base.RootView;
import mvp.test.mvp.bean.User;
import mvp.test.mvp.presenter.contract.MainContract;

/**
 * Created by Administrator on 2016/12/11.
 */
public class MainView extends RootView<MainContract.Presenter> implements MainContract.View {

    public MainView(Context context) {
        super(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_main_view, this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showText(User userbean) {

    }

    @Override
    public void showErrorMessage(String text) {

    }
}
