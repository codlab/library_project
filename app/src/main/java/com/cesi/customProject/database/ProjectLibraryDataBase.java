package com.cesi.customProject.database;

import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.ObjectModelColumn;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.sql.SQLException;
import java.util.HashMap;

public class ProjectLibraryDataBase extends DatabaseModel {
    public ProjectLibraryDataBase(Object... args) throws SQLException, ClassNotFoundException, NoSuchFieldException {
        super ( args );
    }

    @Override
    public ObjectModel onCreateDatabaseInfoModel() throws ClassNotFoundException, NoSuchFieldException {
        return new JdbcObjectModel (this) {};
    }

    @Override
    protected DatabaseDriverInterface onInitializeDatabaseDriverInterface(Object... objects) {
        return new JdbcSqliteDatabaseDriverInterface (  this);
    }

    @Override
    public String getDatabaseName() {
        return "projet_java";
    }

    @Override
    public int getDatabaseVersion() {
        return 0;
    }

    @Override
    protected void onInsertDefaultValues() {

    }

    @Override
    protected void onRegisterObjectModels(HashMap hashMap) throws ClassNotFoundException, NoSuchFieldException {

    }
}
