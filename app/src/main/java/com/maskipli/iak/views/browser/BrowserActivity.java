package com.maskipli.iak.views.browser;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.maskipli.iak.R;
import com.maskipli.iak.base.BaseActivity;
import com.maskipli.iak.presenters.browser.BrowserPresenter;
import com.maskipli.iak.presenters.browser.BrowserPresenterImp;

import butterknife.BindView;

public class BrowserActivity extends BaseActivity implements BrowserView {


    BrowserPresenter presenter;
    @BindView(R.id.wv_internal)
    WebView webView;
    @BindView(R.id.progresbar)
    ProgressBar progressBar;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_browser);
        ActionBar actionBar = getSupportActionBar();
        String url = getIntent().getStringExtra("data");
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(url);
        }
        presenter = new BrowserPresenterImp(this);
        presenter.viewWebData(webView, url);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void setProgresHide(boolean hide) {
        progressBar.setVisibility(hide ? View.GONE : View.VISIBLE);
    }

    @Override
    public void setSwipe() {
        swipe.setOnRefreshListener(() -> presenter.viewWebData(webView,
                getIntent().getStringExtra("data")));
        swipe.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    @Override
    public SwipeRefreshLayout getSwipe() {
        return swipe;
    }

}
