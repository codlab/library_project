package com.cesi.library_project.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

import java.io.FileInputStream;
import java.io.InputStream;

public class Utils {


    public static Image loadImageFromFileInputStream(Display display, String path) {
        Image image = null;
        try {
            FileInputStream input_stream = new FileInputStream(path);
            image = new Image(display, input_stream);
            input_stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    public static Image loadImageFromResources(Object object, Display display_used,
                                               String path) {
        Image image = null;
        try {
            InputStream input_stream = object.getClass().getResourceAsStream(path);
            image = new Image(display_used, input_stream);
            input_stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    public static Image resizeImage(Image image,
                                    Display display_used,
                                    float ratio,
                                    int max_height) {
        try {
            Rectangle rect = image.getBounds();

            float mult = 1.f;
            int new_width = (int) (rect.width * ratio);
            int new_height = (int) (rect.height * ratio);

            if (max_height > 0 && new_height > 0 && new_height > max_height) {
                mult = max_height * 1.f / new_height;
                new_height = max_height;
                new_width *= mult;
            }

            Image scaled = new Image(display_used, new_width, new_height);
            GC gc = new GC(scaled);
            gc.setAntialias(SWT.ON);
            gc.setInterpolation(SWT.HIGH);
            gc.drawImage(image, 0, 0,
                    image.getBounds().width, image.getBounds().height,
                    0, 0, new_width, new_height);
            gc.dispose();
            image.dispose(); // don't forget about me!
            return scaled;
        } catch (Exception exception) {

        }
        return null;
    }
}
