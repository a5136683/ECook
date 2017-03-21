package com.phone1000.admin.ecook.presenter;

import com.phone1000.admin.ecook.bean.TimeDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/28.
 */

public interface ITimePresenter {

    void getUrl(String url);
    void getData(List<TimeDataInfo.DataBean.ListBean> list);

}
