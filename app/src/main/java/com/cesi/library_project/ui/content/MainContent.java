package com.cesi.library_project.ui.content;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MainContent implements IComponentProvider, ICategoryClicked {

    private Composite mContent;
    private CategoryListContent mCategoryContent;

    public MainContent() {

    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mContent;
    }

    @Override
    public void implement(@NotNull Composite composite) {
        mContent = new Composite(composite, SWT.NONE);
        mContent.setBackground(DisplayController.getInstance().getColor(255, 255, 255));

        //create the way for this screen to be displayed at max size
        FillLayout fill = new FillLayout();
        fill.type = SWT.VERTICAL;
        fill.spacing = fill.marginWidth = fill.marginHeight = 0;

        GridData data = new GridData(SWT.FILL, SWT.FILL);
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;

        mContent.setLayout(fill);
        mContent.setLayoutData(data);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onCategoryClicked(Category category) {
        if (mCategoryContent != null) {
            mCategoryContent.dispose();
        }

        mCategoryContent = new CategoryListContent();
        mCategoryContent.implement(mContent);
        mCategoryContent.resize();

        System.out.println("test " + category.getName());
    }
}
