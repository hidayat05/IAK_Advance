package com.maskipli.iak;

import android.app.Application;

import com.maskipli.iak.utils.network.NetworkService;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class Apps extends Application {

    NetworkService networkService;

    @Override
    public void onCreate() {
        super.onCreate();
        networkService = new NetworkService();
    }

    public NetworkService getNetworkService() {
        return networkService;
    }
}
