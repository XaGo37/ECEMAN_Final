package Controller;

import Model.ChargeMap;
import View.Affichage;

import java.io.*;
import java.util.Scanner;

import static Controller.Play.*;
import static Model.ChargeMap.mapLVL3;


public class Main {

    public static void main(String[] args) throws IOException {


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
    }
}


