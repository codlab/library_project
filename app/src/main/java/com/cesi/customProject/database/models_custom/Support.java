package com.cesi.customProject.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Support  {

    @PrimaryKey(autoIncrement = true)
    private long id_support;

    public Support(String lib_support) {
        this.lib_support = lib_support;
    }

    private String lib_support;

    public long getId_s() {
        return id_support;
    }

    public void setId_s(long id_support) {
        this.id_support = id_support;
    }


    public String getLib_support() {
        return lib_support;
    }

    public void setLib_support(String lib_support) {
        this.lib_support = lib_support;
    }


}
