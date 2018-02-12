package com.cesi.library_project.ui.test;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.ui.menu.CategoryMenu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.awt.*;

public class TestScreen implements IComponentProvider, ICategoryClicked {

    private CategoryMenu mMenu;
    private Label mLabel;

    public TestScreen() {

    }

    @Override
    public void implement(Composite composite) {
        //and push a menu on their right
        mMenu = new CategoryMenu(this);
        mMenu.implement(composite);

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
        System.out.println("click from menu on " + category.getName() + " " + category.getId());
        mLabel.setText(category.getName());
        mLabel.redraw();

        DisplayController.getInstance().layout(mLabel);
    }
}
