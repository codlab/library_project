package com.cesi.customProject.database.controllers;

import com.cesi.customProject.database.models_custom.Categorie;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.util.List;

public class ModelController<MODEL_CLASS> {

    private Class<MODEL_CLASS> klass;

    private ModelController() {

    }

    public ModelController(Class<MODEL_CLASS> klass) {
        this();
        this.klass = klass;
    }
//Categorie

    public MODEL_CLASS create(){
        return null;
    }


    public MODEL_CLASS read(long id){
        return null;

    }

    public List<MODEL_CLASS> read(){
        return null;
    }

    public void update(MODEL_CLASS categorie){
    }

    public void delete(MODEL_CLASS categorie){
    }

    public ObjectModel<MODEL_CLASS>

}
