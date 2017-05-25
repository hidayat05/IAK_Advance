package com.maskipli.iak.views.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.maskipli.iak.Apps;
import com.maskipli.iak.R;
import com.maskipli.iak.adapters.GridAdapter;
import com.maskipli.iak.base.BaseActivity;
import com.maskipli.iak.models.beans.Source;
import com.maskipli.iak.presenters.main.MainPresenter;
import com.maskipli.iak.presenters.main.MainPresenterImp;
import com.maskipli.iak.utils.network.NetworkService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainView {

    MainPresenter mainPresenter;
    NetworkService service;
    @BindView(R.id.grid_main)
    GridView gridMenu;
    List<Source.Sources> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        bind(R.layout.activity_main);
        service = ((Apps) getApplication()).getNetworkService();
        mainPresenter = new MainPresenterImp(this, service);
        mainPresenter.loadDataSource()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessLoad, this::onErrorLoad);
    }


    @Override
    public void onSuccessLoad(Source result) {
        gridMenu.setAdapter(new GridAdapter(MainActivity.this, mainPresenter, result.sources));
    }

    @Override
    public void onErrorLoad(Throwable error) {
        Log.e(this.getClass().getSimpleName(), error.getLocalizedMessage());
    }
}
