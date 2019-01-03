package com.cesi.customProject.database.db;

import com.cesi.customProject.database.controllers.ModelController;
import com.cesi.customProject.database.models_custom.Categorie;
import com.cesi.customProject.database.models_custom.Oeuvre;
import sun.jvm.hotspot.opto.HaltNode;

import java.util.HashMap;

public class ProjectDataBase {
    private static HashMap<Class, ModelController> CONTROLLERS = new HashMap<> ();
    private ProjectDataBase(){

    }

    public static void set(Class klass){
        CONTROLLERS.put(klass new ModelController<> (klass));
    }

    public static ModelController<MODEL_CLASS> get(Class<MODEL_CLASS> klass){
        return CONTROLLERS.get(klass);
    }

    public static void init(){
        set(Categorie.class);
        set(Oeuvre.class);
    }
}
