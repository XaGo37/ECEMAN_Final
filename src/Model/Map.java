package Model;

import java.util.ArrayList;

public class Map {
    private char[][] map;
    private char [][] map1;

    public Map(char[][]map){
        setMap(map);
    }
    public char[][] getMap(){
        return this.map;
    }

    public void setMap(char[][] map) {
        this.map = new char[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                this.map[i][j] = map[i][j];
            }
        }
    }

    public char getCase(int x, int y){
        return map[x][y];
    }
    public int getSizeX(){
        return map[1].length;
    }
    public int getSizeY(){
        return map.length;
    }
    public void setCase(int x, int y, char carCase){
        map[x][y] = carCase;
    }

    public char getEnemyCase(int x, int y){
        return map[x][y];
    }
    public void setEnemyCase(int x, int y, char carCase){
        map[x][y] = carCase;
    }
}


