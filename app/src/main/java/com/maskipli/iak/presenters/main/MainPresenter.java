package com.maskipli.iak.presenters.main;

import com.maskipli.iak.models.beans.Puskesmas;

import rx.Observable;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public interface MainPresenter {
    Observable<Puskesmas> loadDataPuskesmas();
}
