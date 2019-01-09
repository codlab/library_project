package com.cesi.lighter_custom.database.models;

import com.cesi.lighter_custom.database.controllers.ModelController;
import com.cesi.lighter_custom.database.db.ProjectDatabase;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Date;

/**
 * How to retrieve a ModelController from the instantiated database
 * ModelController<a class type> controller = ProjectDatabase.getInstance().get(a class);
 */
public class Oeuvre implements Model {

    @PrimaryKey(autoIncrement = true)
    public long id;

    public String titre;

    public Date date_creation;

    public Date date_ajout;

    public boolean etat;

    public String origine;

    public long category_id;

    public Oeuvre() {
    }

    public Oeuvre(String titre,
                  Date date_creation,
                  Date date_ajout,
                  boolean etat,
                  String origine,
                  Category category) {
        this.titre = titre;
        this.date_creation = date_creation;
        this.date_ajout = date_ajout;
        this.etat = etat;
        this.origine = origine;
        this.category_id = category.getId();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre.trim();
    }

    public Date getDateCreation() {
        return date_creation;
    }

    public void setDateCreation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDateAjout() {
        return date_ajout;
    }

    public void setDateAjout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        //ProjectDatabase.getInstance()
        ProjectDatabase projectDatabase = ProjectDatabase.getInstance();
        ModelController<Category> modelController = projectDatabase.get(Category.class);

        return modelController.read(category_id);
    }

    public void setCategory(Category category) {
        category_id = category.getId();
    }
}
