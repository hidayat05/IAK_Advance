package com.maskipli.iak.utils.network;

import android.util.LruCache;

import com.maskipli.iak.BuildConfig;
import com.maskipli.iak.models.beans.Ambulan;
import com.maskipli.iak.models.beans.Damkar;
import com.maskipli.iak.models.beans.Puskesmas;
import com.maskipli.iak.models.beans.RumahSakitKhusus;
import com.maskipli.iak.models.beans.RumahSakitUmum;
import com.maskipli.iak.models.beans.Tps;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class NetworkService {

    private NetworkApi networkApi;
    private LruCache<Class<?>, Observable<?>> apiObservable;

    public NetworkService() {
        OkHttpClient okHttpClient = buildClient();
        apiObservable = new LruCache<>(10);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URI)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        networkApi = retrofit.create(NetworkApi.class);
    }

    private OkHttpClient buildClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(chain -> chain.proceed(chain.request()));
        builder.addInterceptor(chain -> {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", BuildConfig.API_KEY)
                    .build();
            return chain.proceed(request);
        });
        return builder.build();
    }

    public Observable<?> getPreparedObservable(Observable<?> unPreparedObservable,
                                               Class<?> clazz,
                                               boolean chacheObservable,
                                               boolean useChace) {
        Observable<?> preparedObservable = null;
        if (useChace) {
            preparedObservable = apiObservable.get(clazz);
        }
        if (preparedObservable != null) {
            return preparedObservable;
        }
        preparedObservable = unPreparedObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        if (chacheObservable) {
            preparedObservable = preparedObservable.cache();
            apiObservable.put(clazz, preparedObservable);
        }
        return preparedObservable;
    }


    public NetworkApi getApi() {
        return networkApi;
    }

    public interface NetworkApi {

        @GET("rumahsakitumum")
        Observable<RumahSakitUmum> getRumahSakitUmum();

        @GET("rumahsakitkhusus")
        Observable<RumahSakitKhusus> getRumahSakitKhusus();

        @GET("puskesmas")
        Observable<Puskesmas> getPuskesmas();

        @GET("emergency/petugaspemadam")
        Observable<Damkar> getDamkar();

        @GET("emergency/ambulance")
        Observable<Ambulan> getAmbulan();

        @GET("tps")
        Observable<Tps> getTps();

        @GET("tps?page={page}")
        Observable<Tps> getTpsPage(@Path("page") int page);
    }
}

