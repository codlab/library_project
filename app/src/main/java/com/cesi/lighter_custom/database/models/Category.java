package com.cesi.lighter_custom.database.models;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

/**
 * How to retrieve a ModelController from the instantiated database
 *  ModelController<a class type> controller = ProjectDatabase.getInstance().get(a class);
 */
public class Category implements Model {

    @PrimaryKey(autoIncrement = true)
    public long id;

    public String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
