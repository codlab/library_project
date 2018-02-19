package com.cesi.library_project.ui.test;

import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.content.MainContent;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.ui.menu.CategoryMenu;
import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TestScreen implements IComponentProvider, ICategoryClicked {

    private CategoryMenu mMenu;
    private MainContent mMainContent;

    public TestScreen() {

    }

    @Nullable
    @Override
    public Composite getComposite() {
        return null;
    }

    @Override
    public void implement(Composite composite) {
        //and push a menu on their right
        mMenu = new CategoryMenu(this);
        mMenu.implement(composite);

        mMainContent = new MainContent();
        mMainContent.implement(composite);


        List<Category> categories = CategoryController.getInstance()
                .list();

        if (categories != null && categories.size() > 0) {
            Category category = categories.get(0);
            mMenu.onCategoryClicked(category);
            onCategoryClicked(category);
        }
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onCategoryClicked(Category category) {
        mMainContent.onCategoryClicked(category);
    }
}
