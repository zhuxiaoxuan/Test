package mvp.test.mvp.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.common.base.Preconditions;
import mvp.test.mvp.base.BasePresenter;
import mvp.test.mvp.bean.User;
import mvp.test.mvp.model.MainModel;
import mvp.test.mvp.base.BaseView;
import mvp.test.mvp.presenter.contract.MainContract;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public class MainPresenter implements MainContract.Presenter {
    MainContract.View mView;
    private BaseView mMainView;
    private MainModel mModel;

    public MainPresenter(@NonNull MainContract.View oneView) {
        mView = Preconditions.checkNotNull(oneView);
        mView.setPresenter(this);
//        mModel=new MainModel();
    }

    @Override
    public void searchUser(String loginName) {

    }


    @Override
    public void detachView() {

    }

//    @Override
//    public void attachView(BaseView view) {
//        mMainView=view;
//    }
//
//    @Override
//    public void attachView(Object view) {
//
//    }
//
//    @Override
//    public void detachView() {
//        mMainView=null;
//    }
//    @Override
//    public void searchUser(String loginName) {
//        if(TextUtils.isEmpty(loginName.trim())){
//            mMainView.showErrorMessage("请输入合法登录名");
//            return;
//        }
//        if (mModel!=null){
//            mModel.getUser(new Subscriber<User>() {
//                @Override
//                public void onStart() {  //先显示对话框
//                    mMainView.showProgressDialog();
//                }
//
//                @Override
//                public void onCompleted() {  //请求结束，对话框消失
//                    mMainView.hideProgressDialog();
//
//                }
//
//                @Override
//                public void onError(Throwable e) {   //error时
//                    mMainView.showErrorMessage("搜索失败");
//                }
//
//                @Override
//                public void onNext(User user) {
//                    mMainView.showText(user);
//                }
//            },loginName);
//        }
//
//    }
}
