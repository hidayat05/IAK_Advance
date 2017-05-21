package com.maskipli.iak.models.beans;

import java.util.List;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class Tps {

    public List<Data> data;
    public Meta meta;

    public static class Location {
        public int alamat;
        public double latitude;
        public double longitude;
    }

    public static class Data {
        public int id;
        public String nama_tps;
        public int kode_kota;
        public int kode_kecamatan;
        public String kode_kelurahan;
        public Location location;
    }

    public static class Links {
        public String next;
    }

    public static class Pagination {
        public int total;
        public int count;
        public int per_page;
        public int current_page;
        public int total_pages;
        public Links links;
    }

    public static class Meta {
        public Pagination pagination;
    }
}
