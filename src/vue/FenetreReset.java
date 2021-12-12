/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;

public class FenetreReset extends JFrame{                     
    
    public FenetreReset(){                                        //On crée une fenêtre Reset avec 3 boutons correspondant à 3 possibilités
        CardLayout cardL = new CardLayout();
        JPanel content = new JPanel();                            //On crée l'objet content qui est un panel
        JLabel labelTitre = new JLabel();                         //On créé l'objet labelTitre qui est un label
        JButton boutonReprendre = new JButton();                  //On créé trois boutons Reprendre, Recommencer et Eregistrer
        JButton boutonRecommencer = new JButton();
        JButton boutonEnregistrer = new JButton();

       
        setSize(740, 200);                                        //On définit les caractéristiques de notre JFrame (taille...)
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0d, 0d, 740d, 200d, 25d, 25d));
                   
        JPanel pan1 = new JPanel();                                       //On crée l'objet pan1 qui est un autre panel
        pan1.setBackground(new Color(102, 204, 255));                     //On lui affecte une couleur de fond
        
        labelTitre.setFont(new Font("Microsoft Sans Serif", 0, 24));     //On définit des caractéristiques à notre labelTitre (texte, police, couleur...)
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setText("Que souhaitez-vous faire ?");
        
        boutonReprendre.setFont(new Font("Microsoft Sans Serif", 0, 20)); // On définit des caractéristiques à notre boutonReprendre (texte, police, couleur...)
        boutonReprendre.setForeground(new Color(0, 0, 0));
        boutonReprendre.setText("Reprendre la partie");
        boutonReprendre.setBorder(null);    
        boutonReprendre.setBackground(new Color(250, 250, 250));
        boutonReprendre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boutonReprendreActionPerformed(e);                        //On lui affecte une action 
            }
        });
        
        boutonRecommencer.setFont(new Font("Microsoft Sans Serif", 0, 20)); // On définit des caractéristiques à notre boutonRecommencer (texte, police, couleur...)
        boutonRecommencer.setForeground(new Color(0, 0, 0));
        boutonRecommencer.setText("Recommencer le niveau");
        boutonRecommencer.setBorder(null);    
        boutonRecommencer.setBackground(new Color(250, 250, 250));
        boutonRecommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boutonRecommencerActionPerformed(e);                       //On lui affecte une action 
            }
        });
        
        boutonEnregistrer.setFont(new Font("Microsoft Sans Serif", 0, 20)); // On définit des caractéristiques à notre boutonEnregistrer(texte, police, couleur...)
        boutonEnregistrer.setForeground(new Color(0, 0, 0));
        boutonEnregistrer.setText("Enregistrer et Quitter");
        boutonEnregistrer.setBorder(null);    
        boutonEnregistrer.setBackground(new Color(250, 250, 250));
        boutonEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boutonEnregistrerActionPerformed(e);                      //On lui affecte une action 
            }
        });
        
        content.add(pan1);
        content.setLayout(cardL);                                        //On ajoute notre panel pan1 à l'autre panel content
        
        getContentPane().add(labelTitre);                                //On ajoute notre labelTitre à notre panel Content
        labelTitre.setBounds(220, 20, 500, 60);                          //On définit sa taille et sa position sur le panel
        
        getContentPane().add(boutonReprendre);                           //On ajoute notre boutonReprendre à notre panel Content 
        boutonReprendre.setBounds(20, 125, 200, 50);                    //On définit sa taille et sa position sur le panel
        
        getContentPane().add(boutonRecommencer);                        //On ajoute notre boutonRecommencer à notre panel Content
        boutonRecommencer.setBounds(240, 125, 250, 50);                 //On définit sa taille et sa position sur le panel
        
        getContentPane().add(boutonEnregistrer);                         //On ajoute notre boutonEnregistrer à notre panel Content
        boutonEnregistrer.setBounds(510, 125, 210, 50);                  //On définit sa taille et sa position sur le panel
        
        getContentPane().add(content, BorderLayout.CENTER); 

    }
    
    private void boutonReprendreActionPerformed(ActionEvent e) {       //Cette méthode permet de fermer la fenetre et relancer le timer
        Plateau mp = new Plateau();
        mp.chrono();
        this.dispose();
    }
    
    private void boutonRecommencerActionPerformed(ActionEvent e) {      //Cette méthode permet de réaliser une action lorsqu'on appuie sur le boutonRecommencer                            
        
    }
    
    private void boutonEnregistrerActionPerformed(ActionEvent e) {       //Cette méthode permet de fermer la fenetre                            
        JOptionPane.showMessageDialog(null , "Votre partie a bien été enregistré");
        this.dispose();
    }
}
