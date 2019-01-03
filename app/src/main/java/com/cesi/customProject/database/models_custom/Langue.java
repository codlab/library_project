package com.cesi.customProject.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Langue {

    @PrimaryKey(autoIncrement = true)
    private String lib_langue;

    public Langue(String lib_langue) {
        this.lib_langue = lib_langue;
    }

    private long id_langue;

    public long getId_langue() {
        return id_langue;
    }

    public void setId_langue(long id_langue) {
        this.id_langue = id_langue;
    }

    public String getLib_langue() {
        return lib_langue;
    }

    public void setLib_langue(String lib_langue) {
        this.lib_langue = lib_langue;
    }


}

