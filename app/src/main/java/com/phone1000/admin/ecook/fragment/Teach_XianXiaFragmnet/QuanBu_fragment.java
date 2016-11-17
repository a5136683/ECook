package com.phone1000.admin.ecook.fragment.Teach_XianXiaFragmnet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.activity.XianXiaActivity;
import com.phone1000.admin.ecook.adapter.TeachAllAdapter;
import com.phone1000.admin.ecook.bean.TeachFragmentBean.TeachAllDataInfo;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class QuanBu_fragment extends Fragment  {
    private View v;
    private ListView lvQuanBu = null;
    private TeachAllAdapter adapter = null;
    private List<TeachAllDataInfo.ListBean> list = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.teach3_xianxai1_fragment,container,false);
        initView();
        setData();
        return v;
    }

    private void setData() {
        adapter = new TeachAllAdapter(list,getActivity());
        lvQuanBu.setAdapter(adapter);
        new Thread(){
            @Override
            public void run() {
                super.run();
//                String uri = "http://api.ecook.cn/public/getTeachByCityid.shtml?machine=d0eab938324d212a6d577de6751d9685&version=12.9.0&device=dazen+X7&cityid=all";
                String uri = "http://api.ecook.cn/public/getTeachByCityid.shtml";
                RequestParams entity = new RequestParams(uri);
                entity.addBodyParameter("machine","d0eab938324d212a6d577de6751d9685");
                entity.addBodyParameter("cityid","all");
                Log.d("test",entity.toString());
                x.http().get(entity, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Gson gson = new Gson();
                        TeachAllDataInfo teachAllDataInfo = gson.fromJson(result, TeachAllDataInfo.class);
                        list.addAll(teachAllDataInfo.getList());
                        Log.d("test","---------success-------"+teachAllDataInfo.getList().size());
                        handler.sendEmptyMessage(1);

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.d("te44444444444444st",""+ex);
                    }
                    @Override
                    public void onCancelled(CancelledException cex) {
                        Log.d("te55555555555st",""+cex);
                    }

                    @Override
                    public void onFinished() {
                        Log.d("test","---------onFinished-------");
                    }
                });
            }
        }.start();

        lvQuanBu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),XianXiaActivity.class);
                intent.putExtra("url",list.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    private void initView() {
        lvQuanBu = (ListView) v.findViewById(R.id.lvQuanBu);
    }


}
