package com.cesi.library_project.ui.content;

import com.cesi.library_project.database.controllers.AbstractController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.IIdSetter;
import com.cesi.library_project.providers.AbstractProvider;
import com.cesi.library_project.providers.Providers;
import com.cesi.library_project.providers.ui.AbstractComponentProvider;
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

import java.util.List;

public class CategoryListContent implements IComponentProvider {
    private final ScrollContent mScrollProvider;
    private final Category mCategory;
    private Composite mChildComposite;

    public CategoryListContent(Category category) {
        mScrollProvider = new ScrollContent();

        mCategory = category;
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mChildComposite;
    }

    @Override
    public void implement(@NotNull Composite composite) {

        AbstractProvider provider = Providers.getProvider(mCategory.getKlass());

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

        if( null != provider) {
            AbstractController<IIdSetter> controller = provider.getTableController();
            List<IIdSetter> list = controller.list();

            for (IIdSetter object: list) {
                AbstractComponentProvider<IIdSetter> component = provider.getThumbnailProvider(object);
                component.implement(mChildComposite);
            }
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
