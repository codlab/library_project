package com.cesi.library_project.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Morceau {


    @PrimaryKey(autoIncrement = true)
    private long id_morceau;

    public Morceau(String lib_morceau) {
        this.lib_morceau = lib_morceau;
    }

    private String lib_morceau;

    public long getLib_morceau() {
        return lib_morceau;
    }

    public void setLib_morceau(String lib_morceau) {
        this.lib_morceau = lib_morceau;
    }
    public long getId_morceau() {
        return id_morceau;
    }

    public void setId_morceau(long id_morceau) {
        this.id_morceau = id_morceau;
    }


}
