package com.skripsi.android.publikasi;

/**
 * Created by Harits on 3/18/2018.
 */

public class Publikasi {
    private String judul;
    private int cover;
    private String noKatalog;
    private String noPublikasi;
    private String tanggalRilis;
    private String ukuranFile;

    public Publikasi(String judul, int cover, String noKatalog, String noPublikasi, String tanggalRilis, String ukuranFile) {
        this.judul = judul;
        this.cover = cover;
        this.noKatalog = noKatalog;
        this.noPublikasi = noPublikasi;
        this.tanggalRilis = tanggalRilis;
        this.ukuranFile = ukuranFile;
    }

    public Publikasi() {
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

    public String getNoKatalog() {
        return noKatalog;
    }

    public void setNoKatalog(String noKatalog) {
        this.noKatalog = noKatalog;
    }

    public String getNoPublikasi() {
        return noPublikasi;
    }

    public void setNoPublikasi(String noPublikasi) {
        this.noPublikasi = noPublikasi;
    }

    public String getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    public String getUkuranFile() {
        return ukuranFile;
    }

    public void setUkuranFile(String ukuranFile) {
        this.ukuranFile = ukuranFile;
    }
}
