package com.cesi.library_project.database.models_custom;

import com.cesi.library_project.database.models.MetaData;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class personne {
    @PrimaryKey(autoIncrement = true)
    private long id_p;
    private String lib_p;

    public long getId_p() {
        return id_p;
    }

    public void setId_p(long id_p) {
        this.id_p = id_p;
    }


    public long getLib_p() {
        return lib_p;
    }

    public void setLib_p(long lib_p) {
        this.lib_p = lib_p;
    }




}
