package com.cesi.library_project.database.models_custom;

import com.cesi.library_project.database.models.MetaData;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Exercer {
    @PrimaryKey(autoIncrement = true)
    private long id_s;

    private String lib_s;

    @ForeignKey(table = "MetaData", column = "meta_data_id", childReference = "meta_data")
    private long meta_data_id;

    private MetaData meta_data;
}
