package Controller;

import Model.ChargeMap;
import Model.Map;
import Model.Perso;
import View.Affichage;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import static Controller.Save.*;

public class Play {

    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_CYAN = "\033[0;36m";    // CYAN
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_RED = "\u001B[31m";


    /**
     *Création des différents objets
     */
    static Perso player = new Perso(0, 0);
    static int lvlnumber = 1;
    static CountTime timer = new CountTime();



    public static void startMenu() throws IOException {
        int userSelected;

        do {
            userSelected = MenuData();
            switch (userSelected) {
                case 1:
                    System.out.println("Le but du jeu est de déplacer le personnage jusqu'à la porte de sortie "+
                            "tout en recouvrant chacun des blocs de glace. \n" +
                            "Pour déplacer le personnage, il suffit d'utilser les lettres : \n\t- " +
                            "Q pour aller à gauche\n\t- S pour descendre\n\t- " +
                            "D pour aller à droite\n\t- Z pour monter\n"+
                            "\n ATTENTION : Sans potion de légèreté, une fois la case passé impossible d'y" +
                            "\n retourner, sous peine de perdre une vie. Vous avez 3 vies pour finir le niveau."+
                            "\n Si un ennemi est touché la partie est terminée."+
                            COLOR_RED+"\nGOOD LUCK"+COLOR_RESET);
                    startMenu();

                    break;
                case 2:
                    playGame(false, null);    //Jouer une partie à partir du niveau 1
                    break;
                case 3:
                    chooseTextFile();          //Recharge d'une partie
                    break;
                case 4:
                    System.out.println("QUITTER");   //Quitter
                    System.exit(0);
                    break;
            }
        }
        while (userSelected > 4);
    }

    public static int MenuData() {
        int selection = 0;

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

    /**
     *
     * @param isSavedLevel c'est un boolean, on sait si on veut recharger une map ou non
     * @param savedMap Map sauvegardé
     * @throws IOException traitement exception
     */
    public static void playGame(boolean isSavedLevel, Map savedMap) throws IOException {

      //Création des objets map
        Map mapLvl1 = new Map(ChargeMap.mapLVL1);
        Map mapLvl2 = new Map(ChargeMap.mapLVL2);
        Map mapLvl3 = new Map(ChargeMap.mapLVL3);
        Map mapLvl4 = new Map(ChargeMap.mapLVL4);
        Map mapLvl5 = new Map(ChargeMap.mapLVL5);

        while (lvlnumber <= 5) {            //Tant qu'on a pas terminé tous les niveaux

            if(isSavedLevel) {                  //Si on est sur une partie sauvegardé
                isSavedLevel = false;
                System.out.println("LEVEL "+ lvlnumber);
                PlayLevel(player,savedMap);
            }
            switch(lvlnumber){
                case 1:
                    System.out.println(COLOR_RED +"LEVEL 1 "+COLOR_RESET);
                    PlayLevel(player,mapLvl1);
                    break;
                case 2:
                    System.out.println(COLOR_RED +"LEVEL 2 "+COLOR_RESET);
                    PlayLevel(player,mapLvl2);
                    break;
                case 3:
                    System.out.println(COLOR_RED +"LEVEL 3 "+COLOR_RESET);
                    PlayLevel(player,mapLvl3);
                    break;
                case 4:
                    System.out.println(COLOR_RED +"LEVEL 4 "+COLOR_RESET);
                    PlayLevel(player,mapLvl4);
                    break;
                case 5:
                    System.out.println(COLOR_RED +"LEVEL 5 "+COLOR_RESET);
                    PlayLevel(player,mapLvl5);
                    System.out.println(COLOR_GREEN +"VOUS AVEZ GAGNE");
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     *
     * @param player objet Player
     * @param map objet Map
     * @throws IOException
     */
    private static void PlayLevel(Perso player, Map map) throws IOException {

        Level lvl = new Level(map, player);
        Scanner sc = new Scanner(System.in);

        try {

            while (!lvl.isOver() && !lvl.isDone()) {   // Si le niveau n'est pas terminé et jeu non terminé
                Affichage.afficher(map, player);
                System.out.println(COLOR_CYAN +"Lifes = " +
                        player.getLife() + " Waist time : " +
                        timer.secondPassed + " Score : " + player.getScore()+COLOR_RESET);
                System.out.println("----------------------------------------- 5 - QUITTER & SAUVEGARDER");
                System.out.println("Enter choice : ");
                char choice = sc.nextLine().charAt(0);


                if (choice == '5') {                                                   //Si appuie sur 5
                    System.out.print("entrez votre nom: ");
                    saveToTextFile(sc.nextLine(), map, player);                     //Sauvegarde du jeu
                    System.out.println(COLOR_GREEN +"LE JEU A ETE SAUVEGARDE");
                    System.exit(0);

                }
                lvl.movePerso(choice);
            }
            if (lvl.isDone()) {                           // Si le niveau est terminé
                player.setCurrentCase('o');
                player.setLife(3);                      //On remet les vies quand le niveau est terminé
                lvlnumber++;
                timer.secondPassed = 0;             //On remet le timer à 0
            }
            if(lvl.isDone() && timer.secondPassed < 15){
                lvl.Score();
            }


            if (lvl.isOver()) {                     // Si le niveau est perdu
                System.out.println(COLOR_RED +"GAME OVER");
                timer.secondPassed = 0;
                lvl.score = 0;
                System.exit(0);


            }
        } catch (IllegalStateException e) {
            System.out.println(" ");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(COLOR_RED +"Appuyer de nouveau"+COLOR_RESET);
            PlayLevel(player,map);
        }
    }
}
