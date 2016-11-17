package com.phone1000.admin.ecook.utils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by james on 16/10/17.
 */
public class MyChromClient extends WebChromeClient {

    public interface ChromCallBack{
        void onProgressChanged(int progress);
        void onReceivedTitle(String title);
    }

    private ChromCallBack mCallBack = null;

    public void setChromListener(ChromCallBack mCallBack){
        this.mCallBack = mCallBack;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);

        if(mCallBack!= null){
            mCallBack.onProgressChanged(newProgress);
        }
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);

        if(mCallBack!= null){
            mCallBack.onReceivedTitle(title);
        }
    }
}
