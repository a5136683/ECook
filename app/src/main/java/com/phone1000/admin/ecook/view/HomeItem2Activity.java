package com.phone1000.admin.ecook.view;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.adapter.HomeList2Adapter;
import com.phone1000.admin.ecook.bean.HomeItem2DataInfo;
import com.phone1000.admin.ecook.bean.HomeItemDataInfo;
import com.phone1000.admin.ecook.presenter.HomeItemPresenter;
import com.phone1000.admin.ecook.presenter.IHomeItemPresenter;
import com.phone1000.admin.ecook.utils.ShareSdkDemo;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class HomeItem2Activity extends AppCompatActivity implements IHomeItemView,View.OnClickListener{

    private IHomeItemPresenter iHomeItemPresenter = new HomeItemPresenter(this);
    private ImageOptions options = null;
    private HomeItem2DataInfo homeItem2DataInfo = null;
    @ViewInject(R.id.home_item2_lv)
    private ListView listView = null;
    private View head = null;
    private ImageView home_item_iv,home_item_userImage;
    private TextView home_item_title,home_item_praise,home_item_share,home_item_userName,home_item_time;
    @ViewInject(R.id.back)
    private ImageView back;
    @ViewInject(R.id.share)
    private ImageView share;
    private List list = null;
    private String imageUrl = null;
    private String url = null;
    private ImageView animation = null;//动画视图
    private AnimationDrawable animationDrawable = null;//动画视图
    private LinearLayout animation_ll = null;
    private TextView content = null;
    private TextView show_all = null;
    private TextView pack_up = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_item2);
        x.view().inject(this);
        initView();
        setListener();
    }

    private void setListener() {
        back.setOnClickListener(this);
        share.setOnClickListener(this);
        show_all.setOnClickListener(this);
        pack_up.setOnClickListener(this);
    }

    private void initView() {
        animation = (ImageView) findViewById(R.id.animation);
        animationDrawable = (AnimationDrawable) animation.getBackground();
        animation_ll = (LinearLayout) findViewById(R.id.animation_ll);
        animationDrawable.start();
        url = getIntent().getStringExtra("url");
        iHomeItemPresenter.getItem2Url(url);
        head = RelativeLayout.inflate(this,R.layout.home_item_head2,null);

        content = (TextView) head.findViewById(R.id.content);
        show_all = (TextView) head.findViewById(R.id.show_all);
        pack_up = (TextView) head.findViewById(R.id.pack_up);

        home_item_iv = (ImageView) head.findViewById(R.id.home_item_iv);
        home_item_userImage = (ImageView) head.findViewById(R.id.home_item_userImage);
        home_item_title = (TextView) head.findViewById(R.id.home_item_title);
        home_item_praise = (TextView) head.findViewById(R.id.home_item_praise);
        home_item_share = (TextView) head.findViewById(R.id.home_item_share);
        home_item_userName = (TextView) head.findViewById(R.id.home_item_userName);
        home_item_time = (TextView) head.findViewById(R.id.home_item_time);
    }

    @Override
    public void getItemData(HomeItemDataInfo homeItemDataInfo) {
    }

    @Override
    public void getItem2Data(HomeItem2DataInfo homeItem2DataInfo) {
        this.homeItem2DataInfo = homeItem2DataInfo;
        if(homeItem2DataInfo!=null){
//            animationDrawable.stop();
            animation_ll.setVisibility(View.GONE);}
        setData();
    }

    private void setData() {

        options = new ImageOptions.Builder().setFailureDrawableId(R.mipmap.head_image_weman).setLoadingDrawableId(R.mipmap.head_image_weman).setCircular(true).build();//设置圆形的imageView
//        Log.d("test",homeItemDataInfo.getImageid()+"~~~~~~~~~~~~");
        if (homeItem2DataInfo != null) {
            imageUrl = "http://pic.ecook.cn/web/" + homeItem2DataInfo.getDetails().getImageid()+ ".jpg";
            x.image().bind(home_item_iv, imageUrl);
            home_item_title.setText(homeItem2DataInfo.getDetails().getName());
            home_item_userName.setText(homeItem2DataInfo.getDetails().getUsernickname());
            x.image().bind(home_item_userImage,"http://pic.ecook.cn/web/" + homeItem2DataInfo.getDetails().getUserimageid()+ ".jpg",options);
            home_item_praise.setText("专辑");
            home_item_share.setText(homeItem2DataInfo.getDetails().getRecipeCount()+"道菜");
            home_item_time.setText(homeItem2DataInfo.getDetails().getTime());
            content.setText(homeItem2DataInfo.getDetails().getDescription());
            listView.addHeaderView(head);//应放在listview的适配器之前
            listView.setAdapter(new HomeList2Adapter(homeItem2DataInfo.getDetails().getRecipeList(),this));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.share:
                ShareSdkDemo.showShare(this,imageUrl,url);
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
        }
    }
}
