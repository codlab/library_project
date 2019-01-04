package com.cesi.lighter_custom.database.models;

import com.cesi.lighter_custom.database.controllers.ModelController;
import com.cesi.lighter_custom.database.db.ProjectDatabase;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

public class Oeuvre implements Model {
    @PrimaryKey(autoIncrement = true)
    public long id;

    public String name;

    public List<OeuvreCategory> categories = new ArrayList<>();

    public List<Category> getCategories() {
        List<Category> genres = new ArrayList<>();

        //an improvement here could be to use maps
        //return categories.map( holder -> holder.getGenre() );
        for (OeuvreCategory holder : categories) {
            genres.add(holder.getGenre());
        }

        return genres;
    }

    public void addCategory(Category genre) {
        ModelController<OeuvreCategory> controller = ProjectDatabase.get(OeuvreCategory.class);
        OeuvreCategory holder = controller.create(new OeuvreCategory(this, genre));
        controller.update(holder);

        categories.add(holder);
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
