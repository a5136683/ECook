package com.phone1000.admin.ecook.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.activity.ShiPingActivity;
import com.phone1000.admin.ecook.adapter.FootViewPagerAdapter;
import com.phone1000.admin.ecook.adapter.HomeItemAdapter;
import com.phone1000.admin.ecook.app.MyApplication;
import com.phone1000.admin.ecook.bean.HomeItem2DataInfo;
import com.phone1000.admin.ecook.bean.HomeItemDataInfo;
import com.phone1000.admin.ecook.bean.VideoInfo;
import com.phone1000.admin.ecook.presenter.HomeItemPresenter;
import com.phone1000.admin.ecook.presenter.IHomeItemPresenter;
import com.phone1000.admin.ecook.utils.LoginUtils;
import com.phone1000.admin.ecook.utils.ShareSdkDemo;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


public class HomeItemActivity extends AppCompatActivity implements IHomeItemView, View.OnClickListener {
    private String url = null;
    private String headUrl = null;
    private String imageUrl = null;
    private HomeItemDataInfo homeItemDataInfo = null;
    private IHomeItemPresenter iHomeItemPresenter = new HomeItemPresenter(this);
    private TextView home_item_title, home_item_praise, home_item_share, home_item_userName;
    private ImageView home_item_iv, home_item_userImage, home_item_ivShow;
    private ListView home_item_rv;
    private ImageOptions options = null;
    private HomeItemAdapter adapter = null;
    private View head = null;
    private View headImage = null;
    private View foot = null;
    private TextView head_text = null;
    private ListView foot_list = null;
    private TextView orderNum = null;
    private TextView content = null;
    private TextView show_all = null;
    private TextView pack_up = null;
    private ViewPager foot_vp = null;
    private TextView foot_txt = null;
    private int type = 0;
    @ViewInject(R.id.back)
    private ImageView back;
    @ViewInject(R.id.share)
    private ImageView share;
    @ViewInject(R.id.collection)
    private ImageView collection;
    private ImageView animation = null;//动画视图
    private AnimationDrawable animationDrawable = null;//动画视图
    private LinearLayout animation_ll = null;
    private AlertDialog.Builder dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_item);
        x.view().inject(this);
        initView();
        setListener();
    }

    private void setListener() {
        back.setOnClickListener(this);
        share.setOnClickListener(this);
        show_all.setOnClickListener(this);
        pack_up.setOnClickListener(this);
        collection.setOnClickListener(this);
        foot_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                foot_txt.setText(homeItemDataInfo.getList().get(0).getStepList().get(position).getDetails());
                orderNum.setText(homeItemDataInfo.getList().get(0).getStepList().get(position).getOrdernum() + "");
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setData() {
        options = new ImageOptions.Builder().setFailureDrawableId(R.mipmap.head_image_weman).setLoadingDrawableId(R.mipmap.head_image_weman).setCircular(true).build();
//        Log.d("test",homeItemDataInfo.getImageid()+"~~~~~~~~~~~~");
        if (homeItemDataInfo != null) {
            headUrl = "http://pic.ecook.cn/web/" + homeItemDataInfo.getList().get(0).getImageid() + ".jpg!m3";
            x.image().bind(home_item_iv, headUrl);
            home_item_title.setText(homeItemDataInfo.getList().get(0).getName());
            home_item_userName.setText(homeItemDataInfo.getList().get(0).getAuthorname());
            x.image().bind(home_item_userImage, "http://pic.ecook.cn/web/" + imageUrl + ".jpg", options);

            home_item_praise.setText("已有" + getIntent().getStringExtra("praise") + "人点赞");
            home_item_share.setText("已有" + getIntent().getStringExtra("collection") + "人收藏");
            content.setText(homeItemDataInfo.getList().get(0).getDescription());


            adapter = new HomeItemAdapter(homeItemDataInfo.getList().get(0).getMaterialList(), this);
            home_item_rv.addHeaderView(headImage);
            home_item_rv.addHeaderView(head);
            home_item_rv.setAdapter(adapter);
            foot_vp.setAdapter(new FootViewPagerAdapter(homeItemDataInfo.getList().get(0).getStepList(), this));
            home_item_rv.addFooterView(foot);
            if (type == 3) {
                home_item_ivShow.setVisibility(View.VISIBLE);
                home_item_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent = new Intent(HomeItemActivity.this, ShiPingActivity.class);
                        final String[] video = new String[1];
                        final String videoUrl = "http://api.ecook.cn/public/getVideoInfo.shtml?project="+homeItemDataInfo.getList().get(0).getId();
                        RequestParams entity = new RequestParams(videoUrl);
                        x.http().post(entity, new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
                                Gson gson = new Gson();
                                VideoInfo videoInfo = gson.fromJson(result, VideoInfo.class);
                                video[0] = videoInfo.getUrlprefix()+videoInfo.getName();//拼接视频的url
                                intent.putExtra("video", video[0].toString() );
                                startActivity(intent);
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
//                        if(video[0]!=null){
//                        intent.putExtra("video", video[0].toString() );
//                        startActivity(intent);}
                    }
                });
            }
        }
    }

    private void initView() {
        animation = (ImageView) findViewById(R.id.animation);
        animationDrawable = (AnimationDrawable) animation.getBackground();
        animation_ll = (LinearLayout) findViewById(R.id.animation_ll);
        animationDrawable.start();
        //动画

        url = getIntent().getStringExtra("url");//获取到listview条目所对应的url
        Log.d("test", url);
        imageUrl = getIntent().getStringExtra("imageUrl");
        type = getIntent().getIntExtra("type", 0);
        head = RelativeLayout.inflate(this, R.layout.single_text_head, null);

        headImage = RelativeLayout.inflate(this, R.layout.home_item_head, null);
        content = (TextView) headImage.findViewById(R.id.content);
        show_all = (TextView) headImage.findViewById(R.id.show_all);
        pack_up = (TextView) headImage.findViewById(R.id.pack_up);
        head_text = (TextView) head.findViewById(R.id.single_text_head);
        home_item_title = (TextView) headImage.findViewById(R.id.home_item_title);
        home_item_praise = (TextView) headImage.findViewById(R.id.home_item_praise);
        home_item_share = (TextView) headImage.findViewById(R.id.home_item_share);
        home_item_userName = (TextView) headImage.findViewById(R.id.home_item_userName);
        home_item_iv = (ImageView) headImage.findViewById(R.id.home_item_iv);
        home_item_ivShow = (ImageView) headImage.findViewById(R.id.home_item_ivShow);
        home_item_userImage = (ImageView) headImage.findViewById(R.id.home_item_userImage);

        foot = RelativeLayout.inflate(this, R.layout.home_item_foot_item, null);
        foot_vp = (ViewPager) foot.findViewById(R.id.home_title_foot_vp);
        foot_txt = (TextView) foot.findViewById(R.id.home_item_foot_txt);
        orderNum = (TextView) foot.findViewById(R.id.orderNum);

        home_item_rv = (ListView) findViewById(R.id.home_item_rv);
        iHomeItemPresenter.getItemUrl(url);
    }

    @Override
    public void getItemData(HomeItemDataInfo homeItemDataInfo) {
        this.homeItemDataInfo = homeItemDataInfo;  //获取数据成功
//        if (homeItemDataInfo != null) {
            animation_ll.setVisibility(View.GONE);
//        }
        setData();
    }

    @Override
    public void getItem2Data(HomeItem2DataInfo homeItem2DataInfo) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.share:
                ShareSdkDemo.showShare(this, headUrl, url);
                break;
            case R.id.show_all:
                content.setMaxLines(10);
                pack_up.setVisibility(View.VISIBLE);
                show_all.setVisibility(View.GONE);
                break;
            case R.id.pack_up:
                content.setMaxLines(1);
                pack_up.setVisibility(View.GONE);
                show_all.setVisibility(View.VISIBLE);
                break;
            case R.id.collection:
                if(!MyApplication.isLogin()){
                    LoginUtils.login(this);
                }else{
                    dialog = new AlertDialog.Builder(this);
                    dialog.setMessage("收藏功能暂未实现");
                    dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(HomeItemActivity.this, "确定", Toast.LENGTH_LONG)
//                                    .show();
                        }
                    });
                    dialog.show();
                }
                break;
        }
    }
}
