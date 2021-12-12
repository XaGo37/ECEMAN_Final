package Controller;


import View.Graphics;
import com.sun.deploy.panel.RuleSetViewerDialog;

import java.io.*;
import java.util.InputMismatchException;
import static Controller.Play.*;
import static Controller.Play.startMenu;



public class Main {

    public static void main(String[] args) throws IOException {

        try {
            timer.start();
            startMenu();
        } catch (InputMismatchException e) {
            System.out.println("Vous n'avez pas sélectionné la bonne touche");
            startMenu();
        }


        //  Graphics home = new Graphics();
        // home.setVisible(true);
    }




}


