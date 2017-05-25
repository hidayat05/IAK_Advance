package com.maskipli.iak.holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maskipli.iak.R;
import com.maskipli.iak.models.beans.Redaction;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author nurhidayat
 * @since 5/23/17.
 */

public class ArticelHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.iv_poster)
    ImageView imagePoster;
    @BindView(R.id.tv_title)
    TextView textTitle;
    @BindView(R.id.item_card)
    CardView item_card;


    public ArticelHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Redaction.Articles articles) {
        textTitle.setText(articles.title);
    }

    public ImageView getImagePoster() {
        return imagePoster;
    }

    public CardView getItem_card() {
        return item_card;
    }
}
