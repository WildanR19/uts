package com.wildan.uts;

import java.io.Serializable;

public class Anggrek implements Serializable {

    private String Judul;
    private double harga;

    public Anggrek(String Judul,double harga){
        this.Judul=Judul;
        this.harga=harga;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

