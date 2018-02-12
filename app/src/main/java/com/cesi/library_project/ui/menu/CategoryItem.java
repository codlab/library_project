package com.cesi.library_project.ui.menu;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.IComponentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import javax.swing.*;

/**
 * Represents a Menu Item
 */
public class CategoryItem implements IComponentProvider {

    private Category mCategory;
    private Button mLabel;

    public CategoryItem(Category category) {
        setCategory(category);
    }

    public void setCategory(Category category) {
        mCategory = category;

        if (mLabel != null) {
            mLabel.setText(mCategory.getName());
        }
    }

    public Category getCategory() {
        return mCategory;
    }

    /**
     * Creates the button and set its text to the category name
     * @param composite inject the view into it
     */
    @Override
    public void implement(Composite composite) {
        if (mLabel != null) mLabel.dispose();

        mLabel = new Button(composite, SWT.PUSH);

        if (mCategory != null) {
            mLabel.setText(mCategory.getName());
        }
    }

    @Override
    public void dispose() {
        mLabel.dispose();
    }
}
