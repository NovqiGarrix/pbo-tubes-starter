package com.example.praktikum_gui.entity;

import java.sql.Date;
import java.time.LocalDate;

public class User {

    public int id;

    private String nama;

    private String jk;

    private String email;

    private String noHp;

    private Date tglLahir;

    private String kategoriTiket;

    private int jlhTiket;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getKategoriTiket() {
        return kategoriTiket;
    }

    public void setKategoriTiket(String kategoriTiket) {
        this.kategoriTiket = kategoriTiket;
    }

    public int getJlhTiket() {
        return jlhTiket;
    }

    public void setJlhTiket(int jlhTiket) {
        this.jlhTiket = jlhTiket;
    }
}
