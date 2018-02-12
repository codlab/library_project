package com.cesi.library_project.ui.content;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jetbrains.annotations.NotNull;

public class MainContent implements IComponentProvider, ICategoryClicked {
    private Label mLabel;

    public MainContent() {

    }

    @Override
    public void implement(@NotNull Composite composite) {
        Composite content = new Composite(composite, SWT.PUSH);
        FillLayout fill = new FillLayout();
        fill.type = SWT.HORIZONTAL | SWT.VERTICAL;
        content.setLayout(fill);
        GridData data = new GridData(SWT.TOP, SWT.LEFT);
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        content.setLayoutData(data);
        content.setBackground(DisplayController.getInstance().getColor(255, 0, 0));
        mLabel = new Label(content, SWT.NONE);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onCategoryClicked(Category category) {
        if (mLabel != null) {
            mLabel.setText(category.getName());

            DisplayController.getInstance().layout(mLabel);
        }
    }
}
