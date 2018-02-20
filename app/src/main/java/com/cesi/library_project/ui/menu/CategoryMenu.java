package com.cesi.library_project.ui.menu;

import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.ui.scroll.ScrollContent;
import com.cesi.library_project.ui.test.MainAreaContent;
import com.cesi.library_project.utils.Fonts;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
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
    private MainAreaContent mParent;
    private ScrollContent mScrollProvider;

    public CategoryMenu(@NotNull MainAreaContent parent) {
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
            data.grabExcessVerticalSpace = true;

            mGrid.marginWidth = mGrid.marginBottom = mGrid.marginHeight = 0;
            mGrid.marginTop = 0;
            mGrid.marginLeft = mGrid.marginRight = 0;
            mGrid.horizontalSpacing = mGrid.verticalSpacing = 0;
            mScrollProvider.getComposite().setLayoutData(data);
            mComposite.setLayout(mGrid);
        }

        mCategoriesItem = new ArrayList<CategoryItem>();

        Composite temp_composite = new Composite(mComposite, SWT.NONE);
        RowLayout layout = new RowLayout(SWT.VERTICAL);
        layout.marginTop = 12;
        layout.marginBottom = layout.marginLeft = 6;
        temp_composite.setLayout(layout);

        Label title = new Label(temp_composite, SWT.NONE);
        title.setText("Main categories");
        title.setForeground(DisplayController.getInstance()
                .getColor(120, 120, 120));

        for (Category category : list) {
            CategoryItem item = new CategoryItem(CategoryMenu.this, category);
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
