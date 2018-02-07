package com.cesi.library_project;

import com.cesi.library_project.database.db.DatabaseController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class Main {

  public static void main(String[] args) {
      DatabaseController.getInstance().init();




          /* Représente l'écran */
          Display display = new Display();
          //Image image = display.getSystemImage(SWT.ICON_QUESTION);

          /* Représente la fenêtre */
            Shell shell = new Shell(display);
            shell.setText("La biblio de la team de TROIS"); // on place un titre à la fenetre

            final Color couleur1 = new Color(display, 105, 240, 56);
            shell.setBackground(couleur1);

            shell.setLayout(new

            GridLayout(2,false));


          /* création de Composite (toolbar de gauche et content de droite) */
          Composite left = new Composite(shell, SWT.NONE);
          Composite right = new Composite(shell, SWT.BORDER);
          /* couleut pour la toolbar de gauche */
          final Color couleur2 = new Color(display, 45, 140, 226);
          left.setBackground(couleur2);
          /* false false nécessaire pour modifier les dimensions des Composites */
          /*final GridData leftData = new GridData(SWT.FILL, SWT.FILL, false, false);
          final GridData rightData = new GridData(SWT.FILL, SWT.FILL, true, true);*/
            final GridData leftData = new GridData(SWT.FILL, SWT.FILL, false, false);
            final GridData rightData = new GridData(SWT.FILL, SWT.FILL, true, true);

          left.setLayoutData(leftData);
          right.setLayoutData(rightData);

          // dimension des Grids - ratio left right
          Point size = shell.getSize();
          leftData.widthHint =(int)(size.x *0.15);


      /*ToolBar toolbar = new ToolBar(shell, SWT.VERTICAL | SWT.BORDER);
          //ToolBar toolbar = new ToolBar(left, 2);
          ToolItem itemMusic = new ToolItem(toolbar, SWT.PUSH);
    itemMusic.setText("Musique");
          ToolItem itemVideo = new ToolItem(toolbar, SWT.PUSH);
    itemVideo.setText("Video");
          ToolItem itemGame = new ToolItem(toolbar, SWT.PUSH);
    itemGame.setText("Jeu");
          ToolItem itemBook = new ToolItem(toolbar, SWT.PUSH);
    itemBook.setText("Livre");*/

          //toolbar.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_END));
            //toolbar.setLayoutData(shell);
    /*Listener listener = new Listener() {
      public void handleEvent(Event event) {
        ToolItem item = (ToolItem) event.widget;
        String string = item.getText();
        if (string.equals("Musique")) {
          System.out.println("Musique");
        } else if (string.equals("Video")) {
          System.out.println("Video");
        } else if (string.equals("Jeu")) {
          System.out.println("Jeu");
        } else if (string.equals("Livre")) {
          System.out.println("Livre");

        }
      }
    };
    itemMusic.addListener(SWT.Selection, listener);
    itemVideo.addListener(SWT.Selection, listener);
    itemGame.addListener(SWT.Selection, listener);
    itemBook.addListener(SWT.Selection, listener);*/


    Button button = new Button(left, SWT.PUSH);
    //button.setImage(image);
    button.setText("Button");

    //button.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL));
      button.setLayoutData(left);

          // add second button
    /*Button button2 = new Button(shell, SWT.PUSH);
    button2.setSize(100,100);
    button2.setImage(image2);
    button2.setText("Maxime");*/
          //button2.setLocation(new Point(200,520));
          //button2.setSize(new Point(100,100));

    /*Text firstText = new Text(shell, SWT.BORDER);
    firstText.setText("hello");
    firstText.setSize(50,250);
    firstText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
*/

    shell.setSize(1200,800);
    shell.open();


          // wait for action (button, click, etc ....
    while(!shell.isDisposed())

          {
              if (!display.readAndDispatch())
                  display.sleep();
          }

    display.dispose();
      }

}
