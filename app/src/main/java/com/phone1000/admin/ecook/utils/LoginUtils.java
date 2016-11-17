package com.phone1000.admin.ecook.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.openaccount.OpenAccountService;
import com.alibaba.sdk.android.openaccount.callback.LoginCallback;
import com.alibaba.sdk.android.openaccount.callback.LogoutCallback;
import com.alibaba.sdk.android.openaccount.model.OpenAccountSession;
import com.alibaba.sdk.android.openaccount.ui.OpenAccountUIService;
import com.phone1000.admin.ecook.app.MyApplication;

/**
 * Created by admin on 2016/11/15.
 */

public class LoginUtils {

    private SharedPreferences sp = null;

    public static void login(final Activity activity){
        OpenAccountUIService openAccountUIService = AlibabaSDK.getService(OpenAccountUIService.class);
        openAccountUIService.showLogin(activity, new LoginCallback() {
            @Override
            public void onFailure(int i, String s) {
//                Toast.makeText(activity, "登录失败"+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(OpenAccountSession openAccountSession) {
                Toast.makeText(activity, "登录成功", Toast.LENGTH_SHORT).show();
                MyApplication.setIsLogin(true);
            }
        });
    }

    public static void register(final Activity activity){
        OpenAccountUIService openAccountUIService = AlibabaSDK.getService(OpenAccountUIService.class);
        openAccountUIService.showRegister(activity, new LoginCallback() {
            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(activity, "注册失败"+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(OpenAccountSession openAccountSession) {
                Toast.makeText(activity, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void reset(final Activity activity){
        OpenAccountUIService openAccountUIService = AlibabaSDK.getService(OpenAccountUIService.class);
        openAccountUIService.showResetPassword(activity, new LoginCallback() {
            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(activity, "重置失败"+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(OpenAccountSession openAccountSession) {
                Toast.makeText(activity, "重置成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void outLogin(final Activity activity){
        OpenAccountService openAccountService = AlibabaSDK.getService(OpenAccountService.class);
        openAccountService.logout(activity, new LogoutCallback() {
            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(activity, "退出失败"+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess() {
                Toast.makeText(activity, "退出成功", Toast.LENGTH_SHORT).show();
                MyApplication.setIsLogin(false);
            }
        });
    }

    public static void oneKeyLogin(final Activity activity){
        OpenAccountUIService openAccountUIService = AlibabaSDK.getService(OpenAccountUIService.class);
        openAccountUIService.showNoPasswordLogin(activity, new LoginCallback() {
            @Override
            public void onFailure(int i, String s) {
//                Toast.makeText(activity, "登录失败"+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(OpenAccountSession openAccountSession) {
                Toast.makeText(activity, "登陆成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
