package com.phone1000.admin.ecook.view;

import com.phone1000.admin.ecook.bean.PersonDataInfo;
import com.phone1000.admin.ecook.bean.PersonTalkInfo;

/**
 * Created by admin on 2016/11/15.
 */

public interface IPerson {

    void getPersonData(PersonDataInfo personDataInfo);
    void getPersonTalkData(PersonTalkInfo personTalkInfo);
}
