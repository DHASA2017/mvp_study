package com.dl.mvpapplication.view;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN){
            View v = getCurrentFocus();
            if(isShouldHide(ev,v)){
                hideSoftInput(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private void hideSoftInput(IBinder windowToken) {
        if(windowToken!=null){
            InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(windowToken,InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private boolean isShouldHide(MotionEvent ev, View v) {
        if(v!=null&&v instanceof EditText){
            int[] loaction = {0,0};
            v.getLocationInWindow(loaction);
            int left = loaction[0],top = loaction[1],right=loaction[0]+v.getWidth(),bottom=loaction[1]+v.getHeight();
            if(ev.getX()>left&&ev.getX()<right&&ev.getY()>top&&ev.getY()<bottom){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
}
