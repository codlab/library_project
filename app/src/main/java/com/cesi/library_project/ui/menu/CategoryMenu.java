package com.cesi.library_project.ui.menu;

import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.ui.scroll.ScrollContent;
import com.cesi.library_project.ui.test.TestScreen;
import com.cesi.library_project.utils.categories.ICategory;
import com.cesi.library_project.utils.categories.StaticCategories;
import com.cesi.library_project.utils.categories.StaticCategory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the whole left menu
 */
public class CategoryMenu implements IComponentProvider, ICategoryClicked {

    private GridLayout mGrid;
    private Composite mComposite;
    private ArrayList<CategoryItem> mCategoriesItem;
    private TestScreen mParent;
    private ScrollContent mScrollProvider;

    public CategoryMenu(@NotNull TestScreen parent) {
        mParent = parent;
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mComposite;
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

            mScrollProvider = new ScrollContent();
            mScrollProvider.implement(composite);
            mScrollProvider.setPreferredWidthProvider(rectangle -> SWT.DEFAULT);

            mComposite = new Composite(mScrollProvider.getComposite(), SWT.PUSH);
            mScrollProvider.setChild(this);

            GridData data = new GridData();
            data.verticalAlignment = SWT.FILL;
            data.horizontalAlignment = SWT.BEGINNING;
            mGrid.marginWidth = mGrid.marginBottom = mGrid.marginHeight = 0;
            mGrid.marginTop = 0;
            mGrid.marginLeft = mGrid.marginRight = 0;
            mGrid.horizontalSpacing = mGrid.verticalSpacing = 0;
            mScrollProvider.getComposite().setLayoutData(data);
            mComposite.setLayout(mGrid);
        }

        mCategoriesItem = new ArrayList<CategoryItem>();

        for (Category category : list) {
            CategoryItem item = new CategoryItem(this, category);
            mCategoriesItem.add(item);
            item.implement(mComposite);
        }


        Label separator = new Label(mComposite, SWT.HORIZONTAL | SWT.SEPARATOR);
        separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
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

        for (CategoryItem item : mCategoriesItem) {
            item.onCategoryClicked(category);
        }
    }
}
