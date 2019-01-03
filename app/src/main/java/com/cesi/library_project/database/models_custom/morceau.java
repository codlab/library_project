package com.cesi.library_project.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class morceau {


    @PrimaryKey(autoIncrement = true)
    private long id_morceau;
    private String lib_morceau;

    public long getLib_morceau() {
        return lib_morceau;
    }

    public void setLib_morceau(long lib_morceau) {
        this.lib_morceau = lib_morceau;
    }
    public long getId_morceau() {
        return id_morceau;
    }

    public void setId_morceau(long id_morceau) {
        this.id_morceau = id_morceau;
    }


}
