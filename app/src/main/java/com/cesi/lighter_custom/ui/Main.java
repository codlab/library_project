package com.cesi.lighter_custom.ui;

import com.cesi.lighter_custom.database.controllers.ModelController;
import com.cesi.lighter_custom.database.db.ProjectDatabase;
import com.cesi.lighter_custom.database.models.Category;
import com.cesi.lighter_custom.database.models.Oeuvre;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //we call our database initialisation
        ProjectDatabase.getInstance().init();

        //we grab some controller just to play around
        ModelController<Category> controller = ProjectDatabase.getInstance().get(Category.class);
        ModelController<Oeuvre> controller2 = ProjectDatabase.getInstance().get(Oeuvre.class);

        List<Category> categories = controller.read();
        if (categories.size() == 0) {
            //we create some Category in the database
            Category category = controller.create(new Category());
            category.name = "Film";
            controller.update(category);

            Category autre_categorie = new Category();
            autre_categorie.name = "Livre";
            controller.create(autre_categorie);

            category = new Category("Musique");
            controller.create(category);

            controller.create(new Category("Jeux-Vidéo"));

            Oeuvre oeuvre = new Oeuvre();
            oeuvre.setDateAjout(new Date());
            oeuvre.setTitre("  Un titre          ");
            oeuvre.setCategory(category);
            controller2.create(oeuvre);

            categories = controller.read();
        }

        for (Category temp : categories) {
            System.out.println(temp);
        }

        //the above sandbox should be put in the default values method from the ProjectLibraryDatabase
        //from here, you should start using your own UI
        //use JWT or SWT
        //the later is quite better for cross platform integration. SWT can be a little easier to be used from Java only
    }
}
