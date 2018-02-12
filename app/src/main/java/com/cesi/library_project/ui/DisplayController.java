package com.cesi.library_project.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DisplayController {
    private final static DisplayController CONTROLLER = new DisplayController();
    private final Display mDisplay;
    private final Shell mShell;
    private final RowLayout mLayout;

    public static DisplayController getInstance() {
        return CONTROLLER;
    }

    private DisplayController() {
        mDisplay = new Display();
        mShell = new Shell(mDisplay);
        mLayout = new RowLayout();
        mShell.setLayout (mLayout);
    }

    public Composite getComposite() {
        return mShell;
    }

    public void startApp() {
        mShell.setSize(300, 300);
        mShell.open();


        while (!mShell.isDisposed()) {
            if (!mDisplay.readAndDispatch())
                mDisplay.sleep();
        }

        mDisplay.dispose();
    }
}
