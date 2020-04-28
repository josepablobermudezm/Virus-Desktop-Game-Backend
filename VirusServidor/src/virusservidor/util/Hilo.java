/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusservidor.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Hilo {

    private Timer timer = new Timer();
    private int tic = 0;
    public static boolean finalizado = false;
    DataOutputStream salida;
    Socket socket;
    ServerSocket serverSocket;
    String IP;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            tic++;
            if (tic == 30) {
                timer.cancel();
                task.cancel();
                System.out.println("HILO TERMINADO");

                try {
                    socket = new Socket(IP, 44440);
                    salida = new DataOutputStream(socket.getOutputStream());
                    salida.writeUTF("Partida Lista");
                } catch (IOException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }

                finalizado = false;
            }
        }
    };

    public void correrHilo(DataOutputStream salida, Socket socket, ServerSocket serverSocket, String IP) {
        timer.schedule(task, 10, 1000);
    }
}
