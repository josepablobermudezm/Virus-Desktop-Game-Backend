/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusservidor.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Usuario
 */
public class Hilo {

    private Timer timer = new Timer();
    private int tic = 0;
    public static boolean finalizado = false;

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            tic++;
            if (tic == 30) {
                timer.cancel();
                task.cancel();
                System.out.println("HILO TERMINADO");
                finalizado = false;
            }
        }
    };

    public void correrHilo() {
        timer.schedule(task, 10, 1000);
    }
}
