package com.cesi.library_project.database.models_custom;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.IIdSetter;
import com.cesi.library_project.database.models.MetaData;
import com.cesi.library_project.utils.categories.ICategory;
import org.jetbrains.annotations.NotNull;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class genre  {

    @PrimaryKey(autoIncrement = true)
    private long id_g;
    private String lib_g;

    public long getId_g() {
        return id_g;
    }

    public void setId_g(long id_g) {
        this.id_g = id_g;
    }

     public long getLib_g() {
        return lib_g;
    }

    public void setLib_g(long lib_g) {
        this.lib_g = lib_g;
    }



}