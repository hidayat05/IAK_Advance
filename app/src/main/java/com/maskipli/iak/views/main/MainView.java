package com.maskipli.iak.views.main;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public interface MainView {
    void viewData();

    void setToast();

    void intentInto(Class activity, String stringExtra);
}
