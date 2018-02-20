package com.cesi.library_project.providers;

import com.cesi.library_project.database.controllers.AbstractController;
import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.providers.ui.category.CategoryThumbnail;

public class CategoryProvider extends AbstractProvider<Category, CategoryThumbnail, CategoryController> {

    public CategoryProvider() {
        super();
    }

    @Override
    protected CategoryController createController() {
        return CategoryController.getInstance();
    }

    @Override
    public CategoryThumbnail getThumbnailProvider(Category object) {
        return new CategoryThumbnail(object);
    }

    @Override
    public CategoryThumbnail getPageProvider(Category object) {
        return null;
    }
}
