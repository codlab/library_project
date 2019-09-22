package com.cesi.customProject.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Origine {
    @PrimaryKey(autoIncrement = true)
    private long id_origine;

    public Origine(String lib_origine) {
        this.lib_origine = lib_origine;
    }

    private String lib_origine;

    public long getId_origine() {
        return id_origine;
    }

    public void setId_origine(long id_origine) {
        this.id_origine = id_origine;
    }


    public String getLib_o() {
        return lib_origine;
    }


    public void setLib_o(String lib_origine) {
        this.lib_origine = lib_origine;
    }




}