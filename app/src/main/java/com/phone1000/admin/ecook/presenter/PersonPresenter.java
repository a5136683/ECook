package com.phone1000.admin.ecook.presenter;

import com.phone1000.admin.ecook.bean.PersonDataInfo;
import com.phone1000.admin.ecook.bean.PersonTalkInfo;
import com.phone1000.admin.ecook.model.IPersonData;
import com.phone1000.admin.ecook.model.PersonData;
import com.phone1000.admin.ecook.view.IPerson;

/**
 * Created by admin on 2016/11/15.
 */

public class PersonPresenter implements IPersonPresenter {

    private IPerson iPerson = null;
    private IPersonData iPersonData = new PersonData(this);//传递presenter对象到model层，获得model对象

    public PersonPresenter(IPerson iPerson) {
        this.iPerson = iPerson; //获取到view层对象
    }

    @Override
    public void getPersonData(PersonDataInfo personDataInfo) {
        iPerson.getPersonData(personDataInfo);
    }

    @Override
    public void getPersonTalkData(PersonTalkInfo personTalkInfo) {
        iPerson.getPersonTalkData(personTalkInfo);
    }

    @Override
    public void getUrl(String url) {
        iPersonData.getUrl(url);
    }

    @Override
    public void getTalkUrl(String talkUrl) {
        iPersonData.getTalkUrl(talkUrl);
    }
}
