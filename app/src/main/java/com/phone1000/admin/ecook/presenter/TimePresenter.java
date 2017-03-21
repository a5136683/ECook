package com.phone1000.admin.ecook.presenter;

import com.phone1000.admin.ecook.bean.TimeDataInfo;
import com.phone1000.admin.ecook.model.ITimeData;
import com.phone1000.admin.ecook.model.TimeData;
import com.phone1000.admin.ecook.view.ITimeView;

import java.util.List;

/**
 * Created by admin on 2016/11/28.
 */

public class TimePresenter implements ITimePresenter {

    private ITimeView iTimeView = null;
    private ITimeData iTimeData = new TimeData(this);

    public TimePresenter(ITimeView iTimeView) {
        this.iTimeView = iTimeView;
    }

    @Override
    public void getUrl(String url) {
        iTimeData.getUrl(url);
    }

    @Override
    public void getData(List<TimeDataInfo.DataBean.ListBean> list) {
        iTimeView.getData(list);
    }
}
