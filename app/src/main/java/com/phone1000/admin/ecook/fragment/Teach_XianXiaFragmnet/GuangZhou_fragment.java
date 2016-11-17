package com.phone1000.admin.ecook.fragment.Teach_XianXiaFragmnet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.activity.XianXiaActivity;
import com.phone1000.admin.ecook.bean.TeachFragmentBean.TeachHangZhouDataInfo;
import com.phone1000.admin.ecook.adapter.TeachHangZhouAdapterr;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class GuangZhou_fragment extends Fragment {
    private View v;
    private ListView lvGuangZHou=null;
    private TeachHangZhouAdapterr adapter=null;
    private List<TeachHangZhouDataInfo.ListBean> list=new ArrayList<>();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    adapter.notifyDataSetChanged();
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.teach3_xianxai5_fragment,null);
        initView();
        setData();
        return v;
    }
    private void setData() {

        adapter=new TeachHangZhouAdapterr(list,getActivity());
        lvGuangZHou.setAdapter(adapter);

        new Thread(){
            @Override
            public void run() {
                super.run();
                String uri="http://api.ecook.cn/public/getTeachByCityid.shtml?machine=d0eab938324d212a6d577de6751d9685&version=12.9.0&device=dazen+X7&cityid=4";
                RequestParams entiry=new RequestParams(uri);
                x.http().get(entiry, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson=new Gson();
                        TeachHangZhouDataInfo teachHangZhouDataInfo = gson.fromJson(result, TeachHangZhouDataInfo.class);
                        list.addAll(teachHangZhouDataInfo.getList());
                        handler.sendEmptyMessage(1);

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
        }.start();
        lvGuangZHou.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),XianXiaActivity.class);
                intent.putExtra("url",list.get(position).getUrl());
                startActivity(intent);
            }
        });
    }


    private void initView() {
        lvGuangZHou= (ListView) v.findViewById(R.id.lvGuangZhou);

    }
}
