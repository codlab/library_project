package com.cesi.library_project.ui.menu;

import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.ui.test.TestScreen;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the whole left menu
 */
public class CategoryMenu implements IComponentProvider, ICategoryClicked {

    private GridLayout mGrid;
    private Composite mComposite;
    private ArrayList<IComponentProvider> mCategoriesItem;
    private TestScreen mParent;

    public CategoryMenu(@NotNull TestScreen parent) {
        mParent = parent;
    }

    /**
     * For each Category from the database, add a new CategpryItem
     * and add it to the internal list of UI
     *
     * @param composite inject the view into it
     */
    @Override
    public void implement(Composite composite) {

        List<Category> list = CategoryController.getInstance().list();

        if (mGrid == null) {
            mGrid = new GridLayout(1, true);

            mComposite = new Composite(composite, SWT.PUSH);
            mComposite.setLayoutData(new GridData(SWT.TOP, SWT.LEFT));
            mComposite.setLayout(mGrid);
            mComposite.setBackground(DisplayController.getInstance()
                    .getColor(0, 255, 0));
        }

        mCategoriesItem = new ArrayList<IComponentProvider>();

        for (Category category : list) {
            CategoryItem item = new CategoryItem(this, category);
            mCategoriesItem.add(item);
            item.implement(mComposite);
        }

    }

    /**
     * For each UI Element, dispose its ressources
     */
    @Override
    public void dispose() {
        for (IComponentProvider item : mCategoriesItem) {
            item.dispose();
        }
    }

    @Override
    public void onCategoryClicked(Category category) {
        mParent.onCategoryClicked(category);
    }
}
