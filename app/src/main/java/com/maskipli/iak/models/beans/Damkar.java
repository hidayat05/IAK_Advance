package com.maskipli.iak.models.beans;

import java.util.List;

/**
 * @author hidayat
 * @since 5/21/17.
 */

public class Damkar {

    public String status;
    public int count;
    public String Dinas;
    public List<Data> data;

    public static class Data {
        public int userid;
        public String nama;
        public String phone;
        public double lat;
        public double lng;
        public String login_terakhir;
        public String wilayah;
        public String alamat;
        public String jabatan;
    }
}
