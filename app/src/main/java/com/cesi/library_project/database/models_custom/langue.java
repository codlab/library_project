package com.cesi.library_project.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class langue {

    @PrimaryKey(autoIncrement = true)
    private String lib_l;
    private long id_l;

    public long getId_l() {
        return id_l;
    }

    public void setId_l(long id_l) {
        this.id_l = id_l;
    }

    public long getLib_l() {
        return lib_l;
    }

    public void setLib_l(long lib_l) {
        this.lib_l = lib_l;
    }


}
}
