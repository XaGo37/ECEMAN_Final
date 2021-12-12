package View;

import Model.Perso;
import Model.Map;


/**
 * Affichage de la map dans la console
 */
public class Affichage {

    public static void afficher(Map map, Perso perso){
        for (int i = 0; i < map.getSizeY(); i++) {
            for (int j = 0; j <  map.getSizeX(); j++) {
                System.out.print(" "+map.getCase(i, j));
            }
            System.out.println();
            }
        }
    }
