package com.maskipli.iak.utils.network;

import android.util.Log;
import android.util.LruCache;

import com.maskipli.iak.BuildConfig;
import com.maskipli.iak.models.beans.Redaction;
import com.maskipli.iak.models.beans.Source;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
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
                    .build();
            Log.e("url request", request.url().toString());
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

        @GET("sources")
        Observable<Source> getAllSource();

        @GET("articles")
        Observable<Redaction> getNewsFromSource(@Query("source") String source,
                                                @Query("apiKey") String key);

        @GET("articles")
        Observable<Redaction> getNewsSourceSort(@Query("source") String source,
                                                @Query("sort") String sortBy,
                                                @Query("apiKey") String key);
    }
}

