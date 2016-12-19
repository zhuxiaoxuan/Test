package mvp.test.retrofit.mvp.presenter;

import android.text.TextUtils;

import mvp.test.retrofit.bean.User;
import mvp.test.retrofit.mvp.model.MainModel;
import mvp.test.retrofit.mvp.view.BaseView;
import rx.Subscriber;

/**
 * Created by xw on 2016/11/1.
 */
public class MainPresenter implements BasePresenter {
    private BaseView mMainView;
    private MainModel mModel;

    public MainPresenter() {
        mModel=new MainModel();
    }

    @Override
    public void attachView(BaseView view) {
        mMainView=view;
    }

    @Override
    public void detachView() {
        mMainView=null;
    }
    @Override
    public void searchUser(String loginName) {
        if(TextUtils.isEmpty(loginName.trim())){
            mMainView.showErrorMessage("请输入合法登录名");
            return;
        }
        if (mModel!=null){
            mModel.getUser(new Subscriber<User>() {
                @Override
                public void onStart() {  //先显示对话框
                    mMainView.showProgressDialog();
                }

                @Override
                public void onCompleted() {  //请求结束，对话框消失
                    mMainView.hideProgressDialog();

                }

                @Override
                public void onError(Throwable e) {   //error时
                    mMainView.showErrorMessage("搜索失败");
                }

                @Override
                public void onNext(User user) {
                    mMainView.showText(user);
                }
            },loginName);
        }

    }
}
