package Controller;

import java.util.Timer;
import java.util.TimerTask;

public class CountTime {

    int secondPassed = 0;
    Timer timer = new Timer();

    TimerTask task = new TimerTask(){

        public void run(){
            secondPassed++;
        }

    };
    public void start(){
        System.out.print("Time passed : " + secondPassed);
        timer.scheduleAtFixedRate(task,1000,1000);
    }
}
