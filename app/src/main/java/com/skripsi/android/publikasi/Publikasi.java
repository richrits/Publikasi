package com.skripsi.android.publikasi;

/**
 * Created by Harits on 3/18/2018.
 */

public class Publikasi {
    private String judul;
    private int cover;

    public Publikasi() {
    }

    public Publikasi(String judul, int cover) {
        this.judul = judul;
        this.cover = cover;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
