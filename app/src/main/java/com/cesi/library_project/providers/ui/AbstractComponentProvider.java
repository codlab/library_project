package com.cesi.library_project.providers.ui;

import com.cesi.library_project.database.models.IIdSetter;
import com.cesi.library_project.ui.IComponentProvider;

public abstract class AbstractComponentProvider<MODEL extends IIdSetter>
        implements IComponentProvider {

    private MODEL mObject;

    private AbstractComponentProvider() {

    }

    protected AbstractComponentProvider(MODEL object) {
        mObject = object;
    }

    protected MODEL getModel() {
        return mObject;
    }
}
