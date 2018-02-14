package com.cesi.library_project.ui.content;

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

public class CategoryListContent implements IComponentProvider {
    private Composite mChildComposite;
    private ScrolledComposite mScrollComposite;

    @Override
    public void implement(@NotNull Composite composite) {

        //proxy composite to display the internal component easily
        mScrollComposite = new ScrolledComposite(composite, SWT.V_SCROLL);
        mChildComposite = new Composite(mScrollComposite, SWT.NONE);

        RowLayout layout = new RowLayout(SWT.HORIZONTAL);
        layout.wrap = true;
        mChildComposite.setLayout(layout);

        mScrollComposite.setContent(mChildComposite);
        mScrollComposite.setExpandHorizontal(true);
        mScrollComposite.setExpandVertical(true);
        mScrollComposite.addControlListener(new ControlListener() {
            @Override
            public void controlMoved(ControlEvent controlEvent) {

            }

            @Override
            public void controlResized(ControlEvent controlEvent) {
                Rectangle r = mScrollComposite.getClientArea();
                mScrollComposite.setMinSize(mChildComposite.computeSize(r.width, SWT.DEFAULT));
            }
        });
        mChildComposite.setBackground(DisplayController.getInstance().getColor(200,100,100));

        Image heroes = DisplayController.getInstance()
                .loadImage("/com/cesi/resources/heroes.png", 150);

        int i = 0;
        while (i < 100) {
            Label label = new Label(mChildComposite, SWT.NONE);
            label.setImage(heroes);
            i++;
        }

    }

    @Override
    public void dispose() {
        mScrollComposite.dispose();
    }

    public void resize() {
        mChildComposite.layout();
        DisplayController.getInstance().layout(mChildComposite);
    }
}
