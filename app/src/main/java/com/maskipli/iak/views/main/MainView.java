package com.maskipli.iak.views.main;

import com.maskipli.iak.models.beans.Source;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public interface MainView {

    void intentInto(Class activity, String stringExtra, String name);

    void onSuccessLoad(Source result);

    void onErrorLoad(Throwable error);
}
