package com.iman.inc.sqlitetes;

/**
 * Created by z on 23/03/18.
 */

public class ModelIdentitas {
    public int id ;
    public String nama ;
    public int umur ;
    public String golonganDarah ;

    public ModelIdentitas(String nama, int umur, String golonganDarah) {
        this.nama = nama;
        this.umur = umur;
        this.golonganDarah = golonganDarah;
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

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }
}
