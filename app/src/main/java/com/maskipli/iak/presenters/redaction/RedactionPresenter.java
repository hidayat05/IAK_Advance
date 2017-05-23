package com.maskipli.iak.presenters.redaction;

import com.maskipli.iak.models.beans.Redaction;

import rx.Observable;

/**
 * @author nurhidayat
 * @since 5/23/17.
 */

public interface RedactionPresenter {

    Observable<Redaction> getDataRedaction();

    void onClickList(Redaction.Articles data);
}
