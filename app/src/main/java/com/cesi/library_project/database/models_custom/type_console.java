package com.cesi.library_project.database.models_custom;

import com.cesi.library_project.database.models.MetaData;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class type_console {

    @PrimaryKey(autoIncrement = true)
    private String lib_console
    private long id_console;

    public long getId_console() {
        return id_console;
    }

    public void setId_console(long id_console) {
        this.id_console = id_console;
    }


    public long getLib_console() {
        return lib_console;
    }

    public void setLib_console(long lib_console) {
        this.lib_console = lib_console;
    }

    ;

}
