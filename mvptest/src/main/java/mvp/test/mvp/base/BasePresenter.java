package mvp.test.mvp.base;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public interface BasePresenter<T> {
    void attachView(T view);
    void detachView();

}
