package com.phone1000.admin.ecook.model;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.bean.TimeDataInfo;
import com.phone1000.admin.ecook.presenter.ITimePresenter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/28.
 */

public class TimeData implements ITimeData {

    private ITimePresenter iTimePresenter;

    public TimeData(ITimePresenter iTimePresenter) {
        this.iTimePresenter = iTimePresenter;
    }

    @Override
    public void getUrl(String url) {
        RequestParams entity = new RequestParams(url);
        x.http().post(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                TimeDataInfo timeDataInfo = gson.fromJson(result, TimeDataInfo.class);
                List<TimeDataInfo.DataBean.ListBean> list = timeDataInfo.getData().getList();
                iTimePresenter.getData(list);
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
