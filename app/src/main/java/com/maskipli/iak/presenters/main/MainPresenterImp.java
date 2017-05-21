package com.maskipli.iak.presenters.main;

import com.maskipli.iak.models.beans.Puskesmas;
import com.maskipli.iak.utils.network.NetworkService;
import com.maskipli.iak.views.main.MainView;

import rx.Observable;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class MainPresenterImp implements MainPresenter {

    MainView mainView;
    NetworkService service;

    public MainPresenterImp(MainView mainView, NetworkService service) {
        this.mainView = mainView;
        this.service = service;
    }


    @Override
    public Observable<Puskesmas> loadDataPuskesmas() {
        return (Observable<Puskesmas>) service
                .getPreparedObservable(service.getApi().getPuskesmas(), Puskesmas.class, true, true);
    }
}
