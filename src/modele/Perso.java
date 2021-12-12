package modele;


/**
 * Classe Perso
 */
public class Perso {

    private int xPerso;
    private int yPerso;
    private int score = 10;

    private char currentCase = 'o';
    private boolean islight = false;
    private int life = 3;

    public Perso(int x, int y){
        xPerso = x;
        yPerso = y;
    }

    public void initPerso() {
        currentCase = 'o';
        islight = false;
    }

    //Getter
    public int getxPerso() {
        return xPerso;
    }
    public void setxPerso(int xPerso) {
        this.xPerso = xPerso;
    }

    //Setter
    public int getyPerso() {
        return yPerso;
    }
    public void setyPerso(int yPerso) {
        this.yPerso = yPerso;
    }

    public int []GetCoords(){
        return new int[]{xPerso, yPerso};
    }

    public void setCoords(int x,int y){
        xPerso = x;
        yPerso = y;
    }


    public char getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(char currentCase) {
        this.currentCase = currentCase;
    }

    public boolean isIslight() {
        return islight;
    }

    public void setIslight(boolean islight) {
        this.islight = islight;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
