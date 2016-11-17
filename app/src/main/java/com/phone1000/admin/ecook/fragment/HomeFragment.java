package com.phone1000.admin.ecook.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.phone1000.admin.ecook.activity.FindActivity;
import com.phone1000.admin.ecook.activity.Main4Activity;
import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.activity.ShiPinCaiPuActivity;
import com.phone1000.admin.ecook.adapter.HomeHeadAdapter;
import com.phone1000.admin.ecook.adapter.HomeListAdapter;
import com.phone1000.admin.ecook.adapter.HomeRecyclerViewAdapter;
import com.phone1000.admin.ecook.app.MyApplication;
import com.phone1000.admin.ecook.bean.HomeDataInfo;
import com.phone1000.admin.ecook.bean.HomeListDataInfo;
import com.phone1000.admin.ecook.constract.HomeFirstPage;
import com.phone1000.admin.ecook.presenter.HomePresenter;
import com.phone1000.admin.ecook.presenter.IHomePresenter;
import com.phone1000.admin.ecook.utils.LoginUtils;
import com.phone1000.admin.ecook.view.HomeItem2Activity;
import com.phone1000.admin.ecook.view.HomeItemActivity;
import com.phone1000.admin.ecook.view.IHomeVIew;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/11/8.
 */

public class HomeFragment extends Fragment implements IHomeVIew, View.OnClickListener {
    private ListView home_list = null;
    private List<HomeListDataInfo.ListBean> list = new ArrayList<>();
    private View home_head1 = null;
    private ViewPager home_head_viewPage = null;
    private View home_head2 = null;
    private View home_head3 = null;
    private View home_foot = null;
    private RecyclerView home_head_rv = null;
    private IHomePresenter presenter = new HomePresenter(this);
    private View v = null;
    private boolean isBottom = false;
    private Intent intent = null;
    private HomeListAdapter adapter = null;
    private String ids = HomeFirstPage.FIRST_PAGE;
    private SwipeRefreshLayout home_swipe = null;
    private int j = 1;
    private ImageView find,back,share;
    private LinearLayout ll_teach;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.home_fragment_layout, container, false);
        initView();
        x.view().inject(getActivity());
        adapter = new HomeListAdapter(list, getActivity());
        home_list.addHeaderView(home_head2);
        home_list.addHeaderView(home_head3);
        home_list.setAdapter(adapter);
        home_list.addFooterView(home_foot);
        home_swipe.setColorSchemeColors(Color.BLUE,Color.YELLOW,Color.BLACK);
        home_swipe.post(new Runnable() {
            @Override
            public void run() {
               home_swipe.setRefreshing(true);
            }
        });
        setHeadData();
        setListener();
        return v;
    }

    private void setListener() {
        find.setOnClickListener(this);
        back.setOnClickListener(this);
        share.setOnClickListener(this);
        ll_teach.setOnClickListener(this);
        home_swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                presenter.getListData(HomeFirstPage.FIRST_PAGE);//第一页的数据
            }
        });
        home_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent();
                if (list.get(i - 2).getType() == 2) {
                    intent.setClass(getContext(), HomeItem2Activity.class);
                    intent.putExtra("url", "http://api.ecook.cn/public/getCollectionSortDetailById.shtml?id=" + list.get(i - 2).getId());
                } else {
                    Log.d("test", list.get(i - 2).getId() + "");
                    intent.setClass(getContext(), HomeItemActivity.class);
                    intent.putExtra("url", "http://api.ecook.cn/public/getRecipeListByIds.shtml?ids=" + list.get(i - 2).getId());
                    intent.putExtra("imageUrl", list.get(i - 2).getUserImage());
                    intent.putExtra("praise", list.get(i - 2).getLikeNum() + "");
                    intent.putExtra("collection", list.get(i - 2).getCollectionNum() + "");
                    intent.putExtra("type", list.get(i - 2).getType());
                }
                startActivity(intent);
            }
        });
        home_list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (isBottom == true) {
                    isBottom = false;

                    StringBuffer idss = new StringBuffer();
                    String[] split = ids.split(",");
                    for (int k = 0; k < split.length; k++) {
                        int id = Integer.parseInt(split[k]);
                        if (k == split.length - 1) {
                            idss.append(id - 10 * j);
                        } else {
                            idss.append(id - 10 * j + ",");
                        }
                    }
                    j++;
                    ids = idss.toString();//对请求字串的处理
                    presenter.getListData(ids);
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (i + i1 == i2) {
                    isBottom = true;
                }
            }
        });
    }

    private void setHeadData() {
        home_head_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void initView() {
        find = (ImageView) v.findViewById(R.id.find);
        back = (ImageView) v.findViewById(R.id.back);
        share = (ImageView) v.findViewById(R.id.share);
        home_list = (ListView) v.findViewById(R.id.home_list);
        home_head2 = RelativeLayout.inflate(getActivity(), R.layout.home_head2, null);
        ll_teach = (LinearLayout) home_head2.findViewById(R.id.ll_teach);
        home_head_viewPage = (ViewPager) home_head2.findViewById(R.id.home_head_viewPager);
        home_head3 = RelativeLayout.inflate(getActivity(), R.layout.home_head3, null);//添加listView头部
        home_head_rv = (RecyclerView) home_head3.findViewById(R.id.home_rv);
        home_foot = RelativeLayout.inflate(getActivity(), R.layout.list_foot, null);

        home_swipe = (SwipeRefreshLayout) v.findViewById(R.id.home_swipe);
        presenter.getData();
        presenter.getListData(ids);

    }

    @Override
    public void getData(List<HomeDataInfo.DataBean.RecommendUserListBean> list) {
        home_head_rv.setAdapter(new HomeRecyclerViewAdapter(list, getActivity()));
    }

    @Override
    public void getHeadViewPagerData(List<HomeDataInfo.DataBean.BannerListBean> list) {
        home_head2.setVisibility(View.VISIBLE);
        home_head_viewPage.setAdapter(new HomeHeadAdapter(list, getActivity()));

    }

    @Override
    public void getDataAll(HomeDataInfo homeDataInfo) {
    }

    @Override
    public void getListData(HomeListDataInfo homeListDataInfo) {
        home_swipe.setRefreshing(false);
        list.addAll(homeListDataInfo.getList());
        adapter.notifyDataSetChanged();
        home_foot.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.find:
                intent = new Intent(getContext(), FindActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                if(!MyApplication.isLogin()){
                    LoginUtils.login(getActivity());
                }else{
                    Toast.makeText(getActivity(), "功能未实现", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.share:
                if(!MyApplication.isLogin()){
                    LoginUtils.login(getActivity());
                }else{
                    intent.setClass(getContext(), Main4Activity.class);
                    startActivity(intent);
                }
                break;
            case R.id.ll_teach:
                intent = new Intent(getContext(), ShiPinCaiPuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
