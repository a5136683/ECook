package com.phone1000.admin.ecook.bean.TeachFragmentBean;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
	 public interface ClientCallback{
	        void onStart(String url);
	        void onFinish(String url);
	    }

	    private ClientCallback mCallBack;

	    public void setClientListener(ClientCallback mCallBack){
	        this.mCallBack = mCallBack;
	    }

	    @Override
	    public void onPageStarted(WebView view, String url, Bitmap favicon) {
	        super.onPageStarted(view, url, favicon);

	        if(mCallBack != null){
	            mCallBack.onStart(url);
	        }
	    }

	    @Override
	    public void onPageFinished(WebView view, String url) {
	        super.onPageFinished(view, url);

	        if(mCallBack != null){
	            mCallBack.onFinish(url);
	        }
	    }
}
