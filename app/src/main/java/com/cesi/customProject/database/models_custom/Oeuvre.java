package com.cesi.customProject.database.models_custom;

import com.cesi.library_project.database.models.IIdSetter;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Date;

public class Oeuvre implements IIdSetter {

    @PrimaryKey(autoIncrement = true)
    private long id_oeuvre;

    private String titre_oeuvre;

    private int termine_oeuvre;

    private int note_oeuvre;

    private String comment_oeuvre;

    private Date date_acq_oeuvre;

    private String duree_oeuvre;

    private int nb_pages_oeuvre;


    public Oeuvre() {

    }

    public Oeuvre(String titre_oeuvre,
                  int termine_oeuvre,
                  int note_oeuvre,
                  String comment_oeuvre,
                  Date date_acq_oeuvre,
                  String duree_oeuvre,
                  int nb_pages_oeuvre) {
        setTitre_oeuvre ( titre_oeuvre );
        setTermine_o(termine_oeuvre);
        setNote_oeuvre ( note_oeuvre );
        setComment_oeuvre ( comment_oeuvre );
        setDate_acq_oeuvre ( date_acq_oeuvre );
        setDuree_oeuvre ( duree_oeuvre );
        setNb_pages_oeuvre ( nb_pages_oeuvre );

    }

    @Override
    public void setId(long id) {
        this.id_oeuvre = id;
    }

    @Override
    public long getId() {
        return id_oeuvre;
    }

    @Override
    public Object[] toArray() {
        return new Object[]{
                getTitre_oeuvre (),
                getTermine_oeuvre(),
                getNote_oeuvre (),
                getComment_oeuvre (),
                getDate_acq_oeuvre (),
                getDuree_oeuvre (),
                getNb_pages_oeuvre (),
        };
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {
                "titre_oeuvre",
                "termine_oeuvre",
                "note_oeuvre",
                "comment_oeuvre",
                "date_acq_oeuvre",
                "duree_oeuvre",
                "nb_pages_oeuvre",

        };
    }

    public void setId_oeuvre(long id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public String getTitre_oeuvre() {
        return titre_oeuvre;
    }

    public void setTitre_oeuvre(String titre_oeuvre) {
        this.titre_oeuvre = titre_oeuvre;
    }

    public int getTermine_oeuvre() {
        return termine_oeuvre;
    }

    public void setTermine_o(int termine_o) {
        this.termine_oeuvre = termine_o;
    }

    public int getNote_oeuvre() {
        return note_oeuvre;
    }

    public void setNote_oeuvre(int note_oeuvre) {
        this.note_oeuvre = note_oeuvre;
    }

    public String getComment_oeuvre() {
        return comment_oeuvre;
    }

    public void setComment_oeuvre(String comment_oeuvre) {
        this.comment_oeuvre = comment_oeuvre;
    }

    public Date getDate_acq_oeuvre() {
        return date_acq_oeuvre;
    }

    public void setDate_acq_oeuvre(Date date_acq_oeuvre) {
        this.date_acq_oeuvre = date_acq_oeuvre;
    }

    public String getDuree_oeuvre() {
        return duree_oeuvre;
    }

    public void setDuree_oeuvre(String duree_oeuvre) {
        this.duree_oeuvre = duree_oeuvre;
    }

    public int getNb_pages_oeuvre() {
        return nb_pages_oeuvre;
    }

    public void setNb_pages_oeuvre(int nb_pages_oeuvre) {
        this.nb_pages_oeuvre = nb_pages_oeuvre;
    }


}




