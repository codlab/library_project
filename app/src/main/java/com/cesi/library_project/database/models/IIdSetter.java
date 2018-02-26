package com.cesi.library_project.database.models;

import org.netbeans.api.annotations.common.NonNull;

public interface IIdSetter {

    void setId(long id);

    long getId();

    @NonNull
    Object[] toArray();

    @NonNull
    String[] getColumnNames();
}
