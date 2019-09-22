package com.cesi.customProject;


import com.cesi.customProject.database.controllers.ModelController;
import com.cesi.customProject.database.models_custom.Categorie;
import com.cesi.customProject.database.models_custom.Oeuvre;
import com.cesi.library_project.database.db.DatabaseController;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.test.MainAreaContent;
import com.cesi.library_project.ui.test.NavBarContent;
import org.eclipse.swt.widgets.Composite;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main ();
        main.start();
        ModelController<Categorie> controller = new ModelController<> (Categorie.class);
        ModelController<Oeuvre> controller2 = new ModelController<> (Oeuvre.class);

        Categorie categorie = controller.create ();
        categorie.setLib_cat("test");

        controller.update(categorie);
        List<Categorie> categories = controller.read();
        Oeuvre oeuvre = controller2.create();
    }


    Main() {

    }

    void start() {

    }
}
