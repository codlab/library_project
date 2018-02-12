package com.cesi.library_project.ui.menu;

import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.IComponentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the whole left menu
 */
public class CategoryMenu implements IComponentProvider {

    private GridLayout mGrid;
    private Composite mComposite;
    private ArrayList<IComponentProvider> mCategoriesItem;

    public CategoryMenu() {
        //empty
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
            mComposite.setLayout(mGrid);
        }

        mCategoriesItem = new ArrayList<IComponentProvider>();

        for (Category category : list) {
            CategoryItem item = new CategoryItem(category);
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
}
