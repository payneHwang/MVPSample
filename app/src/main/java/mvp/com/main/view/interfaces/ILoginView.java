package mvp.com.main.view.interfaces;

/**
 * Created by huang_jin on 2017/10/12.
 */

public interface ILoginView {
    //progress
    void showProgress();
    void dismissProgress();
    //show toast
    void showNameErrorInfo(String errorNameInfo);
    void showPassErrorInfo(String errorPasswordInfo);
    //intent to main
    void intentToMain();

}
