package com.cesi.customProject.database.models_custom;

import com.cesi.library_project.database.models.IIdSetter;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Date;

public class Oeuvre implements IIdSetter {

    @PrimaryKey(autoIncrement = true)
    private long id_o;

    private String titre_o;

    private int termine_o;

    private int note_o;

    private String comment_o;

    private Date date_acq_o;

    private String duree_o;

    private int nb_pages_o;

    private int id_genre;

    private int id_support;

    private int id_orig;

    private int id_console;

    private int id_cat;

    public Oeuvre() {

    }

    public Oeuvre(String titre_o,
                  int termine_o,
                  int note_o,
                  String comment_o,
                  Date date_acq_o,
                  String duree_o,
                  int nb_pages_o,
                  int id_genre,
                  int id_s,
                  int id_orig,
                  int id_console,
                  int id_cat) {
        setTitre_o(titre_o);
        setTermine_o(termine_o);
        setNote_o(note_o);
        setComment_o(comment_o);
        setDate_acq_o(date_acq_o);
        setDuree_o(duree_o);
        setNb_pages_o(nb_pages_o);
        setId_genre ( id_genre );
        setId_support (id_s);
        setId_orig(id_orig);
        setId_console(id_console);
        setId_cat(id_cat);
    }

    @Override
    public void setId(long id) {
        this.id_o = id;
    }

    @Override
    public long getId() {
        return id_o;
    }

    @Override
    public Object[] toArray() {
        return new Object[]{
                getTitre_o(),
                getTermine_o(),
                getNote_o(),
                getComment_o(),
                getDate_acq_o(),
                getDuree_o(),
                getNb_pages_o(),
                getId_genre (),
                getId_support (),
                getId_orig(),
                getId_console(),
                getId_cat(),

        };
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {
                "titre_o",
                "termine_o",
                "note_o",
                "comment_o",
                "date_acq_o",
                "duree_o",
                "nb_pages_o",
                "id_genre",
                "id_support",
                "id_orig",
                "id_console",
                "id_cat"
        };
    }

    public void setId_o(long id_o) {
        this.id_o = id_o;
    }

    public String getTitre_o() {
        return titre_o;
    }

    public void setTitre_o(String titre_o) {
        this.titre_o = titre_o;
    }

    public int getTermine_o() {
        return termine_o;
    }

    public void setTermine_o(int termine_o) {
        this.termine_o = termine_o;
    }

    public int getNote_o() {
        return note_o;
    }

    public void setNote_o(int note_o) {
        this.note_o = note_o;
    }

    public String getComment_o() {
        return comment_o;
    }

    public void setComment_o(String comment_o) {
        this.comment_o = comment_o;
    }

    public Date getDate_acq_o() {
        return date_acq_o;
    }

    public void setDate_acq_o(Date date_acq_o) {
        this.date_acq_o = date_acq_o;
    }

    public String getDuree_o() {
        return duree_o;
    }

    public void setDuree_o(String duree_o) {
        this.duree_o = duree_o;
    }

    public int getNb_pages_o() {
        return nb_pages_o;
    }

    public void setNb_pages_o(int nb_pages_o) {
        this.nb_pages_o = nb_pages_o;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) { this.id_genre = id_genre; }

    public int getId_support() {
        return id_support;
    }

    public void setId_support(int id_support) { this.id_support = id_support; }

    public int getId_orig() {
        return id_orig;
    }

    public void setId_orig(int id_orig) { this.id_orig = id_orig; }

    public int getId_console() {
        return id_console;
    }

    public void setId_console(int id_console) { this.id_console = id_console; }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) { this.id_cat = id_cat; }

}




