package Controller;

import View.Graphics;

import java.io.*;
import java.util.InputMismatchException;
import static Controller.Play.*;
import static Controller.Play.startMenu;

public class Main {

    //COLOR
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws IOException {

    /*    Graphics home = new Graphics();
        home.setVisible(true);*/

        try {
            timer.start();              // Lancement du timer
            startMenu();                // Lancement du Menu
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED+"Vous n'avez pas sélectionné la bonne touche"+ANSI_RESET);
            startMenu();
        }



    }




}


