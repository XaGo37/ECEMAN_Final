/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.RoundRectangle2D;
import java.nio.file.Files;
import javax.swing.*;

/**
 *
 * @author dijou
 */
public class ReprendrePartie extends JFrame{
    
    JTextPane pseudoJoueur = new JTextPane();
 
    public ReprendrePartie(){
        CardLayout cardL = new CardLayout();
        JPanel content = new JPanel();
        JLabel labelTitre = new JLabel();
        JButton boutonOK = new JButton();
         
        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0d, 0d, 400d, 200d, 25d, 25d));
                   
        JPanel pan1 = new JPanel();
        pan1.setBackground(new Color(102, 204, 255)); 
        
        labelTitre.setFont(new Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setText("Quel était votre ancien pseudo ?");
        
        boutonOK.setFont(new Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        boutonOK.setForeground(new Color(0, 0, 0));
        boutonOK.setText("OK");
        boutonOK.setBorder(null);    
        boutonOK.setBackground(new Color(250, 250, 250));
        boutonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String fileName = pseudoJoueur.getText();
                try {
                    File reader = new File("src\\" + fileName + ".txt");
                    if (reader.exists()){
                        JOptionPane.showMessageDialog(null , "Fichier trouvé");
                        boutonOKActionPerformed(e);
                    }
                    else{
                        JOptionPane.showMessageDialog(null , "Ce fichier n'existe pas"); 
                    }   
                }
                catch (Exception ex) {
                }
            }
        });

        pseudoJoueur.setFont(new Font("Microsft Sans Serif", 0, 20));
        pseudoJoueur.setBackground(Color.white);
        
        content.add(pan1);
        content.setLayout(cardL);
        
        getContentPane().add(labelTitre);
        labelTitre.setBounds(50, 20, 275, 60);
        
        getContentPane().add(boutonOK);
        boutonOK.setBounds(160, 150, 80, 30);
        
        getContentPane().add(pseudoJoueur);
        pseudoJoueur.setBounds(50, 90, 300, 35);
        
        getContentPane().add(content, BorderLayout.CENTER); 
    }
    
    private void boutonOKActionPerformed(ActionEvent e) {                                         
        this.dispose();
        /*Plateau monPlateau = new Plateau();
        monPlateau.setVisible(true);*/
    }
    
    /*private void lireTexte(String filename){
        
        try{
            BufferedReader reader = Files.newBufferedReader(Path("src/projet_final/" + filename + ".txt"));
            int sizeY = reader.readLine().length();
            int sizeX = 1;
            for (String line = reader.readLine(); !line.equals("D.ATA"); line = reader.readLine()) {
                sizeX++;
            }
            char[][] map = new char[sizeX][sizeY];
            reader = Files.newBufferedReader(Path.of("src/TextFile/" + filename + ".txt"));
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
            playGame(true, new Map(map));
        } catch (IOException e) {
            System.out.println("Cette sauvegarde n'existe pas \n");
            chooseTextFile();
        }
    }*/
    
    
}
