package Controller;

import Model.Map;
import Model.Perso;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Save extends Play {
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
