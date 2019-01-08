package com.cesi.lighter_custom.database.db;

import com.cesi.lighter_custom.database.controllers.jdbc.CategoryJDBCProvider;
import com.cesi.lighter_custom.database.controllers.jdbc.OeuvreJDBCProvider;
import com.cesi.lighter_custom.database.models.Category;
import com.cesi.lighter_custom.database.models.Oeuvre;

public class ProjectDatabase extends InternalProjectDatabase {

    private final static ProjectDatabase INSTANCE = new ProjectDatabase();

    public static ProjectDatabase getInstance() {
        return INSTANCE;
    }

    private ProjectDatabase() {
        super();
    }

    public void init() {
        set(Category.class, new CategoryJDBCProvider());
        set(Oeuvre.class, new OeuvreJDBCProvider());
        //set(OeuvreCategory.class, new OeuvreCategoryJDBCProvider());

        open();
    }
}
