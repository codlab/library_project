package com.cesi.lighter_custom.database.models;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Category implements Model {
    @PrimaryKey(autoIncrement = true)
    private long id;

    private String name;

    public Category() {
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
