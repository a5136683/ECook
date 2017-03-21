package com.phone1000.admin.ecook.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.adapter.TimeAdapter;
import com.phone1000.admin.ecook.bean.TimeDataInfo;
import com.phone1000.admin.ecook.presenter.ITimePresenter;
import com.phone1000.admin.ecook.presenter.TimePresenter;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;


public class TimeActivity extends AppCompatActivity implements ITimeView{

    @ViewInject(R.id.time_lv)private ListView time_lv;
    private ITimePresenter iTimePresenter = new TimePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        x.view().inject(this);
        iTimePresenter.getUrl("http://api.ecook.cn/public/getActList.shtml");
    }

    @Override
    public void getData(List<TimeDataInfo.DataBean.ListBean> list) {
        time_lv.setAdapter(new TimeAdapter(this,list));
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.time_back:
                finish();
                break;
        }
    }
}
