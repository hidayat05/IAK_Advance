package com.maskipli.iak.models.beans;

import java.util.List;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class Puskesmas {

    public String status;
    public int count;
    public List<Data> data;

    public static class Location {
        public String alamat;
        public double latitude;
        public double longitude;
    }

    public static class Data {
        public int id;
        public String nama_Puskesmas;
        public Location location;
        public List<String> telepon;
        public List<String> faximile;
        public String email;
        public String kepala_puskesmas;
        public int kode_kota;
        public int kode_kecamatan;
        public String kode_kelurahan;
    }
}
