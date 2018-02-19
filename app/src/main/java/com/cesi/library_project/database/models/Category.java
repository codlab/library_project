package com.cesi.library_project.database.models;

import com.cesi.library_project.utils.categories.ICategory;
import org.jetbrains.annotations.NotNull;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Category implements IIdSetter, ICategory {

    @PrimaryKey(autoIncrement = true)
    private long id;

    private String icon;

    private String name;

    private boolean erasable;

    public Category() {
        erasable = false;
    }

    public Category(String name, String icon, boolean erasable) {
        this();

        this.icon = icon;
        this.erasable = erasable;
        this.name = name;
    }

    public boolean isErasable() {
        return erasable;
    }

    public String getName() {
        return name;
    }


    @NotNull
    @Override
    public String getIcon() {
        return icon != null ? icon : "";
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Category) {
            return id == ((Category) obj).id;
        }
        return super.equals(obj);
    }
}
