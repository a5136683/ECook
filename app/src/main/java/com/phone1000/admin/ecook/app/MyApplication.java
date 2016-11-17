package com.phone1000.admin.ecook.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.callback.InitResultCallback;

import org.xutils.x;

/**
 * Created by admin on 2016/11/9.
 */

public class MyApplication extends Application {
    private static SharedPreferences sp = null;
    public static boolean isLogin;

    public static boolean isLogin() {
        return isLogin;
    }
    public static void setIsLogin(boolean isLogin) {
        MyApplication.isLogin = isLogin;
        sp.edit().putBoolean("login",isLogin);//将登陆状态存入sharePreferences中 用来保存登陆状态
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sp = getSharedPreferences("login", MODE_PRIVATE);
        isLogin = sp.getBoolean("login", false);
        AlibabaSDK.asyncInit(this, new InitResultCallback(){

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(MyApplication.this, "异常"+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess() {
//                Toast.makeText(MyApplication.this, "初始化成功", Toast.LENGTH_SHORT).show();
            }
        });

        x.Ext.init(this);//初始化
    }


}
