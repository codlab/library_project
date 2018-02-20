package com.cesi.library_project.providers;

import com.cesi.library_project.database.controllers.AbstractController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.IIdSetter;
import com.cesi.library_project.providers.ui.AbstractComponentProvider;

import java.util.List;

public abstract class AbstractProvider<MODEL extends IIdSetter, COMPONENT_PROVIDER extends AbstractComponentProvider<MODEL>, TABLE_CONTROLLER extends AbstractController<MODEL>> {

    private TABLE_CONTROLLER mController;

    protected AbstractProvider() {
        mController = createController();
    }

    protected abstract TABLE_CONTROLLER createController();

    public abstract COMPONENT_PROVIDER getThumbnailProvider(MODEL object);

    public abstract COMPONENT_PROVIDER getPageProvider(MODEL object);

    public TABLE_CONTROLLER getTableController() {
        return mController;
    }
}
