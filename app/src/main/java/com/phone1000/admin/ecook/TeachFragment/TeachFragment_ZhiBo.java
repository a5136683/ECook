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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.TeachFragmentBean.TeachZhiBODataInfo;
import com.phone1000.admin.ecook.activity.ZhiBoActivity;
import com.phone1000.admin.ecook.adapter.ZhiBoAdapter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class TeachFragment_ZhiBo extends Fragment {
    private View v;
    private ListView lvZhiBo;
    private ZhiBoAdapter adapter;
    private boolean flag = false;
    private String uri= null;
    private int index = 0;
    private List<TeachZhiBODataInfo.ListBean> list=new ArrayList<>();
    private Handler handler=new Handler(){
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
        v=inflater.inflate(R.layout.teach2_fragment_layout,null);

        initView();
        adapter=new ZhiBoAdapter(list,getActivity());
        setData();
        setListener();
        return v;
    }

    private void setListener() {
        lvZhiBo.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if(flag){
                    flag = false;
                    setData();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if(i + i1 == i2){
                    flag =true;
                }
            }
        });
    }

    private void setData() {

//        adapter.notifyDataSetChanged();
       lvZhiBo.setAdapter(adapter);
        new Thread(){
            @Override
            public void run() {
                super.run();
                uri = "http://api.ecook.cn/public/getOnlineTeachList.shtml?machine=d0eab938324d212a6d577de6751d9685&version=12.9.0&device=dazen+X7&page="+index+"&type=live";
                RequestParams entity=new RequestParams(uri);
                x.http().post(entity, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Log.d("test","******"+result);
                        Gson gson=new Gson();
                        TeachZhiBODataInfo teachZhiBODataInfo = gson.fromJson(result, TeachZhiBODataInfo.class);
                        list.addAll(teachZhiBODataInfo.getList());
                        handler.sendEmptyMessage(1);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.d("test","***请求失败***"+ex);
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {
                        index++;
                    }
                });
            }
        }.start();
        lvZhiBo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),ZhiBoActivity.class);
                intent.putExtra("Vedio",list.get(position).getVedio().toString());
                if (list.get(position).getVedio()!=null){
//                    startActivity(intent);
                }else {
                    Toast.makeText(getActivity(),"亲！访问数据出现错误！请稍候再试哦！",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initView() {
        lvZhiBo= (ListView) v.findViewById(R.id.lvZhiBo);
    }
}
