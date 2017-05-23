package com.maskipli.iak.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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
    @BindView(R.id.tv_description)
    TextView textDescription;
    @BindView(R.id.tv_date)
    TextView textDate;
    @BindView(R.id.tv_author)
    TextView textAuthor;
    @BindView(R.id.btn_openOnWeb)
    Button btnOpenOnWeb;


    public ArticelHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Redaction.Articles articles) {
        textTitle.setText(articles.title);
        textDescription.setText(articles.description);
        textDate.setText(articles.publishedAt);
        textAuthor.setText(articles.author);
    }

    public ImageView getImagePoster() {
        return imagePoster;
    }

    public Button getBtnOpenOnWeb() {
        return btnOpenOnWeb;
    }
}
