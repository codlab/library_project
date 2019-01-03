package com.cesi.library_project.database.models_custom;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Personne {
    @PrimaryKey(autoIncrement = true)
    private long id_personne;

    public Personne(String lib_personne) {
        this.lib_personne = lib_personne;
    }

    private String lib_personne;


    public long getId_personne() {
        return id_personne;
    }

    public void setId_personne(long id_personne) {
        this.id_personne = id_personne;
    }


    public long getLib_personne() {
        return lib_personne;
    }

    public void setLib_personne(String lib_personne) {
        this.lib_personne = lib_personne;
    }




}
