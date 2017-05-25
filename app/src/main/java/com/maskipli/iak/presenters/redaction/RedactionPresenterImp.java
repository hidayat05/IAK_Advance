package com.maskipli.iak.presenters.redaction;

import com.maskipli.iak.BuildConfig;
import com.maskipli.iak.models.beans.Redaction;
import com.maskipli.iak.utils.network.NetworkService;
import com.maskipli.iak.views.browser.BrowserActivity;
import com.maskipli.iak.views.redaction.RedactionView;

import rx.Observable;

/**
 * @author nurhidayat
 * @since 5/23/17.
 */

public class RedactionPresenterImp  implements RedactionPresenter{

    private RedactionView view;
    private NetworkService service;

    public RedactionPresenterImp(RedactionView view, NetworkService service) {
        this.view = view;
        this.service = service;
    }


    @SuppressWarnings("unchecked")
    @Override
    public Observable<Redaction> getDataRedaction() {
        return (Observable<Redaction>) service.getPreparedObservable(service.getApi()
                        .getNewsFromSource(view.bundleData(), BuildConfig.API_KEY),
                        Redaction.class, false, false);
    }

    @Override
    public void onClickList(Redaction.Articles data) {
        view.intentInto(BrowserActivity.class, data.url);
    }
}
