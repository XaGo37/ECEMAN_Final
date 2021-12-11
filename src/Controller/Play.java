package Controller;

import Model.ChargeMap;
import View.Affichage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static Controller.Save.readTextFile;
import static Controller.Save.saveToTextFile;

public class Play {

    private static Perso player = new Perso(0, 0);
    static int lvlnumber = 1;

    static void chooseTextFile() {
        System.out.println("Sauvegardes disponibles:");
        File f = new File("src/TextFile/");
        for (String pathname : f.list()) {
            System.out.println("- "+pathname.split("\\.")[0]);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("choisir une sauvegarde: ");
        String save = sc.nextLine();
        readTextFile(save);
    }

    public static int MenuData() {
        int selection;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez une option :");
        System.out.println(" 1 - Regles du jeu ");
        System.out.println(" 2 - Jouer ");
        System.out.println(" 3 - Recharger une partie");
        System.out.println(" 4 - Quitter ");

        System.out.println("Vous avez choisis de :");
        selection = sc.nextInt();
        return selection;
    }


    public static void playGame(boolean isSavedLevel, Map savedMap) throws IOException {
        Map mapLvl1 = new Map(ChargeMap.mapLVL1);
        Map mapLvl2 = new Map(ChargeMap.mapLVL2);
        Map mapLvl3 = new Map(ChargeMap.mapLVL3);
        Map mapLvl4 = new Map(ChargeMap.mapLVL4);


        while (lvlnumber <= 4) {

            if(isSavedLevel) {
                isSavedLevel = false;
                System.out.println("LEVEL "+ lvlnumber);
                PlayLevel(player,savedMap);
                System.out.println("-------------------------------- 5 - QUITTER & SAUVEGARDER");
            }

            switch(lvlnumber){
                case 1:
                    System.out.println("LEVEL 1 ");
                    PlayLevel(player,mapLvl1);
                    System.out.println("-------------------------------- 5 - QUITTER & SAUVEGARDER");

                    break;
                case 2:
                    System.out.println("LEVEL 2 ");
                    PlayLevel(player,mapLvl2);
                    System.out.println("-------------------------------- 5 - QUITTER & SAUVEGARDER");

                    break;
                case 3:
                    System.out.println("LEVEL 3 ");
                    PlayLevel(player,mapLvl3);
                    System.out.println("-------------------------------- 5 - QUITTER & SAUVEGARDER");

                    break;
                case 4:
                    System.out.println("LEVEL 4");
                    PlayLevel(player,mapLvl4);
                    System.out.println("-------------------------------- 5 - QUITTER & SAUVEGARDER");

                    break;
            }
        }
    }

    private static void PlayLevel(Perso player, Map map) throws IOException {

   //     Keyboard key = new Keyboard(map,player);

        Level lvl = new Level(map, player);
        Scanner sc = new Scanner(System.in);
        while (!lvl.isOver() && !lvl.isDone())
        {
            Affichage.afficher(map, player);
            System.out.println("Lifes = " + player.getLife());
            System.out.print("Enter choice : ");
            char choice = sc.nextLine().charAt(0);

            if(choice=='5'){
                System.out.print("entrez votre nom: ");
                saveToTextFile(sc.nextLine(), map, player);
                System.out.println("LE JEU A ETE SAUVEGARDE");
                System.exit(0);
            }
            lvl.movePerso(choice);
        }
        if (lvl.isDone()) {
            player.setCurrentCase('o');
            player.setLife(3); // remet les vies quand le niveau est terminé
            lvlnumber++;
        }
        if (lvl.isOver()) {
            System.out.println("LOOSER");
            System.exit(0);
        }
    }
    }
