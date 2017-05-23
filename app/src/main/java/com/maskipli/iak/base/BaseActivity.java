package com.maskipli.iak.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class BaseActivity extends AppCompatActivity{

    Subscription subscription;
    protected void bind(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public void intentInto(Class activity, String stringExtra) {
        Intent intent = new Intent(this, activity);
        intent.putExtra("data", stringExtra);
        startActivity(intent);
    }
}
