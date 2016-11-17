package com.phone1000.admin.ecook.fragment.MyFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.activity.PictureActivity;
import com.phone1000.admin.ecook.adapter.HeadAdapter;
import com.phone1000.admin.ecook.adapter.PlazaAdapter;
import com.phone1000.admin.ecook.bean.Talk;
import com.phone1000.admin.ecook.bean.TalkViewPagerDataInfo;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/11/8.
 */

public class TalkFragmentPlaza extends Fragment {

    private View v = null;
    private ListView talk_plaza_listView = null;
    private List<String> noList = null;
    private List<Talk.ListBean> list = new ArrayList();
    ;
    private PlazaAdapter adapter = null;
    private HeadAdapter headAdapter = null;
    private View footView = null;
    private View headView = null;
    private String index = "0";
    private ViewPager list_head_view = null;
    private boolean flag = false;
    private SwipeRefreshLayout swipe = null;
    private Intent intent = new Intent();
    private String firstUrl = "http://api.ecook.cn/public/getHotTalkList.shtml?machine=88b83009675252eea014a8216bcfa7be&lastTalkid";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    headAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.talk_plaza_fragment, container, false);
        x.view().inject(getActivity());
        initView();
        talk_plaza_listView.addHeaderView(headView);
        adapter = new PlazaAdapter(list, getActivity());//
        talk_plaza_listView.setAdapter(adapter);//setAdapter不可以放在setData中，否则每次都是新的adapter，数据加载时会回到顶部
        talk_plaza_listView.addFooterView(footView);
        setHeadData();
        setData();
        swipe.setColorSchemeColors(Color.BLUE,Color.YELLOW,Color.BLACK);
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(true);
            }
        });//初始时  对数据的刷新
        setListener();
        return v;
    }

    private void setListener() {

        talk_plaza_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.setClass(getContext(), PictureActivity.class);
                String[] split = list.get(i - 1).getImageids().split("\\,");
                if (split.length != 0) {
                    intent.putExtra("image", split);
                } else {
                    intent.putExtra("image", list.get(i - 1).getImageids());
                }
                startActivity(intent);
            }
        });

        talk_plaza_listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (flag && i == SCROLL_STATE_IDLE) {
                    flag = false;
                    setData();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (i + i1 == i2) {
                    flag = true;
                }
            }
        });
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                setData();
            }
        });
    }

    private void setHeadData() {
        noList = new ArrayList<String>();
        headAdapter = new HeadAdapter(noList, getActivity());
        list_head_view.setAdapter(headAdapter);
        new Thread() {
            @Override
            public void run() {
                super.run();
                String url = "http://api.ecook.cn/public/getTalkSquareAds.shtml";
                RequestParams entity = new RequestParams(url);
                Log.d("test", entity.getUri());
                x.http().get(entity, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        TalkViewPagerDataInfo talkViewPagerDataInfo = gson.fromJson(result, TalkViewPagerDataInfo.class);
                        List<TalkViewPagerDataInfo.DataBean.SquareListBean> squareList = talkViewPagerDataInfo.getData().getSquareList();

                        for (int i = 0; i < squareList.size(); i++) {
                            String url = squareList.get(i).getImage();
                            noList.add("http://pic.ecook.cn/web/" + url + ".jpg");//或许图片的字段进行拼接
                        }
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
    }

    private void setData() {
        String talkUrl = "http://api.ecook.cn/public/getHotTalkList.shtml";
        RequestParams requestParams = new RequestParams(talkUrl);
        requestParams.addBodyParameter("machine", "88b83009675252eea014a8216bcfa7be");
        requestParams.addBodyParameter("lastTalkid", index);
        Log.d("test", requestParams + "");
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Talk talk = gson.fromJson(result, Talk.class);//获取到json串4
                swipe.setRefreshing(false);
                list.addAll(talk.getList());
                adapter.notifyDataSetChanged();
                index = list.get((list.size() - 1)).getId();
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

    private void initView() {
        swipe = (SwipeRefreshLayout) v.findViewById(R.id.swipe);
        talk_plaza_listView = (ListView) v.findViewById(R.id.talk_plaza_listView);
        footView = RelativeLayout.inflate(getActivity(), R.layout.list_foot, null);//添加listView尾部
        headView = RelativeLayout.inflate(getActivity(), R.layout.list_head_six, null);//添加listView头部
        list_head_view = (ViewPager) headView.findViewById(R.id.list_head_viewPager);
    }
}
