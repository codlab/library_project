package com.cesi.library_project.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class metier {
    @PrimaryKey(autoIncrement = true)
    private long id_m;
    private String lib_m;

    public long getId_m() {
        return id_m;
    }

    public void setId_m(long id_m) {
        this.id_m = id_m;
    }


    public long getLib_m() {
        return lib_m;
    }

    public void setLib_m(long lib_m) {
        this.lib_m = lib_m;
    }


}
