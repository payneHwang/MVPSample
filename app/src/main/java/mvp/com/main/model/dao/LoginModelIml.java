package mvp.com.main.model.dao;

import android.text.TextUtils;
import android.util.Log;

import mvp.com.main.model.bean.User;
import mvp.com.main.model.interfaces.OnLoginListener;

/**
 * Created by huang_jin on 2017/10/12.
 */

public class LoginModelIml implements ILoginModel {
    private static final String TAG = "LoginModelIml";
    private static final int LOGIN_FAILURE = 0;
    private static final int LOGIN_SUCCESS = 1;
    private static final int LOGIN_CANCEL = 2;
    @Override
    public void validateCertification(String name, String password, OnLoginListener loginListener) {
        Log.e(TAG,"start validateCertification...");
        if (TextUtils.isEmpty(name)){
            loginListener.nameError(LOGIN_FAILURE,"用戶名不能為空");
            return;
        }if (TextUtils.isEmpty(password)){
            loginListener.passwordError(LOGIN_FAILURE,"密码不能为空");
            return;
        }if (loginListener==null){
            loginListener.failure(LOGIN_FAILURE,"登录回调不能为空");
            return;
        }if (name.equals("admin")&&password.equals("admin")){
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            loginListener.success(user,LOGIN_SUCCESS,"登录成功");
            return;
        }
        else {
            loginListener.failure(LOGIN_FAILURE,"登录失败");
        }
    }
}
