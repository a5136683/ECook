package com.phone1000.admin.ecook.fragment.MyFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.activity.Main1Activity;
import com.phone1000.admin.ecook.activity.Main2Activity;
import com.phone1000.admin.ecook.activity.Main3Activity;
import com.phone1000.admin.ecook.activity.Main4Activity;
import com.phone1000.admin.ecook.activity.Main5Activity;
import com.phone1000.admin.ecook.activity.Main6Activity;
import com.phone1000.admin.ecook.activity.Main7Activity;
import com.phone1000.admin.ecook.activity.Main8Activity;
import com.phone1000.admin.ecook.activity.SheZhiActivity;
import com.phone1000.admin.ecook.app.MyApplication;
import com.phone1000.admin.ecook.utils.LoginUtils;

/**
 * Created by admin on 2016/11/8.
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private View v = null;
    private Intent intent = null;
    private ImageView mine_login_image,back;
    private LinearLayout btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.mine_fragment_layout, container, false);
        initView();
        setListener();
        return v;
    }

    private void setListener() {
        mine_login_image.setOnClickListener(this);
        back.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    private void initView() {
        mine_login_image = (ImageView) v.findViewById(R.id.mine_login_image);
        back = (ImageView) v.findViewById(R.id.back);
        btn1 = (LinearLayout) v.findViewById(R.id.btn1ChuBi);
        btn2 = (LinearLayout) v.findViewById(R.id.btn2AiHao);
        btn3 = (LinearLayout) v.findViewById(R.id.btn3ShouChang);
        btn4 = (LinearLayout) v.findViewById(R.id.btn4CaiLanZi);
        btn5 = (LinearLayout) v.findViewById(R.id.btn5Dingdan);
        btn6 = (LinearLayout) v.findViewById(R.id.btn6WoDe);
        btn7 = (LinearLayout) v.findViewById(R.id.btn7HaoYou);
        btn8 = (LinearLayout) v.findViewById(R.id.btn8FanKui);

    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()) {
            case R.id.mine_login_image:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                }
                break;
            case R.id.back:
                intent.setClass(getContext(), SheZhiActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1ChuBi:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                } else {
                    intent.setClass(getContext(), Main1Activity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn2AiHao:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                } else {
                    intent.setClass(getContext(), Main2Activity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn3ShouChang:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                } else {
                    intent.setClass(getContext(), Main3Activity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn4CaiLanZi:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                } else {
                    intent.setClass(getContext(), Main4Activity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn5Dingdan:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                } else {
                    intent.setClass(getContext(), Main5Activity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn6WoDe:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                } else {
                    intent.setClass(getContext(), Main6Activity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn7HaoYou:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                } else {
                    intent.setClass(getContext(), Main7Activity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn8FanKui:
                if (!MyApplication.isLogin()) {
                    LoginUtils.login(getActivity());
                } else {
                    intent.setClass(getContext(), Main8Activity.class);
                    startActivity(intent);
                }
        }
    }

}
