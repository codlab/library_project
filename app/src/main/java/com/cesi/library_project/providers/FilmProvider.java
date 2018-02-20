package com.cesi.library_project.providers;

import com.cesi.library_project.database.controllers.FilmController;
import com.cesi.library_project.database.models.Film;
import com.cesi.library_project.providers.ui.film.FilmThumbnail;

public class FilmProvider extends AbstractProvider<Film, FilmThumbnail, FilmController>{
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
}
