package Controller;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Création d'un compteur
 */
public class CountTime {

    int secondPassed = 0;
    Timer timer = new Timer();

    TimerTask task = new TimerTask(){

        public void run(){
            secondPassed++;
        }

    };
    public void start(){
        timer.scheduleAtFixedRate(task,1000,1000);
    }
}
