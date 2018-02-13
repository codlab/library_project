package com.cesi.library_project.ui.content;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jetbrains.annotations.NotNull;

public class MainContent implements IComponentProvider, ICategoryClicked {
    private Label mLabel;
    private Label mOther;

    public MainContent() {

    }

    @Override
    public void implement(@NotNull Composite composite) {
        Composite content = new Composite(composite, SWT.PUSH);

        //create the way for this screen to be displayed at max size
        FillLayout fill = new FillLayout();
        fill.type = SWT.HORIZONTAL | SWT.VERTICAL;
        content.setLayout(fill);
        GridData data = new GridData(SWT.TOP, SWT.LEFT);
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        content.setLayoutData(data);

        //proxy composite to display the internal component easily
        content = new Composite(content, SWT.PUSH);
        RowLayout layout = new RowLayout();
        layout.fill = true;
        layout.wrap = true;

        content.setLayout(layout);
        content.setBackground(DisplayController.getInstance().getColor(200,100,100));

        //add the component
        mLabel = new Label(content, SWT.NONE);
        mLabel.setText("");

        Image heroes = DisplayController.getInstance()
                .loadImage("/com/cesi/resources/heroes.png", 150);

        int i = 0;
        while (i < 100) {
            Label label = new Label(content, SWT.NONE);
            label.setImage(heroes);
            i++;
        }
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onCategoryClicked(Category category) {
        mLabel.setText(category.getName());

        System.out.println("test " +category.getName());
        DisplayController.getInstance().layout(mLabel);
    }
}
