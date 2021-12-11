package Controller;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard extends Level implements KeyListener {


    public Keyboard(Map map, Perso perso) {
        super(map, perso);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int tempPosX = perso.getxPerso();
        int tempPosY = perso.getyPerso();
        char tempCurrentCase = perso.getCurrentCase();
        boolean playerMoved = false;

        int key = e.getKeyCode();

        if(key== KeyEvent.VK_Z){
            if (Level.testBlock(perso.getxPerso() - 1, perso.getyPerso())) {
                perso.setCurrentCase(map.getCase(tempPosX - 1, tempPosY));
                perso.setxPerso(perso.getxPerso() - 1);
                map.setCase(perso.getxPerso(), perso.getyPerso(), 'P');
                playerMoved = true;
                return;

            }
        }
        if(key== KeyEvent.VK_S){
            if (testBlock(perso.getxPerso() + 1, perso.getyPerso())) {
                perso.setCurrentCase(map.getCase(tempPosX + 1, tempPosY));
                perso.setxPerso(perso.getxPerso() + 1);
                map.setCase(perso.getxPerso(), perso.getyPerso(), 'P');
                playerMoved = true;
                return;

            }
        }
        if(key== KeyEvent.VK_Q){
            if (testBlock(perso.getxPerso(), perso.getyPerso() - 1)) {
                perso.setCurrentCase(map.getCase(tempPosX, tempPosY - 1));
                perso.setyPerso(perso.getyPerso() - 1);
                map.setCase(perso.getxPerso(), perso.getyPerso(), 'P');
                playerMoved = true;
                return;

            }
        }
        if(key== KeyEvent.VK_D){
            if (testBlock(perso.getxPerso(), perso.getyPerso() + 1)) {
                perso.setCurrentCase(map.getCase(tempPosX, tempPosY + 1));
                perso.setyPerso(perso.getyPerso() + 1);
                map.setCase(perso.getxPerso(), perso.getyPerso(), 'P');
                playerMoved = true;
                return;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
