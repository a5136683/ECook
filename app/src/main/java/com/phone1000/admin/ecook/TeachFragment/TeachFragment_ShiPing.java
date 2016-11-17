package com.phone1000.admin.ecook.TeachFragment;

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
import android.widget.Toast;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.activity.ShiPingActivity;
import com.phone1000.admin.ecook.adapter.ShiPingAdapter;
import com.phone1000.admin.ecook.TeachFragmentBean.TeachShiPingDataInfo;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class TeachFragment_ShiPing extends Fragment {
    private View v;
    private ListView lvShiPing;
    private ShiPingAdapter adapter;
    private List<TeachShiPingDataInfo.ListBean> list = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    adapter.notifyDataSetChanged();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.teach1_fragment_layout, null);
        initView();
        setData();

        return v;
    }

    private void setData() {

        adapter = new ShiPingAdapter(list, getActivity());
        lvShiPing.setAdapter(adapter);
        new Thread() {
            @Override
            public void run() {
                super.run();
                int page = 0;
                String uri = "http://api.ecook.cn/public/getOnlineTeachList.shtml";
                RequestParams entity = new RequestParams(uri);
                entity.addBodyParameter("machine", "d0eab938324d212a6d577de6751d9685");
                entity.addBodyParameter("page", page + "");
                entity.addBodyParameter("type", "video");
                x.http().post(entity, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.d("test", "****" + result);
                        Gson gson = new Gson();
                        TeachShiPingDataInfo teachShiPingDataInfo = gson.fromJson(result, TeachShiPingDataInfo.class);
                        //填充数据
                        list.addAll(teachShiPingDataInfo.getList());
                        handler.sendEmptyMessage(1);
                        Log.d("test", "****" + result);

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.d("test", "****" + ex);
                        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
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
        lvShiPing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ShiPingActivity.class);
                intent.putExtra("video", list.get(position).getVedio().split("\\,")[0]);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        lvShiPing = (ListView) v.findViewById(R.id.lvShiPing);
    }


}
