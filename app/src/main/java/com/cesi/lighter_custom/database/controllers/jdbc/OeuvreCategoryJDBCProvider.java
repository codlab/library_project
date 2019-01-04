package com.cesi.lighter_custom.database.controllers.jdbc;

import com.cesi.lighter_custom.database.controllers.AbstractModelJDBCProvider;
import com.cesi.lighter_custom.database.db.ProjectLibraryDatabase;
import com.cesi.lighter_custom.database.models.Oeuvre;
import com.cesi.lighter_custom.database.models.OeuvreCategory;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public class OeuvreCategoryJDBCProvider extends AbstractModelJDBCProvider<OeuvreCategory> {

    @Override
    public ObjectModel<OeuvreCategory, ResultSet, HashMap<String, Object>> createJDBCObject(ProjectLibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        return new JdbcObjectModel<>(instance) {
        };
    }
}
