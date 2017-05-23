package com.maskipli.iak.views.main;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

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
import rx.Observer;

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
        mainPresenter.loadDataSource().subscribe(new Observer<Source>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Source source) {
                gridMenu.setAdapter(new GridAdapter(MainActivity.this, mainPresenter, source.sources));
            }
        });
    }


    @Override
    public void viewData() {

    }


    @Override
    public void setToast() {
        Toast.makeText(this, "bener ini ambulance", Toast.LENGTH_SHORT).show();
    }

}
