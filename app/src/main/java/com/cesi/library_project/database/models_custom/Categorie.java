package com.cesi.library_project.database.models_custom;

import org.jetbrains.annotations.NotNull;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Categorie implements id_cat, lib_cat {

    @PrimaryKey(autoIncrement = true)
    private long id_cat;

    private String icon;

    private String lib_cat;

    private boolean erasable;

    public Categorie() {
        erasable = false;
    }

    public Categorie(String lib_cat, String icon, boolean erasable) {
        this();

        this.icon = icon;
        this.erasable = erasable;
        this.lib_cat = lib_cat;
    }

    public boolean isErasable() {
        return erasable;
    }

    @NotNull
    @Override
    public String getLib_cat() {
        return lib_cat;
    }

    @NotNull
    @Override
    public String getIcon() {
        return icon != null ? icon : "";
    }

    @Override
    public void setId_cat(long id_cat) {
        this.id_cat = id_cat;
    }

    public long getId_cat() {
        return id_cat;
    }

    @Override
    public Object[] toArray() {
        return new Object[]{
                icon,
                lib_cat,
        };
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {
                "icon",
                "lib_cat",
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Categorie) {
            return id_cat == ((Categorie) obj).id_cat;
        }
        return super.equals(obj);
    }

}

