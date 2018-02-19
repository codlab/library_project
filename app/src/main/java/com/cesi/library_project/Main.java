package com.cesi.library_project;

import com.cesi.library_project.database.db.DatabaseController;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.test.TestScreen;
import org.eclipse.swt.widgets.Composite;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }


    Main() {

    }

    void start() {
        DatabaseController.getInstance().init();
        Composite composite = DisplayController.getInstance().getComposite();

        //starting the screen
        TestScreen screen = new TestScreen();
        //load TestScreen's content into the main "composite"
        screen.implement(composite);



        DisplayController.getInstance().startApp();
    }
}
