package com.cesi.customProject.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Metier {
    @PrimaryKey(autoIncrement = true)
    private long id_metier;

    public Metier(String lib_metier) {
        this.lib_metier = lib_metier;
    }

    private String lib_metier;


    public long getId_metier() {
        return id_metier;
    }

    public void setId_metier(long id_metier) {
        this.id_metier = id_metier;
    }


    public String getLib_m() {
        return lib_metier;
    }

    public void setLib_m(String lib_metier) {
        this.lib_metier = lib_metier;
    }


}
