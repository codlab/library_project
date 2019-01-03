package com.cesi.library_project.database.models_custom;

import com.cesi.library_project.database.models.MetaData;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class origine {
    @PrimaryKey(autoIncrement = true)
    private long id_o;
    private String lib_o;

    public long getId_o() {
        return id_o;
    }

    public void setId_o(long id_o) {
        this.id_o = id_o;
    }


    public long getLib_o() {
        return lib_o;
    }

    public void setLib_o(long lib_o) {
        this.lib_o = lib_o;
    }




}