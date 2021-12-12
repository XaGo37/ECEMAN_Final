package controleur;

import Model.Enemy;
import Model.Map;
import Model.Perso;

import java.util.Random;

public class Level  {

    /**
     * Création des objets
     */
    private Map map;
    private Map startMap;
    private static Perso perso;
    static CountTime timer = new CountTime();
    private Enemy enemy = new Enemy(0,0);


    private boolean isDone = false;
    private boolean isOver = false;

    static int score = 10;

    /**
     *
     * @param map Objet Map
     * @param perso Objet Perso
     * Constructeur Level
     */
    public Level(Map map, Perso perso) {
        this.map = map;
        this.startMap = new Map(map.getMap().clone()); //Map de départ
        this.perso = perso;
        startLevel();
    }

    /**
     * Placement du player 'P'
     */
    private void startLevel() {
        this.map.setMap(startMap.getMap());
        perso.initPerso();
        for (int i = 0; i < map.getSizeY(); i++) {          //Parcourir la map en X et Y jusqu'à trouver un 'P'
            for (int j = 0; j < map.getSizeX(); j++) {
                if (map.getCase(i, j) == 'P') {
                    perso.setCoords(i, j);
                }
            }
        }
    }

    public void moveEnemy(){   //Déplacement enemie mais sans réussite
        int tempPosX = enemy.getXEnemy();
        int tempPosY = enemy.getyEnemy();
        char tempCurrentCase = enemy.getCurrentEnemyCase();
        Random rand = new Random();
        int move = rand.nextInt(4);
        System.out.println(move);
        boolean enemyMoved = false;
        switch(move){
            case 1 :
                if (testBlock(enemy.getXEnemy()-1, enemy.getyEnemy())) {
                    enemy.setCurrentEnemyCase(map.getEnemyCase(tempPosX - 1, tempPosY));
                    enemy.setxEnemy(enemy.getXEnemy() - 1);
                    map.setEnemyCase(enemy.getXEnemy(), enemy.getyEnemy(), '>');
                    enemyMoved = true;
                }
                break;
            case 2 :
                if (testBlock(enemy.getXEnemy()+1, enemy.getyEnemy())) {
                    enemy.setCurrentEnemyCase(map.getEnemyCase(tempPosX + 1, tempPosY));
                    enemy.setxEnemy(enemy.getXEnemy()+1);
                    map.setEnemyCase(enemy.getXEnemy(), enemy.getyEnemy(), '>');
                    enemyMoved = true;
                }
                break;
            case 3 :
                if (testBlock(enemy.getXEnemy(), enemy.getyEnemy()-1)) {
                    enemy.setCurrentEnemyCase(map.getEnemyCase(tempPosX, tempPosY - 1));
                    enemy.setxEnemy(enemy.getyEnemy() - 1);
                    map.setEnemyCase(enemy.getXEnemy(), enemy.getyEnemy(), '>');
                    enemyMoved = true;
                }
                break;
            case 4 :
                if (testBlock(enemy.getXEnemy(), enemy.getyEnemy()+1)) {
                    enemy.setCurrentEnemyCase(map.getEnemyCase(tempPosX, tempPosY + 1));
                    enemy.setxEnemy(enemy.getyEnemy() + 1);
                    map.setEnemyCase(enemy.getXEnemy(), enemy.getyEnemy(), '>');
                    enemyMoved = true;
                    break;
                }
                if(enemyMoved == true) {
                    changeCase(tempCurrentCase, tempPosX, tempPosY);
                }
        }

    }

    /**
     *
     * @param direction depuis scanner c'est la touche sur laquelle on appuie
     * Methode permettant de déplacer le player selon la direction
     */
    public void movePerso(char direction) {

        int tempPosX = perso.getxPerso();
        int tempPosY = perso.getyPerso();
        char tempCurrentCase = perso.getCurrentCase();
        boolean playerMoved = false;

        switch (direction) {   //Entrer via scanner une touche z,s,q,d
            case 'z':
                if (testBlock(perso.getxPerso() - 1, perso.getyPerso())) {       //Si on peut bouger sur le block
                    perso.setCurrentCase(map.getCase(tempPosX - 1, tempPosY));   //Récupération de la case X-1
                    perso.setxPerso(perso.getxPerso() - 1);                         //Deplacement du perso X-1
                    map.setCase(perso.getxPerso(), perso.getyPerso(), 'P'); //Remplacement de la case par 'P'
                    playerMoved = true;
                }
                break;
            case 's':
                if (testBlock(perso.getxPerso() + 1, perso.getyPerso())) {      //Si on peut bouger sur le block
                    perso.setCurrentCase(map.getCase(tempPosX + 1, tempPosY));  //Récupération de la case X+1
                    perso.setxPerso(perso.getxPerso() + 1);                        //Deplacement du perso X+1
                    map.setCase(perso.getxPerso(), perso.getyPerso(), 'P');//Remplacement de la case par 'P'
                    playerMoved = true;

                }
                break;
            case 'q':
                if (testBlock(perso.getxPerso(), perso.getyPerso() - 1)) {  // Même principe qu'au dessus mais en Y
                    perso.setCurrentCase(map.getCase(tempPosX, tempPosY - 1));
                    perso.setyPerso(perso.getyPerso() - 1);
                    map.setCase(perso.getxPerso(), perso.getyPerso(), 'P');
                    playerMoved = true;
                }
                break;
            case 'd':
                if (testBlock(perso.getxPerso(), perso.getyPerso() + 1)) {
                    perso.setCurrentCase(map.getCase(tempPosX, tempPosY + 1));
                    perso.setyPerso(perso.getyPerso() + 1);
                    map.setCase(perso.getxPerso(), perso.getyPerso(), 'P');
                    playerMoved = true;
                }
        }

        if(perso.getCurrentCase() =='<'){
            setOver(true);
        }
        if(playerMoved == true && perso.getCurrentCase() == 'T'){  //Si le player a bougé et on est sur une case téléportation
            teleportPerso(perso.getxPerso(), perso.getyPerso());
        }
        if(playerMoved == true) { //Si player a bougé, appel de la méthode changeCase
            changeCase(tempCurrentCase, tempPosX, tempPosY);
        }
    }

