package com.cesi.library_project.database.models;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Category implements IIdSetter {

    @PrimaryKey(autoIncrement = true)
    private long id;

    private String name;

    public Category() {

    }

    public Category(String name) {
        this();

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
