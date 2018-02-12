package com.cesi.library_project.ui.test;

import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.menu.CategoryMenu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class TestScreen implements IComponentProvider {

    private Button mButton3;
    private Button mButton2;
    private CategoryMenu mMenu;

    public TestScreen() {

    }

    @Override
    public void implement(Composite composite) {
        //create 2 buttons
        mButton2 = new Button(composite, SWT.PUSH);
        mButton2.setText("Button");

        mButton3 = new Button(composite, SWT.PUSH);
        mButton3.setText("Button");

        //and push a menu on their right
        mMenu = new CategoryMenu();
        mMenu.implement(composite);
    }

    @Override
    public void dispose() {
        mButton2.dispose();
        mButton3.dispose();
    }
}
