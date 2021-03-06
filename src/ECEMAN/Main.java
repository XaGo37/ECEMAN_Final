package ECEMAN;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    private static char[][] mapLVL1 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'M', 'P', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'E', 'o', 'o', 'o', 'M'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};


    private static char[][] mapLVL2 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'M', 'P', 'o', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'o', 'o', 'E', 'M'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};


    private static char[][] mapLVL3 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'M', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'E', 'o', 'M'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'o', 'o', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'#', '#', '#', '#', '#', '#', '#', '#', 'M', 'o', 'o', 'M', '#', '#', '#', '#', '#', '#', '#'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'o', 'o', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'M', 'P', 'o', 'o', 'o', 'o', 'o', 'o', 'L', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'M'},
            {'M', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'M'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

    private static char[][] mapLVL4 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'M', 'T', 'o', 'o', 'o', 'o', 'o', 'E', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'M'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'M', 'P', 'o', 'T', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'X', 'o', 'M'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

    private static char[][] mapLVL5 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'M', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'E', 'o', 'M'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'o', 'o', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'#', '#', '#', '#', '#', '#', '#', '#', 'M', 'o', 'o', 'M', '#', '#', '#', '#', '#', '#', '#'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'o', 'o', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'M', 'P', 'o', 'o', 'o', 'o', 'o', 'o', 'L', 'o', '<', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'M'},
            {'M', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'M'},
            {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};


    private static Perso player = new Perso(0, 0);
    private static int lvlnumber = 1;

    public static void main(String[] args) throws IOException {


        int userSelected;
        do {
            userSelected = MenuData();
            switch (userSelected) {
                case 1:
                    System.out.println("Voici les r??gles du jeu :");
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

    private static void chooseTextFile() {
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
        Map mapLvl1 = new Map(mapLVL1);
        Map mapLvl2 = new Map(mapLVL2);
        Map mapLvl3 = new Map(mapLVL3);
        Map mapLvl4 = new Map(mapLVL4);

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
            player.setLife(3); // remet les vies quand le niveau est termin??
            lvlnumber++;
        }
        if (lvl.isOver()) {
            System.out.println("LOOSER");
            System.exit(0);
        }
    }


    public static void saveToTextFile(String fileName, Map map, Perso perso) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/TextFile/"+fileName+".txt")));

            for (int i = 0; i < map.getMap().length; i++) {
                for (int j = 0; j < map.getMap()[i].length; j++) {
                    writer.write(map.getMap()[i][j] + "");
                }

                writer.newLine();
            }
            writer.write("DATA\n");
            writer.write("level:"+lvlnumber + "\n");
            writer.write("x:"+perso.getxPerso() + "\n");
            writer.write("y:"+perso.getyPerso() + "\n");
            writer.write("case:"+perso.getCurrentCase() + "\n");
            writer.write("isLight:"+perso.isIslight() + "\n");
            writer.write("lifes:"+perso.getLife() + "\n");
            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void readTextFile(String filename) {

    /*    try{
            BufferedReader reader = Files.newBufferedReader(Path.of("src/TextFile/" + filename + ".txt"));
            int sizeY = reader.readLine().length();
            int sizeX = 1;
            for (String line = reader.readLine(); !line.equals("DATA"); line = reader.readLine()) {
                sizeX++;
            }
            char[][] map = new char[sizeX][sizeY];
            reader = Files.newBufferedReader(Path.of("src/TextFile/" + filename + ".txt"));
            int i = 0;
            for (String line = reader.readLine(); !line.equals("DATA"); line = reader.readLine()) {
                for(int j = 0; j < line.length(); j++){
                    map[i][j] = line.charAt(j);
                }
                i++;
            }
            lvlnumber = Integer.parseInt(reader.readLine().split(":")[1]);
            player.setxPerso(Integer.parseInt(reader.readLine().split(":")[1]));
            player.setyPerso(Integer.parseInt(reader.readLine().split(":")[1]));
            player.setCurrentCase(reader.readLine().split(":")[1].charAt(0));
            if (reader.readLine().split(":")[1].equals("false")) {
                player.setIslight(false);
            } else {
                player.setIslight(true);
            }
            player.setLife(Integer.parseInt(reader.readLine().split(":")[1]));
            playGame(true, new Map(map));
        } catch (IOException e) {
            System.out.println("Cette sauvegarde n'existe pas \n");
            chooseTextFile();
        }*/
    }
}

