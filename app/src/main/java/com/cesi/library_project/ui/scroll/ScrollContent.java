package com.cesi.library_project.ui.scroll;

import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ScrollContent implements IComponentProvider {
    private ScrolledComposite mScrollComposite;
    private IComponentProvider mChildProvider;
    private WidthProvider mWidthProvider;

    public ScrollContent() {

        setPreferredWidthProvider(new WidthProvider() {
            @Override
            public int getPreferredWidth(Rectangle rectangle) {
                return rectangle.width;
            }
        });
    }

    public void setChild(@NotNull IComponentProvider provider) {
        mChildProvider = provider;


        mScrollComposite.setContent(mChildProvider.getComposite());
        mScrollComposite.setExpandHorizontal(true);
        mScrollComposite.setExpandVertical(true);
        mScrollComposite.addControlListener(new ControlListener() {
            @Override
            public void controlMoved(ControlEvent controlEvent) {

            }

            @Override
            public void controlResized(ControlEvent controlEvent) {
                Rectangle r = mScrollComposite.getClientArea();
                int width = mWidthProvider.getPreferredWidth(r);
                mScrollComposite.setMinSize(mChildProvider.getComposite().computeSize(width, SWT.DEFAULT));
            }
        });
    }

    public void setPreferredWidthProvider(@NotNull WidthProvider provider) {
        mWidthProvider = provider;
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mScrollComposite;
    }

    @Override
    public void implement(@NotNull Composite composite) {

        //proxy composite to display the internal component easily
        mScrollComposite = new ScrolledComposite(composite, SWT.V_SCROLL);

        RowLayout layout = new RowLayout(SWT.HORIZONTAL);
        layout.wrap = true;
        //next set into setChild()
    }

    @Override
    public void dispose() {
        mScrollComposite.dispose();
    }

    public void resize() {
        mChildProvider.getComposite().layout();
        DisplayController.getInstance().layout(mChildProvider.getComposite());
    }

    public interface WidthProvider {
        int getPreferredWidth(Rectangle rectangle);
    }
}
