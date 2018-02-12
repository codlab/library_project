package com.cesi.library_project.ui;


import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public interface IComponentProvider {

    /**
     * Instantiate and manage the view from the implementation class
     *
     * @param composite inject the view into it
     */
    void implement(@NotNull Composite composite);

    /**
     * Free and dispose the graphical elements from this implementation
     */
    void dispose();
}
