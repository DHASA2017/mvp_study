package com.dl.mvpapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.dl.mvpapplication.R;
import com.dl.mvpapplication.presenter.IPresenter;
import com.dl.mvpapplication.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ILoginView{

    @BindView(R.id.et_mobile_login)
    EditText et_mobile_login;
    @BindView(R.id.et_pwd_login)
    EditText et_pwd_login;
    @BindView(R.id.btn_login_on)
    Button btn_login_on;

    IPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }


    @OnClick(R.id.btn_login_on)
    public void onLogin() {
        loginPresenter.doLogin(et_mobile_login.getText().toString().trim(),et_pwd_login.getText().toString().trim());
    }

    @Override
    public void onLoginResult(JSONObject obj) {
        String rsCode = obj.getString("retcode");
        if("1".equals(rsCode)){
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        }
    }
}
