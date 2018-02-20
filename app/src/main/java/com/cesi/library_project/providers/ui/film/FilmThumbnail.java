package com.cesi.library_project.providers.ui.film;

import com.cesi.library_project.database.models.Film;
import com.cesi.library_project.providers.ui.AbstractComponentProvider;
import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FilmThumbnail extends AbstractComponentProvider<Film> {

    public FilmThumbnail(Film object) {
        super(object);
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return null;
    }

    @Override
    public void implement(@NotNull Composite composite) {

    }

    @Override
    public void dispose() {

    }
}
