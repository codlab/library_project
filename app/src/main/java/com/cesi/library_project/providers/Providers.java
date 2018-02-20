package com.cesi.library_project.providers;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.IIdSetter;

import java.util.HashMap;

public class Providers<MODEL extends IIdSetter> {

    private Providers() {

    }

    public static final CategoryProvider CATEGORY_PROVIDER = new CategoryProvider();
}
