package com.maskipli.iak.presenters.main;

import com.maskipli.iak.models.beans.Source;
import com.maskipli.iak.utils.network.NetworkService;
import com.maskipli.iak.views.main.MainView;
import com.maskipli.iak.views.redaction.RedactionActivity;

import rx.Observable;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class MainPresenterImp implements MainPresenter{

    MainView mainView;
    NetworkService service;

    public MainPresenterImp(MainView mainView, NetworkService service) {
        this.mainView = mainView;
        this.service = service;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable<Source> loadDataSource() {
        return (Observable<Source>) service
                .getPreparedObservable(service.getApi().getAllSource(), Source.class, true, true);
    }

    @Override
    public void setOnGridClicked(String data, String name) {
        mainView.intentInto(RedactionActivity.class, data, name);
    }

}
