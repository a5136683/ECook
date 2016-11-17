package com.phone1000.admin.ecook.fragment.MyFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.phone1000.admin.ecook.R;
import com.phone1000.admin.ecook.utils.MyChromClient;
import com.phone1000.admin.ecook.utils.MyWebViewClient;

import org.xutils.x;

/**
 * Created by admin on 2016/11/8.
 */

public class StoreFragment extends Fragment {
    private ImageView back;
    private View v = null;
    private String url = "http://mall.ecook.cn/category/list?f=ecook_show_mine&machine=O5f4a734fdc4008ddc289d77fa18a74be8fd41a77";
//    @ViewInject(R.id.store_web)
    private WebView store_web;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = LayoutInflater.from(getActivity()).inflate(R.layout.store_fragment,container,false);
        x.view().inject(this,inflater,container);
        initView();

        setListener();


        return v;
    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(store_web.canGoBack()){
                    store_web.goBack();
                }else{
                    Toast.makeText(getActivity(), "已达到起始页面", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private void initView() {
        store_web = (WebView) v.findViewById(R.id.store_web);
        back = (ImageView) v.findViewById(R.id.back);
        MyWebViewClient client = new MyWebViewClient();
        MyChromClient chromClient = new MyChromClient();
        WebSettings webSettings = store_web.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(true);
        webSettings
                .setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//适应大小
        webSettings.setTextSize(TextSize.SMALLER);// 设置字体大小75%
        webSettings.setDefaultFontSize(1);
        store_web.setWebChromeClient(chromClient);
        store_web.setWebViewClient(client);
        store_web.loadUrl(url);

}
}
