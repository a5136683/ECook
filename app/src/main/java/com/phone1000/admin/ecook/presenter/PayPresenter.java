package com.phone1000.admin.ecook.presenter;

import android.app.Activity;

import com.phone1000.admin.ecook.model.PayDemo;
import com.phone1000.admin.ecook.pay.PayResult;
import com.phone1000.admin.ecook.view.PayInter;

/**
 * Created by admin on 2016/11/30.
 */

public class PayPresenter {
private Activity mActivity;
    private PayInter payInter;
    private PayDemo payDemo = null;

    public PayPresenter(PayInter payInter, Activity mActivity) {
        this.payInter = payInter;
        this.mActivity = mActivity;
        payDemo = new PayDemo(this,mActivity);
    }

    public void getPay(PayResult result){
        payInter.getPay(result);
    }
    public void UsePay(){
        payDemo.pay();
    }


}
