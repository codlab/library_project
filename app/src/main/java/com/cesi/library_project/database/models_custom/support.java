package com.cesi.library_project.database.models_custom;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.IIdSetter;
import com.cesi.library_project.database.models.MetaData;
import com.cesi.library_project.utils.categories.ICategory;
import org.jetbrains.annotations.NotNull;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class support implements IIdSetter, ICategory {

    @PrimaryKey(autoIncrement = true)
    private long id_s;
    private String lib_s;

    public long getId_s() {
        return id_s;
    }

    public void setId_s(long id_s) {
        this.id_s = id_s;
    }


    public long getLib_s() {
        return lib_s;
    }

    public void setLib_s(long lib_s) {
        this.lib_s = lib_s;
    }


}
