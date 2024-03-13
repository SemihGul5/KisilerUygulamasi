package com.abrebo.kisiler.data.entity;

import java.io.Serializable;

public class Kisiler implements Serializable {
    private int id;
    private String ad;
    private String tel;

    public Kisiler() {
    }

    public Kisiler(int id, String ad, String tel) {
        this.id = id;
        this.ad = ad;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
