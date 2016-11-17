package com.phone1000.admin.ecook.model;

import android.util.Log;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.bean.PersonDataInfo;
import com.phone1000.admin.ecook.bean.PersonTalkInfo;
import com.phone1000.admin.ecook.presenter.IPersonPresenter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by admin on 2016/11/15.
 */

public class PersonData implements IPersonData {

    private IPersonPresenter iPersonPresenter = null;

    public PersonData(IPersonPresenter iPersonPresenter) {
        this.iPersonPresenter = iPersonPresenter;//获取到presenter对象
    }

    @Override
    public void getUrl(String url) {
        RequestParams entity = new RequestParams(url);
        x.http().post(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                PersonDataInfo personDataInfo = gson.fromJson(result, PersonDataInfo.class);
                Log.d("test","success");
                iPersonPresenter.getPersonData(personDataInfo);//p层获取数据
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("test","error:"+ex);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void getTalkUrl(String url) {
        RequestParams entity = new RequestParams(url);
        x.http().post(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                PersonTalkInfo personTalkInfo = gson.fromJson(result, PersonTalkInfo.class);
                iPersonPresenter.getPersonTalkData(personTalkInfo);//p层获取数据
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
