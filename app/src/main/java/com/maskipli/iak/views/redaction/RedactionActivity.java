package com.maskipli.iak.views.redaction;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maskipli.iak.Apps;
import com.maskipli.iak.R;
import com.maskipli.iak.adapters.GenericAdapter;
import com.maskipli.iak.base.BaseActivity;
import com.maskipli.iak.holders.ArticelHolder;
import com.maskipli.iak.models.beans.Redaction;
import com.maskipli.iak.presenters.redaction.RedactionPresenter;
import com.maskipli.iak.presenters.redaction.RedactionPresenterImp;
import com.maskipli.iak.utils.network.NetworkService;

import butterknife.BindView;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RedactionActivity extends BaseActivity implements RedactionView {

    private RedactionPresenter redactionPresenter;
    Subscription subscription;

    @BindView(R.id.list_articel)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_redaction);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getIntent().getStringExtra("name"));
        }
        NetworkService service = ((Apps) getApplication()).getNetworkService();
        redactionPresenter = new RedactionPresenterImp(this, service);
        subscription = redactionPresenter.getDataRedaction()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadSuccess, this::onLoadFailed);
        setSubscription(subscription);
    }

    @Override
    public String bundleData() {
        return getIntent().getStringExtra("data");
    }


    @Override
    public void onLoadSuccess(Redaction result) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        GenericAdapter adapter = new GenericAdapter<Redaction.Articles, ArticelHolder>
                (R.layout.layout_item_articel,
                        ArticelHolder.class,
                        result.getArticles()) {
            @Override
            protected void bindView(ArticelHolder holder, Redaction.Articles model, int position) {
                holder.bind(model);
                loadImageIntoGlide(holder, model);
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed(Throwable throwable) {
        subscription.unsubscribe();
    }

    private void loadImageIntoGlide(ArticelHolder holder, Redaction.Articles model) {
        Glide.with(this)
                .load(model.urlToImage)
                .into(holder.getImagePoster());
        holder.getItem_card().setOnClickListener(v -> {
            redactionPresenter.onClickList(model);
        });
    }

}
