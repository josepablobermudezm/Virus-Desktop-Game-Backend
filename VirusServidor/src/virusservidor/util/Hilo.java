/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusservidor.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import virus.model.JugadorDto;
import virus.model.PartidaDto;
import static virusservidor.VirusServidor.partida;

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
    PartidaDto partida;
    ObjectOutputStream objectoutlista;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (!finalizado) {
                tic++;
                if (tic == 30) {
                    timer.cancel();
                    task.cancel();
                    System.out.println("HILO TERMINADO");

                    try {
                        for (JugadorDto jugador : partida.getJugadores()) {
                            socket = new Socket(jugador.getIP(), 44440);
                            salida = new DataOutputStream(socket.getOutputStream());
                            objectoutlista = new  ObjectOutputStream(socket.getOutputStream());
                            salida.writeUTF("Partida Lista");
                            objectoutlista.writeObject(partida.getJugadores());
                            
                         /*   socket = new Socket(jugador.getIP(), 44440);
                            salida = new DataOutputStream(socket.getOutputStream());
                            
                            objectoutlista.writeObject(partida.getJugadores());*/
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    finalizado = false;
                }
            } else {
                timer.cancel();
                task.cancel();
                finalizado = false;
            }
        }
    };

    public void correrHilo(DataOutputStream salida, Socket socket, ServerSocket serverSocket, PartidaDto partida, ObjectOutputStream objectoutlista) {
        this.partida = partida;
        this.salida = salida;
        this.serverSocket = serverSocket;
        this.socket = socket;
        this.objectoutlista = objectoutlista;
        timer.schedule(task, 10, 1000);
    }
}
