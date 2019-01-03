package com.cesi.library_project.database.models_custom;

public class MetaData {

    private meta_data_id()

    private String titre;

    private String note;

    private String origine;

    private DATETIME date_acguisition;

    private DATETIME sortie_officiel;

    private String commentaire;

    private enum status;

    private String genre;

    public meta_data(){

    }

    public meta_data(String sometext){
        this;

        titre = sometext;
    }
}