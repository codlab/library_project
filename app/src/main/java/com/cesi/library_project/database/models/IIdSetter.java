package com.cesi.library_project.database.models;

public interface IIdSetter {

    void setId(long id);

    long getId();

    Object[] toArray();
}
