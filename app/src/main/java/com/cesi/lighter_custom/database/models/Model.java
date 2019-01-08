package com.cesi.lighter_custom.database.models;

/**
 * This interface is used to help the ModelController to be used with this to set or get the id of any model
 */
public class Model {

    public long id;

    final public long getId() {
        return id;
    }

    final public void setId(long id) {
        this.id = id;
    }
}
