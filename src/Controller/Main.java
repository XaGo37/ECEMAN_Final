package Controller;


import View.Graphics;
import com.sun.deploy.panel.RuleSetViewerDialog;

import java.io.*;
import static Controller.Play.*;



public class Main {

    public static void main(String[] args) throws IOException {

        Graphics home = new Graphics();

        int userSelected;
        do {
            userSelected = MenuData();
            switch (userSelected) {
                case 1:
                    System.out.println("Voici les règles du jeu :");
                    System.out.println("##########################");

                    break;
                case 2:
                    playGame(false, null);
                    break;
                case 3:
                    chooseTextFile();
                    break;
                case 4:
                    System.out.println("QUITTER");
                    System.exit(0);
                    break;
            }
        }
        while (userSelected > 4);

        home.setVisible(true);

    }


}


