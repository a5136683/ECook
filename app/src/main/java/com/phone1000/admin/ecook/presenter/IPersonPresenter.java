package com.phone1000.admin.ecook.presenter;

import com.phone1000.admin.ecook.bean.PersonDataInfo;
import com.phone1000.admin.ecook.bean.PersonTalkInfo;

/**
 * Created by admin on 2016/11/15.
 */

public interface IPersonPresenter {

    void getPersonData(PersonDataInfo personDataInfo);
    void getPersonTalkData(PersonTalkInfo personTalkInfo);
    void getUrl(String url);
    void getTalkUrl(String talkUrl);

}
