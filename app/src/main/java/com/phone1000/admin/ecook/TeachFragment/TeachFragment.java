package com.phone1000.admin.ecook.TeachFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class TeachFragment extends Fragment implements View.OnClickListener,ViewPager.OnPageChangeListener {
    private ViewPager vpTeach;
    private View view;
    private TextView txtShiPing,txtZhiBo,txtXianXia;
    private ImageView ivShiPing,ivZhiBo,ivXianXia;

    private List<ImageView> imgList=null;
    private List<Fragment> fragmentList=null;
    private List<TextView> txtList=null;
    private Fragment teachFragment_ShiPing, teachFragment_ZhiBo, teachFragment_XianXia;
    private  MyFragmentAdapter adapter;
    private  int prePostion=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.teach_fragment_layout,null);
        initView();
        setData();
        setListener();
        return view;

    }
//设置文本监听
    private void setListener() {
        vpTeach.setOnPageChangeListener(this);

        txtShiPing.setOnClickListener(this);
        txtZhiBo.setOnClickListener(this);
        txtXianXia.setOnClickListener(this);


    }
//初始化控件及fragment
    private void initView() {
        vpTeach= (ViewPager) view.findViewById(R.id.vpTeach);

        txtShiPing= (TextView) view.findViewById(R.id.txtShiPing);
        txtZhiBo= (TextView) view.findViewById(R.id.txtZhiBo);
        txtXianXia= (TextView) view.findViewById(R.id.txtXianXia);

        ivShiPing= (ImageView) view.findViewById(R.id.ivShiPing);
        ivZhiBo= (ImageView) view.findViewById(R.id.ivZhiBo);
        ivXianXia= (ImageView) view.findViewById(R.id.ivXianXia);

        teachFragment_ShiPing=new TeachFragment_ShiPing();
        teachFragment_ZhiBo=new TeachFragment_ZhiBo();
        teachFragment_XianXia=new TeachFragment_XianXia();

    }
    //给各自list添加数据
    private void setData() {
        imgList=new ArrayList<>();

        imgList.add(ivShiPing);
        imgList.add(ivZhiBo);
        imgList.add(ivXianXia);

        txtList=new ArrayList<>();
        txtList.add(txtShiPing);
        txtList.add(txtZhiBo);
        txtList.add(txtXianXia);

        fragmentList=new ArrayList<>();
        fragmentList.add(teachFragment_ShiPing);
        fragmentList.add(teachFragment_ZhiBo);
        fragmentList.add(teachFragment_XianXia);

        adapter=new MyFragmentAdapter(getChildFragmentManager(),fragmentList);
        vpTeach.setAdapter(adapter);

    }
    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.txtShiPing:
        vpTeach.setCurrentItem(0);
        break;
    case R.id.txtZhiBo:
        vpTeach.setCurrentItem(1);
        break;
    case R.id.txtXianXia:
        vpTeach.setCurrentItem(2);
        break;

}
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int agr0) {
        imgList.get(agr0).setBackgroundColor(Color.rgb(255,192,00));
        imgList.get(prePostion).setBackgroundColor(Color.WHITE);

        txtList.get(agr0).setTextColor(Color.rgb(255,192,00));
        txtList.get(prePostion).setTextColor(Color.BLACK);

        prePostion=agr0;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
