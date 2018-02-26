package com.cesi.library_project.ui.test;

import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.content.MainContent;
import com.cesi.library_project.ui.format.Format;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.ui.menu.CategoryMenu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MainAreaContent implements IComponentProvider, ICategoryClicked {

    private CategoryMenu mMenu;
    private MainContent mMainContent;

    public MainAreaContent() {

    }

    @Nullable
    @Override
    public Composite getComposite() {
        return null;
    }

    @Override
    public void implement(Composite composite) {

        Composite main_composite = new Composite(composite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.horizontalSpacing = layout.verticalSpacing = 0;
        layout.marginTop = layout.marginBottom = 0;
        layout.marginLeft = layout.marginRight = 0;
        layout.marginWidth = layout.marginHeight = 0;

        GridData data = new GridData();
        data.horizontalAlignment = SWT.FILL;
        data.verticalAlignment = SWT.FILL;
        data.grabExcessVerticalSpace = data.grabExcessHorizontalSpace = true;
        main_composite.setLayoutData(data);
        main_composite.setLayout(layout);

        main_composite.setBackground(DisplayController.getInstance()
                .getColor(200, 0, 0));

        //and push a menu on their right
        mMenu = new CategoryMenu(this);
        mMenu.implement(main_composite);

        mMainContent = new MainContent();
        mMainContent.implement(main_composite);


        List<Category> categories = CategoryController.getInstance()
                .list();

        if (categories != null && categories.size() > 0) {
            Category category = categories.get(0);
            mMenu.onCategoryClicked(category, Format.THUMBNAIL);
            onCategoryClicked(category, Format.THUMBNAIL);
        }
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onCategoryClicked(@Nullable Category category, @Nullable Format format) {
        mMainContent.onCategoryClicked(category, format);
    }
}
