package com.cesi.library_project.database.models_custom;

public class Personne{

    private int personne_id;

    private String personne_prenom;

    private String personne_nom;

    private String nationalite;

    private String metier;

    public Personne(String sometext){
        this;

        personne_prenom = sometext;
    }
}
