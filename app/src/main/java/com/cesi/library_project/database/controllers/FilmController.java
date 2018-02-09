package com.cesi.library_project.database.controllers;

import com.cesi.library_project.database.db.LibraryDatabase;
import com.cesi.library_project.database.models.Film;
import com.sun.istack.internal.NotNull;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public class FilmController extends AbstractController<Film> {
    private static final FilmController CATEGORY_CONTROLLER = new FilmController();

    public static FilmController getInstance() {
        return CATEGORY_CONTROLLER;
    }

    private FilmController() {
        super();
    }

    @NotNull
    @Override
    protected Class<Film> getModelClass() {
        return Film.class;
    }

    @Override
    protected ObjectModel<Film, ResultSet, HashMap<String, Object>> createJDBCObject(LibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        return new JdbcObjectModel<Film>(instance) {
        };
    }
}
