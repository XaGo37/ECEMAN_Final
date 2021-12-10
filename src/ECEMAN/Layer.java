package ECEMAN;


public class Layer { //Tableau 1

    private char[][] layer;

    public Layer(char[][]layer){
        this.layer = layer;
    }

    public char[][] getLayer() {
        return layer;
    }
    public void setLayer(char[][] layer) {
        this.layer = layer;
    }
    public char getCase(int x, int y){
        return layer[x][y];
    }
    public int getSizeX(){
        return layer[0].length;
    }
    public int getSizeY(){
        return layer.length;
    }
    public void setCase(int x, int y, char carCase){
        layer[x][y] = carCase;
    }

    //Set Layer case
}
