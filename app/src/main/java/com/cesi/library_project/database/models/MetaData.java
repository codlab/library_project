package com.cesi.library_project.database.models;

import java.util.Date;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

/**
 * Created by Dominique H on 05/02/2018.
 */

public class MetaData {

    @PrimaryKey(autoIncrement =  true)
    private long id;

    private String title;

    private int note;

    private String origin;

    private String comment;

    private Date release;

    private int status;


    public MetaData() {

    }

    public MetaData(String title, int note, String origin, String comment, Date release, int status) {

        this.title = title;
        this.note = note;
        this.origin = origin;
        this.comment = comment;
        this.release = release;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public Status getStatus() {
        return Status.from(status);
    }

    public void setStatus(Status status) {
        this.status = status.ordinal();
    }
}
