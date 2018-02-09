package com.cesi.library_project;

import com.cesi.library_project.database.db.DatabaseController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.start();
  }



  Main() {

  }

  void onClick() {
    System.out.println("MOUSE UP");
  }

  void start() {

    DatabaseController.getInstance().init();

    Display display = new Display();
    Image image = display.getSystemImage(SWT.ICON_QUESTION);
    Shell shell = new Shell(display);
    shell.setLayout (new RowLayout());

    Button button2 = new Button(shell, SWT.PUSH);
    button2.setImage(image);
    button2.setText("Button");

    Button button3 = new Button(shell, SWT.PUSH);
    button3.setImage(image);
    button3.setText("Button");

    shell.setSize(300, 300);
    shell.open();


    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }

    display.dispose();
  }
}
