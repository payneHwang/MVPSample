package mvp.com.main.presenter;

import android.util.Log;

import mvp.com.main.model.dao.LoginModelIml;
import mvp.com.main.model.interfaces.OnLoginListener;
import mvp.com.main.view.interfaces.ILoginView;

/**
 * Created by huang_jin on 2017/10/12.
 */

public class LoginPresenter {
    private static final String TAG = "LoginPresenter";
    LoginModelIml model;
    ILoginView loginView;
    public LoginPresenter(ILoginView view){
        this.loginView = view;
        model = new LoginModelIml();
    }

    public void login(String name, String password, OnLoginListener loginListener){
        if (model!=null){
            Log.e(TAG,"start login...");
            model.validateCertification(name,password,loginListener);
        }
    }

}
