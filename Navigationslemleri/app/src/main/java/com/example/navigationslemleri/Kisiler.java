package com.example.navigationslemleri;

import java.io.Serializable;

public class Kisiler implements Serializable {
    private String kisi_isim;
    private int kisi_numara;
    private float kisi_boy;

    public Kisiler() {
    }

    public Kisiler(String kisi_isim, int kisi_numara, float kisi_boy) {
        this.kisi_isim = kisi_isim;
        this.kisi_numara = kisi_numara;
        this.kisi_boy = kisi_boy;
    }

    public String getKisi_isim() {
        return kisi_isim;
    }

    public void setKisi_isim(String kisi_isim) {
        this.kisi_isim = kisi_isim;
    }

    public int getKisi_numara() {
        return kisi_numara;
    }

    public void setKisi_numara(int kisi_numara) {
        this.kisi_numara = kisi_numara;
    }

    public float getKisi_boy() {
        return kisi_boy;
    }

    public void setKisi_boy(float kisi_boy) {
        this.kisi_boy = kisi_boy;
    }
}
