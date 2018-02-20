package com.cesi.library_project.providers;

import com.cesi.library_project.database.controllers.FilmController;
import com.cesi.library_project.database.models.Film;
import com.cesi.library_project.providers.ui.film.FilmThumbnail;


//TODO create FilmForm and replace in modify/create
public class FilmProvider extends AbstractProvider<Film, FilmThumbnail, FilmController, FilmThumbnail>{
    @Override
    protected FilmController createController() {
        return FilmController.getInstance();
    }

    @Override
    public FilmThumbnail getThumbnailProvider(Film object) {
        return new FilmThumbnail(object);
    }

    @Override
    public FilmThumbnail getPageProvider(Film object) {
        return null;
    }

    @Override
    public FilmThumbnail modifyObject(Film object) {
        return null;
    }

    @Override
    public FilmThumbnail createObject() {
        return null;
    }
}
