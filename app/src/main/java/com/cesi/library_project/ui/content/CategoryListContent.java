package com.cesi.library_project.ui.content;

import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.scroll.ScrollContent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CategoryListContent implements IComponentProvider {
    private final ScrollContent mScrollProvider;
    private Composite mChildComposite;

    public CategoryListContent() {
        mScrollProvider = new ScrollContent();
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mChildComposite;
    }

    @Override
    public void implement(@NotNull Composite composite) {

        //proxy composite to display the internal component easily
        mScrollProvider.implement(composite);
        mChildComposite = new Composite(mScrollProvider.getComposite(), SWT.NONE);
        mChildComposite.setBackground(DisplayController.getInstance().getColor(255, 255, 255));

        mScrollProvider.setChild(this);

        RowLayout layout = new RowLayout(SWT.HORIZONTAL);
        layout.wrap = true;
        layout.marginTop = layout.marginBottom = layout.marginLeft = layout.marginRight = 24;
        layout.marginHeight = layout.marginWidth = 0;
        layout.spacing = 24;
        mChildComposite.setLayout(layout);

        int i = 0;
        while (i < 100) {
            CategoryContentItem item = new CategoryContentItem();
            item.implement(mChildComposite);
            i++;
        }

    }

    @Override
    public void dispose() {
        mScrollProvider.dispose();
    }

    public void resize() {
        mChildComposite.layout();
        DisplayController.getInstance().layout(mChildComposite);
    }
}
