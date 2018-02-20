package com.cesi.library_project.providers;

import com.cesi.library_project.database.controllers.AbstractController;
import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.IIdSetter;
import com.cesi.library_project.providers.ui.AbstractComponentProvider;
import com.cesi.library_project.providers.ui.category.CategoryThumbnail;

//TODO create CategoryForm and replace in modify/create
public class CategoryProvider extends AbstractProvider<Category, CategoryThumbnail, CategoryController, CategoryThumbnail> {

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

    @Override
    public CategoryThumbnail modifyObject(Category object) {
        return null;
    }

    @Override
    public CategoryThumbnail createObject() {
        return null;
    }
}
