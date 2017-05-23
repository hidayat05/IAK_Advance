package com.maskipli.iak.models.beans;

import java.util.List;

/**
 * @author nurhidayat
 * @since 5/23/17.
 */

public class Source {

    public String status;
    public List<Sources> sources;

    public static class UrlsToLogos {
        public String small;
        public String medium;
        public String large;
    }

    public static class Sources {
        public String id;
        public String name;
        public String description;
        public String url;
        public String category;
        public String language;
        public String country;
        public UrlsToLogos urlsToLogos;
        public List<String> sortBysAvailable;
    }
}
