package com.cesi.library_project.ui.menu;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.utils.Fonts;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a Menu Item
 */
public class CategoryItem implements IComponentProvider, MouseListener, ICategoryClicked {

    private CategoryMenu mParent;
    private Category mCategory;
    private Label mLabelType;
    private Label mLabelName;
    private Composite mComposite;
    private Category mLastClicked;

    public CategoryItem(@NotNull CategoryMenu parent, @NotNull Category category) {
        setCategory(category);
        setCategoryParent(parent);
    }

    public void setCategory(@NotNull Category category) {
        mCategory = category;

        if (mLabelName != null) {
            mLabelName.setText(mCategory.getName());
        }
    }

    public void setCategoryParent(@NotNull CategoryMenu category_menu) {
        mParent = category_menu;
    }

    public Category getCategory() {
        return mCategory;
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mComposite;
    }

    /**
     * Creates the button and set its text to the category name
     *
     * @param composite inject the view into it
     */
    @Override
    public void implement(@NotNull Composite composite) {

        mComposite = new Composite(composite, SWT.NONE);
        RowLayout layout = new RowLayout();
        layout.center = true;
        layout.marginLeft = layout.marginRight = 12;
        mComposite.setLayout(layout);
        GridData data = new GridData();
        data.horizontalAlignment = SWT.FILL;
        mComposite.setLayoutData(data);

        if (mLabelType != null) mLabelType.dispose();
        if (mLabelName != null) mLabelName.dispose();

        mLabelType = new Label(mComposite, SWT.NONE);
        mLabelName = new Label(mComposite, SWT.NONE);

        mLabelType.addMouseListener(this);
        mLabelName.addMouseListener(this);
        mComposite.addMouseListener(this);

        Listener enter = new Listener() {
            @Override
            public void handleEvent(Event event) {
                onMouseEnter();
            }
        };

        Listener exit = new Listener() {
            @Override
            public void handleEvent(Event event) {
                onMouseExit();
            }
        };
        mComposite.addListener(SWT.MouseEnter, enter);
        mLabelName.addListener(SWT.MouseEnter, enter);
        mLabelType.addListener(SWT.MouseEnter, enter);
        mComposite.addListener(SWT.MouseExit, exit);
        mLabelName.addListener(SWT.MouseExit, exit);
        mLabelType.addListener(SWT.MouseExit, exit);

        mLabelType.setFont(Fonts.getInstance().getFont("nonopn", 12));

        Fonts.getInstance().displayAllLoadedFonts();

        if (mCategory != null) {
            mLabelType.setText(mCategory.getIcon());
            mLabelName.setText(mCategory.getName());
        }
        onMouseExit();
    }

    @Override
    public void dispose() {
        mLabelName.dispose();
        mLabelType.dispose();
    }

    @Override
    public void mouseDoubleClick(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDown(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseUp(MouseEvent mouseEvent) {
        mParent.onCategoryClicked(mCategory);
    }

    private void onMouseEnter() {
        Color color = DisplayController.getInstance()
                .getColor(150, 150, 150);
        mComposite.setBackground(color);
        mLabelName.setBackground(color);
        mLabelType.setBackground(color);
    }

    private void onMouseExit() {
        if (mLastClicked != null && mLastClicked.equals(mCategory)) {
            onMouseEnter();
        } else {
            Color color = DisplayController.getInstance()
                    .getColor(240, 240, 240);
            mComposite.setBackground(color);
            mLabelName.setBackground(color);
            mLabelType.setBackground(color);
        }
    }

    @Override
    public void onCategoryClicked(Category category) {
        mLastClicked = category;
        if (mCategory != null && mCategory.equals(category)) {
            onMouseEnter();
        } else {
            onMouseExit();
        }
    }
}
