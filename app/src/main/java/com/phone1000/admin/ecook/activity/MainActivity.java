package com.phone1000.admin.ecook.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.TeachFragment.TeachFragment;
import com.phone1000.admin.ecook.fragment.HomeFragment;
import com.phone1000.admin.ecook.fragment.MineFragment;
import com.phone1000.admin.ecook.fragment.StoreFragment;
import com.phone1000.admin.ecook.fragment.TalkFragment;
import com.phone1000.admin.ecook.utils.NetworkUtils;

import org.xutils.x;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_home, ll_store, ll_teach, ll_talk, ll_mine;
    private Fragment homeFragment, storeFragment, teachFragment, talkFragment, mineFragment;
    private ImageView ivHome, ivStore, ivTeach, ivTalk, ivMine;
    private TextView txtHome,txtStore,txtTeach,txtTalk,txtMine;
    private Toolbar activity_main_toolBar = null;
    private TextView toolBar_title = null;
    private long lastExitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!NetworkUtils.isNetworkAvailable(this)){
            Toast.makeText(this,"不网络可用",Toast.LENGTH_SHORT).show();
        }
        x.view().inject(this);
        initView();

        setListener();

        setSelect(0);

    }

    private void setListener() {
        ll_home.setOnClickListener(this);
        ll_store.setOnClickListener(this);
        ll_teach.setOnClickListener(this);
        ll_talk.setOnClickListener(this);
        ll_mine.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if((System.currentTimeMillis() - lastExitTime > 2000)){
                Toast.makeText(this,"再摁一次退出程序",Toast.LENGTH_SHORT).show();
                lastExitTime = System.currentTimeMillis();
            }else{
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initView() {
        ll_home = (LinearLayout) findViewById(R.id.ll_home);
        ll_store = (LinearLayout) findViewById(R.id.ll_store);
        ll_teach = (LinearLayout) findViewById(R.id.ll_teach);
        ll_talk = (LinearLayout) findViewById(R.id.ll_talk);
        ll_mine = (LinearLayout) findViewById(R.id.ll_mine);

        ivHome = (ImageView) findViewById(R.id.ivHome);
        ivTeach = (ImageView) findViewById(R.id.ivTeach);
        ivStore = (ImageView) findViewById(R.id.ivStore);
        ivTalk = (ImageView) findViewById(R.id.ivTalk);
        ivMine = (ImageView) findViewById(R.id.ivMine);

        txtHome = (TextView) findViewById(R.id.txtHome);
        txtStore = (TextView) findViewById(R.id.txtStore);
        txtTeach = (TextView) findViewById(R.id.txtTeach);
        txtTalk = (TextView) findViewById(R.id.txtTalk);
        txtMine = (TextView) findViewById(R.id.txtMine);
//        activity_main_toolBar = (Toolbar) findViewById(R.id.activity_main_toolBar);
//        toolBar_title = (TextView) findViewById(R.id.toolBar_title);
    }

    @Override
    public void onClick(View view) {
        resetImgs();
        switch (view.getId()) {
            case R.id.ll_home:
                setSelect(0);
                break;
            case R.id.ll_store:
                setSelect(1);
                break;
            case R.id.ll_teach:
                setSelect(2);
                break;
            case R.id.ll_talk:
                setSelect(3);
                break;
            case R.id.ll_mine:
                setSelect(4);
                break;
            default:
                break;
        }
    }

    private void resetImgs() {
        ivHome.setImageResource(R.mipmap.tabbar_homepage);
        ivStore.setImageResource(R.mipmap.tabbar_shop);
        ivTeach.setImageResource(R.mipmap.tabbar_course);
        ivTalk.setImageResource(R.mipmap.tabbar_community);
        ivMine.setImageResource(R.mipmap.tabbar_mine);
    }

    public void setSelect(int select) {
        FragmentManager manager = getSupportFragmentManager();//设置Fragment管理器
        //开启一个事务
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);//将事务给隐藏   生成一个方法
        // 这里面做两件事 把图片设置成亮的
        // 设置内容区域
        switch (select) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.activity_main, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
//                toolBar_title.setVisibility(View.GONE);
                ivHome.setImageResource(R.mipmap.tabbar_homepage_selected);
                txtHome.setTextColor(Color.rgb(255,192,0));
                txtStore.setTextColor(Color.BLACK);
                txtTeach.setTextColor(Color.BLACK);
                txtTalk.setTextColor(Color.BLACK);
                txtMine.setTextColor(Color.BLACK);
                break;

            case 1:
                if (storeFragment == null) {
                    storeFragment = new StoreFragment();
                    transaction.add(R.id.activity_main, storeFragment);
                } else {
                    transaction.show(storeFragment);
                }
//                toolBar_title.setVisibility(View.VISIBLE);
//                toolBar_title.setText("厨币商城");
                ivStore.setImageResource(R.mipmap.tabbar_shop_selected);
                txtHome.setTextColor(Color.BLACK);
                txtStore.setTextColor(Color.rgb(255,192,0));
                txtTeach.setTextColor(Color.BLACK);
                txtTalk.setTextColor(Color.BLACK);
                txtMine.setTextColor(Color.BLACK);
                break;

            case 2:
                if (teachFragment == null) {
                    teachFragment = new TeachFragment();
                    transaction.add(R.id.activity_main, teachFragment);
                } else {
                    transaction.show(teachFragment);
                }
//                toolBar_title.setVisibility(View.VISIBLE);
//                toolBar_title.setText("教学");
                ivTeach.setImageResource(R.mipmap.tabbar_course_selected);
                txtHome.setTextColor(Color.BLACK);
                txtStore.setTextColor(Color.BLACK);
                txtTeach.setTextColor(Color.rgb(255,192,0));
                txtTalk.setTextColor(Color.BLACK);
                txtMine.setTextColor(Color.BLACK);
                break;

            case 3:
                if (talkFragment == null) {
                    talkFragment = new TalkFragment();
                    transaction.add(R.id.activity_main, talkFragment);
                } else {
                    transaction.show(talkFragment);
                }
//                toolBar_title.setVisibility(View.VISIBLE);
//                toolBar_title.setText("厨说");
                ivTalk.setImageResource(R.mipmap.tabbar_community_selected);
                txtHome.setTextColor(Color.BLACK);
                txtStore.setTextColor(Color.BLACK);
                txtTeach.setTextColor(Color.BLACK);
                txtTalk.setTextColor(Color.rgb(255,192,0));
                txtMine.setTextColor(Color.BLACK);
                break;
            case 4:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.activity_main, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
//                toolBar_title.setVisibility(View.VISIBLE);
//                toolBar_title.setText("我的");
                ivMine.setImageResource(R.mipmap.tabbar_mine_selected);
                txtHome.setTextColor(Color.BLACK);
                txtStore.setTextColor(Color.BLACK);
                txtTeach.setTextColor(Color.BLACK);
                txtTalk.setTextColor(Color.BLACK);
                txtMine.setTextColor(Color.rgb(255,192,0));
            default:
                break;
        }
        transaction.commit();//无论如何 在事务操作结束以后 需要commit一下
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (storeFragment != null) {
            transaction.hide(storeFragment);
        }
        if (teachFragment != null) {
            transaction.hide(teachFragment);
        }
        if (talkFragment != null) {
            transaction.hide(talkFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }
}
