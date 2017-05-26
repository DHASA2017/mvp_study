package com.dl.mvpapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dl.mvpapplication.model.UserModel;
import com.dl.mvpapplication.view.ILoginView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dl on 2017/4/14.
 */
public class LoginPresenter implements IPresenter{

    ILoginView loginView;
    UserModel userModel;
    Handler handler;

    public LoginPresenter(ILoginView loginView){
        this.loginView = loginView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String name,String password) {
        OkHttpClient client = new OkHttpClient();
        JSONObject obj = new JSONObject();
        obj.put("mobilephone",name);
        obj.put("password",password);
        String param = obj.toJSONString();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),param);
        Request request = new Request.Builder().url("http://10.40.0.200:9797/mobile/userlogin").post(requestBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if(response.isSuccessful()){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                loginView.onLoginResult(JSON.parseObject(response.body().string()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else{

                }
            }
        });
    }
}
