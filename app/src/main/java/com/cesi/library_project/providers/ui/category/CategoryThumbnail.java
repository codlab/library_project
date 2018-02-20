package com.cesi.library_project.providers.ui.category;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.providers.ui.AbstractComponentProvider;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.ui.menu.CategoryMenu;
import com.cesi.library_project.utils.Fonts;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CategoryThumbnail extends AbstractComponentProvider<Category>
        implements MouseListener, ICategoryClicked {


    private CategoryMenu mParent;
    private Label mLabelType;
    private Label mLabelName;
    private Composite mComposite;
    private Category mLastClicked;

    public CategoryThumbnail(Category object) {
        super(object);
    }

    /*public CategoryThumbnail(@NotNull CategoryMenu parent, @NotNull Category category) {
        super(category);

        setCategory(category);
        setCategoryParent(parent);
    }*/

    public void setCategoryParent(@NotNull CategoryMenu category_menu) {
        mParent = category_menu;
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

        if (getModel() != null) {
            mLabelType.setText(getModel().getIcon());
            mLabelName.setText(getModel().getName());
        }
        onMouseExit();
    }

    @Override
    public void dispose() {
        if (!mComposite.isDisposed()) {
            mComposite.dispose();
            mLabelName.dispose();
            mLabelType.dispose();
        }
    }

    @Override
    public void mouseDoubleClick(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDown(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseUp(MouseEvent mouseEvent) {
        mParent.onCategoryClicked(getModel());
    }

    private void onMouseEnter() {
        changeColor(150, 150, 150,
                240, 240, 240);
    }

    private void onMouseExit() {
        if (mLastClicked != null && mLastClicked.equals(getModel())) {
            onMouseEnter();
        } else {
            changeColor(240, 240, 240,
                    50, 50, 50);
        }
    }

    private void changeColor(int red, int green, int blue,
                             int text_red, int text_green, int text_blue) {

        Color color = DisplayController.getInstance()
                .getColor(red, green, blue);
        Color text_color = DisplayController.getInstance()
                .getColor(text_red, text_green, text_blue);

        if (!mComposite.isDisposed()) {
            mComposite.setBackground(color);
            mLabelName.setBackground(color);
            mLabelType.setBackground(color);

            mLabelType.setForeground(text_color);
            mLabelName.setForeground(text_color);
        }
    }

    @Override
    public void onCategoryClicked(Category category) {
        mLastClicked = category;
        if (getModel() != null && getModel().equals(category)) {
            onMouseEnter();
        } else {
            onMouseExit();
        }
    }
}
