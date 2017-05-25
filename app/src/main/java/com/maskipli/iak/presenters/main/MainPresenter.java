package com.maskipli.iak.presenters.main;

import com.maskipli.iak.models.beans.Source;

import rx.Observable;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public interface MainPresenter {

    Observable<Source> loadDataSource();

    void setOnGridClicked(String data, String name);
}
