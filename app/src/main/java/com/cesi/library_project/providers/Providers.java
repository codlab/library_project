package com.cesi.library_project.providers;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.Film;
import com.cesi.library_project.database.models.IIdSetter;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class Providers<MODEL extends IIdSetter> {

    private Providers() {

    }

    public static final CategoryProvider CATEGORY_PROVIDER = new CategoryProvider();

    public static final FilmProvider FILM_PROVIDER = new FilmProvider();

    @Nullable
    public static AbstractProvider getProvider(String klass) {
        if(Film.class.getSimpleName().equals(klass)) {
            return FILM_PROVIDER;
        }
        return null;
    }
}