    /**
     *
     * Méthode non nécessaire au fonctionnement car niveau 5 non terminé
     * @param currentEnemyCase
     * @param x
     * @param y
     * Changement de case, pénalité pour le player
     */

    private void changeEnemyCase(char currentEnemyCase, int x, int y){
        switch(currentEnemyCase){
            case 'T' :                             //TELEPORTEUR, si enemie dessus le joueur ne pourrais pas y aller
                map.setEnemyCase(x,y,'t');     //T devient t
                break;
            case 'L' : //LEGERETE
                map.setEnemyCase(x,y,'o');
                break;
            default :
                map.setEnemyCase(x,y,currentEnemyCase);
                break;
        }
    }

    /**
     * Méthode permetant la modification des cases après passage player
     * @param currentCase case sur laquelle on se trouve
     * @param x position x sur laquelle on se trouve
     * @param y position y sur laquelle on se trouve
     */
    private void changeCase(char currentCase, int x, int y){
        if(perso.getCurrentCase() == 'E') {         //Si on est sur arrivé sur 'E' niveau terminé
            setDone(true);
        }
        if (perso.getCurrentCase() == ' ') {        //Si on passe sur de l'eau, vie-1
            perso.setLife(perso.getLife() - 1);
            if (perso.getLife() <= 0) {             //Si on a 0 vies level is Over
                setOver(true);
            } else {
                startLevel();
            }
        }
        if(perso.isIslight()==true){
            map.setCase(x,y,currentCase);
            return;
        }
        switch(currentCase){            //Remplacement des cases
            case 'o' :
                map.setCase(x,y,' ');       //Si on passe sur 'o' remplacement par ' ' -> eau
                break;
            case 'X' : // GLACE EPAISSE
                map.setCase(x,y,'o');
                break;
            case 'T' : //TELEPORTEUR
                map.setCase(x,y,'t');
                break;
            case 'L' : //LEGERETE
                map.setCase(x,y,'o');
                perso.setIslight(true);
                break;
            case 'Z':
                break;
            default :
                map.setCase(x,y,currentCase);
                break;
        }
    }

    public static int Score(){        //Création du score
        score= perso.getScore();
        perso.setScore(score*10);
        if(perso.getCurrentCase() == 'E' && timer.secondPassed < 10){ //Si on termine un niveau en moins de 10 sec
            perso.setScore(perso.getScore()*10);

        }
        return perso.getScore();
    }


    /**
     * Téléportation du perso
     * @param x position x sur laquelle on se trouve
     * @param y position y sur laquelle on se trouve
     */

    private void teleportPerso(int x, int y) {
        int tempPosX = perso.getxPerso();
        int tempPosY = perso.getyPerso();
        changeCase('T', tempPosX,tempPosY);
        for (int i = 0; i < map.getSizeY(); i++) {              //Parcours de la map
            for (int j = 0; j < map.getSizeX(); j++) {
                if (map.getCase(i, j) == 'T' && !(i == x && j==y)) {
                    perso.setCoords(i, j);
                    map.setCase(perso.getxPerso(), perso.getyPerso(), 'P');
                }
            }
        }
    }


    /**
     * Test des block, regarde les énumérations
     * @param x
     * @param y
     * @return
     */
    private boolean testBlock(int x, int y) {
        for (PassableBlocks passBlock : PassableBlocks.values()) {
            if (map.getCase(x, y) == passBlock.asChar()) {  //Si block passable on renvoit true
                return true;
            }
        }
        return false;               //Si block non passable on renvoit false
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }
}
