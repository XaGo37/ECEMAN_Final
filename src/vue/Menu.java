/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author dijou
 */
public class Menu extends JFrame {                               //On crée une fenêtre Menu d'accueil avec différents boutons
    private JButton boutonQuitter = new JButton();               //On créé tous les boutons, label, sous-menu qu'on a besoin pour notre menu
    private JLabel imageBackground = new JLabel();
    private JMenu menuJouer = new JMenu();
    private JMenu menuRegles = new JMenu();
    private JMenuBar barreMenu = new JMenuBar();
    private JMenuItem sousMenu1 = new JMenuItem();
    private JMenuItem sousMenu2 = new JMenuItem();
    private JMenuItem sousMenuScores = new JMenuItem();
    
    public Menu() {
        initialisation();
    }
                         
    private void initialisation() {                               //On crée une méthode initialisation qui va nous créer le menu

        setDefaultCloseOperation(EXIT_ON_CLOSE);                  //On définit les caractéristiques de la JFrame
        setPreferredSize(new Dimension(1000, 692));
        setResizable(false);
        getContentPane().setLayout(null);

        boutonQuitter.setFont(new Font("Microsoft Sans Serif", 1, 18));    //On définit des caractéristiques à notre boutonQuitter (texte, police, couleur...)
        boutonQuitter.setForeground(new Color(255, 255, 255));
        boutonQuitter.setText("Quitter");
        boutonQuitter.setBorder(null);
        boutonQuitter.setBorderPainted(false);
        boutonQuitter.setContentAreaFilled(false);
        boutonQuitter.setOpaque(false);
        boutonQuitter.addActionListener(new ActionListener() {            //On lui affecte une action 
            @Override
            public void actionPerformed(ActionEvent e) {
                boutonQuitterActionPerformed(e);
            }
        });
        getContentPane().add(boutonQuitter);
        boutonQuitter.setBounds(759, 555, 130, 50);

        imageBackground.setIcon(new ImageIcon(getClass().getResource("/images/ThinIce.png")));     //On définit des caractéristiques à notre image de fond (taille...)
        getContentPane().add(imageBackground);
        imageBackground.setBounds(0, 0, 1000, 660);

        menuJouer.setText("Jouer");               //On ajoute le titre de notre menu Jouer

        sousMenu1.setText("Nouvelle Partie");     //On ajoute le titre de notre sous menu Nouvelle Partie
        sousMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           //On lui affecte une action 
                sousMenu1ActionPerformed(e);
            }
        });
        barreMenu.add(menuJouer);              //On ajoute notre menu Jouer à notre menuBarre
        menuJouer.add(sousMenu1);              //On ajoute notre sous_menu1 au menu Jouer

        sousMenu2.setText("Reprendre une Partie");
        sousMenu2.addActionListener(new ActionListener() {         //On lui affecte une action 
            @Override
            public void actionPerformed(ActionEvent e) {
                sousMenu2ActionPerformed(e);
            }
        });
        menuJouer.add(sousMenu2);          //On ajoute notre sous_menu2 à notre menu Jouer

        sousMenuScores.setText("Score");
        sousMenuScores.addActionListener(new ActionListener() {          //On lui affecte une action 
            @Override
            public void actionPerformed(ActionEvent e) {
                sousMenuScoresActionPerformed(e);
            }
        });
        menuJouer.add(sousMenuScores);        //On ajoute notre sousMenuScores au menu Jouer

        menuRegles.setText("Règles");
        menuRegles.addMouseListener(new MouseAdapter() {              //On lui affecte une action 
            @Override
            public void mouseClicked(MouseEvent evt) {
                menuReglesMouseClicked(evt);
            }
        });
        barreMenu.add(menuRegles);

        setJMenuBar(barreMenu);        
        
        pack();
    }                     

    private void boutonQuitterActionPerformed(ActionEvent e) {       //Cette méthode permet de réaliser une action lorsqu'on appuie sur le boutonQuitter                                  
        this.dispose();
    }                                                                           

    private void menuReglesMouseClicked(MouseEvent evt) {            //Cette méthode permet de réaliser une action lorsqu'on appuie sur le menuRegles                   
        Regles mesRegles = new Regles();
        mesRegles.setVisible(true);
    }  
    
    private void sousMenu1ActionPerformed(ActionEvent e) {          //Cette méthode permet de réaliser une action lorsqu'on appuie sur le sousMenu1                        
        NouvellePartie monJoueur = new NouvellePartie();
        monJoueur.setVisible(true);
        //Menu monMenu = new Menu();
        //monMenu.setVisible(false);
    } 
    
    private void sousMenu2ActionPerformed(ActionEvent e) {          //Cette méthode permet de réaliser une action lorsqu'on appuie sur le sousMenu2                    
        ReprendrePartie monJoueur = new ReprendrePartie();
        monJoueur.setVisible(true);
    } 
    
    private void sousMenuScoresActionPerformed(ActionEvent e) {      //Cette méthode permet de réaliser une action lorsqu'on appuie sur le sousMenuScores                            
        TableauScores monTableau = new TableauScores();
        monTableau.setVisible(true);
    } 
}
