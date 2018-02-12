package com.cesi.library_project.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class DisplayController {
    private final static DisplayController CONTROLLER = new DisplayController();
    private final Display mDisplay;
    private final Shell mShell;
    private final Layout mLayout;

    public static DisplayController getInstance() {
        return CONTROLLER;
    }

    private DisplayController() {
        mDisplay = new Display();
        mShell = new Shell(mDisplay, SWT.SHELL_TRIM);
        mLayout = new GridLayout(2, false);
        mShell.setLayout(mLayout);
        mShell.setBackground(getColor(100,100,100));
    }

    public Composite getComposite() {
        return mShell;
    }

    public void startApp() {
        mShell.setSize(300, 300);
        mShell.setMinimumSize(300, 300);
        mShell.open();


        while (!mShell.isDisposed()) {
            if (!mDisplay.readAndDispatch())
                mDisplay.sleep();
        }

        mDisplay.dispose();
    }

    public void layout(Control control) {
        Composite current_composite = control.getParent();
        while (current_composite.getParent() != null) {
            current_composite = current_composite.getParent();
        }
        current_composite.layout();
    }

    public Color getColor(int red, int green, int blue) {
        return new Color(mDisplay, red, green, blue);
    }
}
