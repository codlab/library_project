package com.cesi.library_project.database.models_custom;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.IIdSetter;
import com.cesi.library_project.database.models.MetaData;
import com.cesi.library_project.utils.categories.ICategory;
import org.jetbrains.annotations.NotNull;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Genre {

    @PrimaryKey(autoIncrement = true)
    private long id_genre;

    public Genre(String lib_genre) {
        this.lib_genre = lib_genre;
    }


    private String lib_genre;

    public long getId_g() {
        return id_genre;
    }

    public void setId_g(long id_g) {
        this.id_genre = id_g;
    }

     public long getLib_g() {
        return lib_genre;
    }

    public void setLib_g(String lib_g) {
        this.lib_genre = lib_g;
    }



}