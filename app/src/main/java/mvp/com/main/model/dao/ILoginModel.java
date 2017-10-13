package mvp.com.main.model.dao;

import mvp.com.main.model.interfaces.OnLoginListener;

/**
 * Created by huang_jin on 2017/10/12.
 */

public interface ILoginModel {
    void validateCertification(String name, String password, OnLoginListener loginListener);
}
