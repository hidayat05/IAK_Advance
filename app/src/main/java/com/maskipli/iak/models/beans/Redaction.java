package com.maskipli.iak.models.beans;

import java.util.ArrayList;

/**
 * @author nurhidayat
 * @since 5/23/17.
 */

public class Redaction {

    public String status;
    public String source;
    public String sortBy;
    public ArrayList<Articles> articles;

    public static class Articles {
        public String author;
        public String title;
        public String description;
        public String url;
        public String urlToImage;
        public String publishedAt;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }
}
