/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dijou
 */
public class TableauScores extends JFrame {
    
    public TableauScores(){
        CardLayout cardL = new CardLayout();
        JPanel content = new JPanel();
        JLabel labelTableau = new JLabel();
        JButton boutonFermer = new JButton();
         
        setSize(681, 467);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
                   
        JPanel pan1 = new JPanel();
        pan1.setBackground(new Color (102, 204, 255)); 
        content.add(pan1);
        content.setLayout(cardL);
        
        Object[][] donnees = {};
 
        String[] entetes = {"Classement", "Pseudo", "Scores"};
 
        DefaultTableModel model = new DefaultTableModel(donnees, entetes);
        JTable tableau = new JTable(model);
        tableau.setAlignmentX(SwingConstants.CENTER);
        
        try {
            ecriture(model);//écriture du fichier
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        labelTableau.setFont(new Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        labelTableau.setForeground(Color.RED);
        labelTableau.setText("Tableau des scores");
        
        boutonFermer.setFont(new Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        boutonFermer.setForeground(new Color(0, 0, 0));
        boutonFermer.setText("Fermer");
        boutonFermer.setBorder(null);    
        boutonFermer.setBackground(new Color(250, 250, 250));
        boutonFermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boutonFermerActionPerformed(e);
            }
        });
        
        getContentPane().add(labelTableau);
        labelTableau.setBounds(230, 20, 250, 60);
        
        getContentPane().add(boutonFermer);
        boutonFermer.setBounds(280, 400, 130, 40);
        
        getContentPane().add(tableau.getTableHeader());
        tableau.getTableHeader().setBounds(100 ,100 ,481 ,40); 
        getContentPane().add(tableau);
        tableau.setBounds(100, 140, 481, 210);
        tableau.setRowHeight(30);
        tableau.setEnabled(false);

        getContentPane().add(content, BorderLayout.CENTER);
    }
    
   public void ecriture(DefaultTableModel model) throws Exception{
                            
        Scanner sc = new Scanner(new FileInputStream("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\projet_final\\fichierPseudo.txt"));//on ouvre le fichier pour le lire
        while(sc.hasNext()){//tant qu'il y a des choses à lire
            StringTokenizer token = new StringTokenizer(sc.nextLine(), "|#");//on split une ligne en fonction de | et # pour ne garder que le texte
            Vector<String> rowData = new Vector<String>();
            while(token.hasMoreTokens())//lecture des token et on les mets dans le vecteur
                rowData.add(token.nextToken());
                model.addRow(rowData);//on ajoute la ligne
        }
        sc.close();//fini :)
    }
    
    private void boutonFermerActionPerformed(ActionEvent e) {                                         
        this.dispose();
    }
}


