package com.maskipli.iak.base;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class BaseActivity extends AppCompatActivity{

    protected Subscription subscriber = new CompositeSubscription();

    protected void bind(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }
}
