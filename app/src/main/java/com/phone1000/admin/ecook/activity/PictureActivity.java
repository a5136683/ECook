package com.phone1000.admin.ecook.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.adapter.PictureAdapter;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


public class PictureActivity extends AppCompatActivity {

    String[] detail_url = null;
    private ViewPager picture_activity_vpShow = null;
    private TextView picture_activity_picNum = null;
//    private TextView picture_activity_title = null;
    private TextView picture_activity_currentPic = null;
//    private RelativeLayout picture_activity_rl = null;
    private PictureAdapter adapter = null;
    private List<ImageView> imageList = new ArrayList<>();
    private PhotoView image = null;
    private List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
    private ImageOptions options = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picture);
        options = new ImageOptions.Builder().setImageScaleType(ImageView.ScaleType.CENTER).setFailureDrawableId(R.mipmap.head_image_weman).setLoadingDrawableId(R.mipmap.head_image_weman).build();
        detail_url = getIntent().getStringArrayExtra("image");
        initView();
        if(detail_url.length==1){
            image = new PhotoView(this);
            x.image().bind(image,"http://pic.ecook.cn/web/"+detail_url[0]+".jpg!m720",options);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            imageList.add(image);
        }else{
        for(int i = 0 ; i < detail_url.length -1; i++){
            image = new PhotoView(this);
            x.image().bind(image,"http://pic.ecook.cn/web/"+detail_url[i]+".jpg!m720",options);
            image.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    finish();
                }
            });
//            image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });
            imageList.add(image);
        }}
        picture_activity_picNum.setText(imageList.size()+"");
        adapter = new PictureAdapter(imageList,this);
        picture_activity_vpShow.setAdapter(adapter);
        setListener();
    }

    private void setListener() {

        picture_activity_vpShow.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                picture_activity_currentPic.setText(arg0+1+"");
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    private void initView() {
        picture_activity_vpShow = (ViewPager) findViewById(R.id.picture_activity_vpShow);
        picture_activity_picNum = (TextView) findViewById(R.id.picture_activity_picNum);
        picture_activity_currentPic = (TextView) findViewById(R.id.picture_activity_currentPic);
//        picture_activity_title = (TextView) findViewById(R.id.picture_activity_title);
//        picture_activity_rl = (RelativeLayout) findViewById(R.id.picture_activity_rl);
    }

}
