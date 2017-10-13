package mvp.com.main.model.interfaces;

import mvp.com.main.model.bean.User;

/**
 * Created by huang_jin on 2017/10/12.
 */

public interface OnLoginListener {
    void success(User user,int code,String msg);
    void failure(int code,String msg);
    void nameError(int code,String msg);
    void passwordError(int code,String msg);
    void cancel();
    void networkError();
}
