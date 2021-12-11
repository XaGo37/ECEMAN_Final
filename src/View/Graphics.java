package View;

import Controller.Map;
import Model.ChargeMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Graphics extends JFrame {

    private ImageIcon wall;
    private ImageIcon water;
    private ImageIcon glace;
    private ImageIcon perso;
    private ImageIcon arrival;
    private ImageIcon background;
    private ImageIcon background1;
    Map map = new Map(ChargeMap.mapLVL1);

    public Graphics() {
        PrintFrame();
    }

    public void PrintFrame() {

        JFrame frame = new JFrame("ECEMAN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);

        JPanel panel = new JPanel(new GridLayout(10, 19,0,0));

        JLabel label = new JLabel();

        wall = new ImageIcon("src/img/mur.PNG");
        water = new ImageIcon("src/img/eau.PNG");
        glace = new ImageIcon("src/img/glace.PNG");
        perso = new ImageIcon("src/img/penguin.gif");
        arrival = new ImageIcon("src/img/sortie.PNG");
        background = new ImageIcon("src/img/background.png");
        background1  = new ImageIcon("src/img/unnamed.png");
        if(map != null){
            for (int i = 0; i < map.getSizeY(); i++) {
                for (int j = 0; j < map.getSizeX(); j++) {
                    if (map.getCase(i, j) == '#') {
                        label = new JLabel(background1);
                        panel.add(label);
                    }
                    if (map.getCase(i, j) == 'M') {
                        label = new JLabel(wall);
                        panel.add(label);
                    }
                    if (map.getCase(i, j) == 'P') {
                        label = new JLabel(perso);
                        panel.add(label);
                    }
                    if (map.getCase(i, j) == 'o') {
                        label = new JLabel(glace);
                        panel.add(label);
                    }
                    if (map.getCase(i, j) == ' ') {
                        label = new JLabel(water);
                        panel.add(label);
                    }
                    if (map.getCase(i, j) == 'E') {
                        label = new JLabel(arrival);
                        panel.add(label);
                    }
                }
        }
        frame.setContentPane(panel);
        frame.setVisible(true);

    }}


}

