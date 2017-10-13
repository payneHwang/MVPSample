package mvp.com.main.view.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import mvp.com.R;
import mvp.com.main.model.bean.User;
import mvp.com.main.model.interfaces.OnLoginListener;
import mvp.com.main.presenter.LoginPresenter;
import mvp.com.main.view.interfaces.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private static final String TAG = "LoginActivity";
    /**
     * ui
     */
    private EditText et_name, et_pass;
    private Button btn_confirm;
    private ProgressBar progress;
    LoginPresenter presenter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
        setListener();

    }

    OnLoginListener loginListener = new OnLoginListener() {
        @Override
        public void success(User user, int code, String msg) {
            //动态设置Button右侧的状态
            Drawable drawable = mContext.getResources().getDrawable(R.mipmap.ic_success);
            //设置图片显示的位置(setBounds())
            drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
            btn_confirm.setCompoundDrawables(null,null,mContext.getResources().getDrawable(R.mipmap.ic_success),null);
            Log.e(TAG,"success..."+"name---"+user.getName()+"---password:"+user.getPassword());
            dismissProgress();
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void failure(int code, String msg) {
            Log.e(TAG,"failure...");
            dismissProgress();
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void nameError(int code, String msg) {
            Log.e(TAG,"nameError...");
            showNameErrorInfo(msg);
            dismissProgress();
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void passwordError(int code, String msg) {
            Log.e(TAG,"passwordError...");
            showPassErrorInfo(msg);
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void cancel() {
            dismissProgress();

            Toast.makeText(mContext, "登錄取消", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void networkError() {
            dismissProgress();
        }
    };


    private void setListener() {
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString().trim();
                String password = et_pass.getText().toString().trim();
                showProgress();
                Log.e(TAG,"start login...");
                presenter.login(name, password, loginListener);
            }
        });
    }

    private void initView() {
        et_name = ((EditText) findViewById(R.id.et_name));
        et_pass = ((EditText) findViewById(R.id.et_password));
        btn_confirm = (Button) findViewById(R.id.btn_login);
        progress = (ProgressBar) findViewById(R.id.progress);
    }

    private void init() {
        mContext = this;
        presenter = new LoginPresenter(this);
    }


    @Override
    public void showProgress() {
        if (progress != null) {
            progress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void dismissProgress() {
        if (progress != null) {
            progress.setVisibility(View.GONE);
        }

    }

    @Override
    public void showNameErrorInfo(String errorNameInfo) {
        et_name.setError(errorNameInfo);
    }

    @Override
    public void showPassErrorInfo(String errorPasswordInfo) {
        et_pass.setError(errorPasswordInfo);
    }

    @Override
    public void intentToMain() {

    }
}
