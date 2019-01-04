package com.cesi.lighter_custom.database.models;

import com.cesi.lighter_custom.database.db.ProjectDatabase;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

/**
 * Simple assoc. table to match given Categories and Oeuvres
 *
 * Note that it does not use the @ForeignKey that the library provides (for now)
 * to retrieve a given oeuvre or category, it simply uses the singleton holder to fetch the relevant value
 *
 * We'll work on use the ForeignKey pattern later
 */
public class OeuvreCategory implements Model {

    //since we have a simple assoc. table, we do not need a pkey id
    //but to make thing easier to implement, we have it, just to help
    @PrimaryKey(autoIncrement = true)
    private long id;

    public long id_oeuvre;
    public long id_category;

    public OeuvreCategory(Oeuvre oeuvre, Category category) {
        this.id_oeuvre = oeuvre.getId();
        this.id_category = category.getId();
    }

    public Category getGenre() {
        return ProjectDatabase.get(Category.class).read(id_oeuvre);
    }

    public Oeuvre getOeuvre() {
        return ProjectDatabase.get(Oeuvre.class).read(id_oeuvre);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
