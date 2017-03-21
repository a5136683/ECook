package com.phone1000.admin.ecook.view;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.app.MyApplication;
import com.phone1000.admin.ecook.bean.PersonDataInfo;
import com.phone1000.admin.ecook.bean.PersonTalkInfo;
import com.phone1000.admin.ecook.presenter.IPersonPresenter;
import com.phone1000.admin.ecook.presenter.PersonPresenter;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity implements IPerson,View.OnClickListener{

    private String url=null;
    private String talkUrl = null;
    private IPersonPresenter iPersonPresenter = new PersonPresenter(this);//传递view层对象到presenter层，获得presenter对象
    private PersonDataInfo personDataInfo = null;
    private PersonTalkInfo personTalkInfo = null;
    @ViewInject(R.id.person_lv)
    private ListView person_lv= null;

    private View head = null;
    private ImageView userImage,headLevelImage,attention,sex,back;
    private TextView headDesc,userName,fansNum,attention_num,special_num,num,menu_num;
    private String last = "0";
    private ImageOptions options = null;

    private ImageView animation = null;//动画视图
    private AnimationDrawable animationDrawable = null;//动画视图
    private LinearLayout animation_ll = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        x.view().inject(this);
        initView();

        setListData();
        person_lv.addHeaderView(head);
        person_lv.setAdapter(new ArrayAdapter<String>(this,R.layout.person_list_item,new ArrayList<String>()));



        setListener();
    }

    private void setListener() {
        back.setOnClickListener(this);
    }

    private void setListData() {
        //获取了talk信息
        talkUrl = "http://api.ecook.cn/public/getSimpleTalkList.shtml?lastTalkid="+last+"&userid="+getIntent().getStringExtra("Uid");
        iPersonPresenter.getTalkUrl(talkUrl);
    }

    private void setData() {
        options = new ImageOptions.Builder().setCircular(true).build();
        x.image().bind(userImage,"http://pic.ecook.cn/web/"+personDataInfo.getData().getImageid()+".jpg!m3",options);
        headDesc.setText(personDataInfo.getData().getProfile());
        if("0".equalsIgnoreCase(personDataInfo.getData().getSex())){
            sex.setImageResource(R.mipmap.me_gir);
        }else{
            sex.setImageResource(R.mipmap.me_boy);
        }
        userName.setText(personDataInfo.getData().getTitle());
        fansNum.setText(personDataInfo.getData().getFansCount());
        attention_num.setText(personDataInfo.getData().getFollowsCount());
        special_num.setText(personDataInfo.getData().getCollectionSortCount());
        menu_num.setText(personDataInfo.getData().getRecipeCount());
        num.setText(personDataInfo.getData().getTalkCount());
        //iron铁,copper铜,silver银,gold金   等级
        if("iron".equalsIgnoreCase(personDataInfo.getData().getMedal())){
            headLevelImage.setImageResource(R.mipmap.medal_d);
        }else if("copper".equalsIgnoreCase(personDataInfo.getData().getMedal())){
            headLevelImage.setImageResource(R.mipmap.medal_c);
        }else if("silver".equalsIgnoreCase(personDataInfo.getData().getMedal())){
            headLevelImage.setImageResource(R.mipmap.medal_b);
        }else{
            headLevelImage.setImageResource(R.mipmap.medal_a);
        }
        if(MyApplication.isLogin()){
            attention.setVisibility(View.VISIBLE);
        }else{
            attention.setVisibility(View.GONE);
        }
    }

    private void initView() {
        animation = (ImageView) findViewById(R.id.animation);
        animationDrawable = (AnimationDrawable) animation.getBackground();
        animation_ll = (LinearLayout) findViewById(R.id.animation_ll);
        animationDrawable.start();
        url = "http://api.ecook.cn/public/getUserPageData.shtml?id="+getIntent().getStringExtra("Uid");
        iPersonPresenter.getUrl(url);//位置可变

        head = RelativeLayout.inflate(this,R.layout.person_head,null);
        back = (ImageView) head.findViewById(R.id.back);
        userImage = (ImageView) head.findViewById(R.id.head_image);
        headLevelImage = (ImageView) head.findViewById(R.id.head_level_image);
        sex = (ImageView) head.findViewById(R.id.sex);
        headDesc = (TextView) head.findViewById(R.id.head_desc);
        userName = (TextView) head.findViewById(R.id.userName);
        attention = (ImageView) head.findViewById(R.id.attention);
        fansNum = (TextView) head.findViewById(R.id.fans_num);
        attention_num = (TextView) head.findViewById(R.id.attention_num);
        special_num = (TextView) head.findViewById(R.id.special_num);
        num  = (TextView) head.findViewById(R.id.num);
        menu_num = (TextView) head.findViewById(R.id.menu_num);

    }


    @Override
    public void getPersonData(PersonDataInfo personDataInfo) {//获取到的数据

        this.personDataInfo = personDataInfo;
        if(personDataInfo!=null){
            animation_ll.setVisibility(View.GONE);}
        setData();
    }

    @Override
    public void getPersonTalkData(PersonTalkInfo personTalkInfo) {
        this.personTalkInfo = personTalkInfo;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
