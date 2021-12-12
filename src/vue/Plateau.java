/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import static controleur.Enregistrement.saveToTextFile;
import controleur.Level;
import controleur.Play;
import modele.ChargeMap;
import modele.Map;
import modele.Perso;
import modele.ChargerMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Scanner;


public class Plateau extends JFrame {

    Map map = new Map(ChargeMap.mapLVL1);
    Model.Perso player = new Perso(0, 0);
    Level level = new Level(map,player);
    
    private int heure = 0, minute = 0, seconde = 0;
    private int delais = 1000;
    private JLabel labelChrono = new JLabel(" " + heure + " : " + minute + " : " + seconde);
    private JLabel imageVie1 = new JLabel();
    private JLabel imageVie2 = new JLabel();
    private JLabel imageVie3 = new JLabel();
    private ActionListener tache_timer;
    public Timer timer1;
    
    public Timer getTimer(){
        return this.timer1;
    }

    public Plateau() {
        
        //addKeyListener(new Level(map,perso));
        
        JPanel content = new JPanel();
        JLabel image = new JLabel();
        JLabel labelLife = new JLabel();
        JLabel labelLevel = new JLabel();
        JLabel tempsEcoule = new JLabel();
        JButton boutonReset = new JButton();
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(970, 900);
        
        imageVie1.setIcon(new ImageIcon(getClass().getResource("/images/coeur.png")));
        getContentPane().add(imageVie1);
        imageVie1.setBounds(800, 5, 30, 50);
        
        imageVie2.setIcon(new ImageIcon(getClass().getResource("/images/coeur.png")));
        getContentPane().add(imageVie2);
        imageVie2.setBounds(831, 5, 30, 50);
        
        imageVie3.setIcon(new ImageIcon(getClass().getResource("/images/coeur.png")));
        getContentPane().add(imageVie3);
        imageVie3.setBounds(862, 5, 30, 50);
        
        tempsEcoule.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        tempsEcoule.setForeground(Color.BLUE);
        tempsEcoule.setText("Temps écoulé :");
        
        labelChrono.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        labelChrono.setForeground(Color.BLUE);
        
        labelLife.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        labelLife.setForeground(Color.BLUE);
        labelLife.setText("Lifes :");
        
        labelLevel.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        labelLevel.setForeground(Color.BLUE);
        labelLevel.setText("LEVEL");
        
        boutonReset.setFont(new Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        boutonReset.setForeground(new Color(255, 255, 255));
        boutonReset.setText("RESET");
        boutonReset.setBorder(null);      
        boutonReset.setBackground(new Color(0, 0, 250));
        boutonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boutonResetActionPerformed(e);
            }
        });
        
        JPanel panel = new JPanel(new GridLayout(17, 19, 0, 0));
        
        ImageIcon Glace = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\glace.png");
        ImageIcon Mur = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\mur.png");
        ImageIcon Pingouin = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\perso.png");
        ImageIcon Sortie = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\sortie.png");
        ImageIcon Banquise = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\banquise.png");
        ImageIcon Contour = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\contour.png");
        ImageIcon Eau = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\eau.png");
        
        if(map != null){
            for (int i = 0; i < map.getSizeY(); i++) {
                for (int j = 0; j < map.getSizeX(); j++) {
                    if (map.getCase(i, j) == '#') {
                        image = new JLabel(Glace);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == 'M') {
                        image = new JLabel(Mur);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == 'P') {
                        image = new JLabel(Pingouin);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == 'o') {
                        image = new JLabel(Banquise);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == ' ') {
                        image = new JLabel(Eau);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == 'E') {
                        image = new JLabel(Sortie);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == '&') {
                        image = new JLabel(Contour);
                        panel.add(image);
                    }
                }
        }
            
        content.add(panel);
        
        getContentPane().add(boutonReset);
        boutonReset.setBounds(30, 810, 130, 40);
        
        getContentPane().add(labelChrono);
        labelChrono.setBounds(830, 810, 100, 40);
	chrono();
        
        getContentPane().add(labelLife);
        labelLife.setBounds(720, 10, 70, 40);
        
        getContentPane().add(labelLevel);
        labelLevel.setBounds(30, 10, 100, 40);
        
        getContentPane().add(tempsEcoule);
        tempsEcoule.setBounds(640, 810, 200, 40);
        
        getContentPane().add(content, BorderLayout.CENTER); 
    }
    }
    
    private void boutonResetActionPerformed(ActionEvent e) {  
        timer1.stop();
        FenetreReset maFenetre = new FenetreReset();
        maFenetre.setVisible(true);
    }
    
    public void chrono(){
        tache_timer = new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                seconde++;
                if (seconde == 60) {
                    seconde = 0;
                    minute++;
                }
                if (minute == 60) {
                    minute = 0;
                    heure++;
                }
                //Afficher le chrono dans un JLabel
                labelChrono.setText(heure + " : " + minute + " : " + seconde);

            }
        };
        //Action et temps execution de la tache
        timer1 = new Timer(delais, tache_timer);
        //Demarrer le chrono
        timer1.start();
    }


    @Override
    protected void processKeyEvent(KeyEvent ke) {
        Scanner sc = new Scanner(System.in);
        try{
            if (ke.getID() != KeyEvent.KEY_PRESSED || level.isDone()) {
            return;
        }
            level.movePerso(ke.getKeyCode());
            System.out.println("Lifes = " + player.getLife());
            repaint();

            if(ke.getKeyCode()==16){
                System.out.print("entrez votre nom: ");
                saveToTextFile(sc.nextLine(), map, player);
                System.out.println("LE JEU A ETE SAUVEGARDE");
                System.exit(0);
            }


            if (level.isDone()) {
                player.setCurrentCase('o');
                player.setLife(3); // remet les vies quand le niveau est terminé
                Play.lvlnumber++;
                JOptionPane.showMessageDialog(this, "Congratulations ! Level cleared !");
            }

            if (level.isOver()) {
                System.out.println("LOOSER");
                JOptionPane.showMessageDialog(this, "LOOSER");
                System.exit(0);

            }


        } catch (NullPointerException error){
            System.out.println("ERREUR");
        }
    }
}

    
   
    

