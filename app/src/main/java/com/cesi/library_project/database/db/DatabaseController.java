package com.cesi.library_project.database.db;

import com.cesi.library_project.database.controllers.AbstractController;
import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.controllers.FilmController;
import com.cesi.library_project.database.controllers.MetaDataController;

import java.sql.SQLException;

public class DatabaseController {
    private static DatabaseController DATABASE = new DatabaseController();
    private LibraryDatabase mDatabase;

    private final static AbstractController[] CONTROLLERS = new AbstractController[] {
            MetaDataController.getInstance(),
            CategoryController.getInstance(),
            FilmController.getInstance()
    };

    public static DatabaseController getInstance() {
        return DATABASE;
    }

    private DatabaseController() {

    }

    public void open() {
        try {
            mDatabase = new LibraryDatabase();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        open();

        //call every controller init();
        for (AbstractController controller : CONTROLLERS) {
            controller.init(mDatabase);
        }
    }
}
