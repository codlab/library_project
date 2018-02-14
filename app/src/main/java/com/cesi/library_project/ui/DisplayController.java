package com.cesi.library_project.ui;

import com.cesi.library_project.utils.Utils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DisplayController {
    private final static DisplayController CONTROLLER = new DisplayController();
    private final Display mDisplay;
    private final Shell mShell;
    private final GridLayout mLayout;

    public static DisplayController getInstance() {
        return CONTROLLER;
    }

    private DisplayController() {
        mDisplay = new Display();
        mShell = new Shell(mDisplay, SWT.SHELL_TRIM);
        mLayout = new GridLayout();
        mLayout.numColumns = 2;
        mShell.setLayout(mLayout);
        mShell.setBackground(getColor(100,100,100));
    }

    public Composite getComposite() {
        return mShell;
    }

    public Display getDisplay() {
        return mDisplay;
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
        while (current_composite != null) {
            current_composite.layout();
            current_composite = current_composite.getParent();
        }
    }

    public Color getColor(int red, int green, int blue) {
        return new Color(mDisplay, red, green, blue);
    }

    public Image loadImage(String path, int max_height) {
        Image image = Utils.loadImageFromResources(this, mDisplay, path);
        return Utils.resizeImage(image, mDisplay,  1, max_height);
    }
}
