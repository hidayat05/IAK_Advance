package com.maskipli.iak.views.main;

import android.os.Bundle;
import android.util.Log;

import com.maskipli.iak.Apps;
import com.maskipli.iak.R;
import com.maskipli.iak.base.BaseActivity;
import com.maskipli.iak.models.beans.Puskesmas;
import com.maskipli.iak.presenters.main.MainPresenter;
import com.maskipli.iak.presenters.main.MainPresenterImp;
import com.maskipli.iak.utils.network.NetworkService;

import rx.Observer;

public class MainActivity extends BaseActivity implements MainView {

    MainPresenter mainPresenter;
    NetworkService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);
        service = ((Apps) getApplication()).getNetworkService();
        mainPresenter = new MainPresenterImp(this, service);
        mainPresenter.loadDataPuskesmas().subscribe(new Observer<Puskesmas>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("MASKIPS", e.getLocalizedMessage());
            }

            @Override
            public void onNext(Puskesmas puskesmas) {
                for (int i = 0; i < puskesmas.data.size(); i++) {
                    Log.e("MASKIPS", puskesmas.data.get(i).nama_Puskesmas);
                }

            }
        });
    }


    @Override
    public void viewData() {

    }
}
