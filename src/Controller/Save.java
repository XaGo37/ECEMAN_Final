package Controller;

import Model.Map;
import Model.Perso;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Save extends Play {

    /**
     * Sélection d'une partie
     */
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

    /**
     * Sauvegarde d'une partie
     * @param fileName Nom du fichier .txt
     * @param map objet Map
     * @param perso objet perso
     */
    public static void saveToTextFile(String fileName, Map map, Perso perso) { //Sauvegarde d'une partie

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/TextFile/"+fileName+".txt")));

            for (int i = 0; i < map.getMap().length; i++) {
                for (int j = 0; j < map.getMap()[i].length; j++) {
                    writer.write(map.getMap()[i][j] + "");
                }
                writer.newLine();
            }
            writer.write("DATA\n");
            writer.write("level:"+Play.lvlnumber + "\n");
            writer.write("x:"+perso.getxPerso() + "\n");
            writer.write("y:"+perso.getyPerso() + "\n");
            writer.write("case:"+perso.getCurrentCase() + "\n");
            writer.write("isLight:"+perso.isIslight() + "\n");
            writer.write("lifes:"+perso.getLife() + "\n");
            writer.write("score:"+perso.getScore() + "\n");

            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * On vient lire toutes les informations sauvegardées
     * @param filename Nom du fichier .txt
     */
    public static void readTextFile(String filename) {

        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get("src/TextFile/" + filename + ".txt"));
            int sizeY = reader.readLine().length();
            int sizeX = 1;
            for (String line = reader.readLine(); !line.equals("DATA"); line = reader.readLine()) {
                sizeX++;
            }
            char[][] map = new char[sizeX][sizeY];
            reader = Files.newBufferedReader(Paths.get("src/TextFile/" + filename + ".txt"));
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
            player.setScore(Integer.parseInt(reader.readLine().split(":")[1]));
            playGame(true, new Map(map));
        } catch (IOException e) {
            System.out.println("Cette sauvegarde n'existe pas \n");
            chooseTextFile();
        }

    }

}
