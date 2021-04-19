package com.tyd.supermarket.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tyd.supermarket.R;

/**
 * 发现
 */
public class scFragment extends Fragment {
    private static final String TAG = "WebView";

    private WebView webView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.sc,container,false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webView= getActivity().findViewById(R.id.web);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("https://m.dianping.com/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                // webview自己加载URL，让后通知系统不需要HandleURL
                view.loadUrl(url);
                return true;
            }
            @Override
            public void  onPageStarted(WebView view, String url, Bitmap favicon) {
                //设定加载开始的操作
            }

        });
    }

}
