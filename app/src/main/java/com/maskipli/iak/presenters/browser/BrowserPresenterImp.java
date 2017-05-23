package com.maskipli.iak.presenters.browser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.maskipli.iak.views.browser.BrowserView;

/**
 * @author nurhidayat
 * @since 5/23/17.
 */

public class BrowserPresenterImp implements BrowserPresenter {

    private BrowserView view;

    public BrowserPresenterImp(BrowserView view) {
        this.view = view;
        view.setSwipe();
    }

    @Override
    public void viewWebData(WebView webView, String url) {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView viewData, String url) {
                super.onPageFinished(viewData, url);
                view.setProgresHide(true);
                view.getSwipe().setRefreshing(false);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollbarFadingEnabled(true);
        webView.loadUrl(url);
    }


}
