package com.zxx.mvpPractice.presenter;

import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;
import com.zxx.mvpPractice.base.RxPresenter;
import com.zxx.mvpPractice.presenter.contract.WelComeContract;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/22 0022.
 */

public class WelComePresenter extends RxPresenter implements WelComeContract.Presenter{
    WelComeContract.View mView;
    private static final int COUNT_DOWN_TIME = 2200;

    public WelComePresenter(@NonNull WelComeContract.View oneView) {
        mView = Preconditions.checkNotNull(oneView);
        mView.setPresenter(this);
        getWelcomeData();
    }

    @Override
    public void getWelcomeData() {
        mView.showContent(getImgData());
        startCountDown();
    }

    private void startCountDown() {
//        Subscription rxSubscription = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
//                .compose(RxUtil.<Long>rxSchedulerHelper())
//                .subscribe(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
//                        mView.jumpToMain();
//                    }
//                });
//        addSubscribe(rxSubscription);

        Subscription rxSubscription=Observable.timer(COUNT_DOWN_TIME,TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        mView.jumpToMain();
                    }
                });
    }

    private List<String> getImgData() {
        List<String> imgs = new ArrayList<>();
        imgs.add("file:///android_asset/a.jpg");
        imgs.add("file:///android_asset/b.jpg");
        imgs.add("file:///android_asset/c.jpg");
//        imgs.add("file:///android_asset/d.jpg");
        imgs.add("file:///android_asset/e.jpg");

        imgs.add("file:///android_asset/f.jpg");
        imgs.add("file:///android_asset/g.jpg");
        return imgs;
    }
}
