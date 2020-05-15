/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusservidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.and;
import virus.model.CartaDto;
import virus.model.JugadorDto;
import virus.model.PartidaDto;
import virusservidor.util.Hilo;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class VirusServidor {

    /**
     * @param args the command line arguments
     */
    public static PartidaDto partida;

    public static void main(String[] args) {
        // En este método vamos a esperar una señal del cliente para saber que estamos recibiendo(Jugador, Carta)
        DataInputStream entrada;
        DataOutputStream salida;
        Socket socket;
        ServerSocket serverSocket;
        String mensajeRecibido;
        partida = new PartidaDto();
        while (true) {
            try {
                serverSocket = new ServerSocket(44440);
                System.out.println("Esperando una conexión...");
                socket = serverSocket.accept();
                System.out.println("Un cliente se ha conectado...");
                // Para los canales de entrada y salida de datos

                entrada = new DataInputStream(socket.getInputStream());

                salida = new DataOutputStream(socket.getOutputStream());

                System.out.println("Confirmando conexion al cliente....");

                // Para recibir el mensaje
                mensajeRecibido = entrada.readUTF();
                System.out.println(mensajeRecibido);
                salida.writeUTF("Recibido");
                serverSocket.close();

                if ("jugador".equals(mensajeRecibido)) {
                    recibirJugador();
                } else if ("carta".equals(mensajeRecibido)) {
                    recibirCarta();
                } else if ("pedirCartas".equals(mensajeRecibido)) {
                    enviarCarta();
                } else if ("desecharCarta".equals(mensajeRecibido)) {
                    desecharCarta();
                }
            } catch (IOException IO) {
                System.out.println(IO.getMessage());
            }
        }
    }

    public static void desecharCarta() {
       try {
            ServerSocket ss = new ServerSocket(44440);
            DataOutputStream salida;

            System.out.println("Esperando Jugador...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            salida = new DataOutputStream(socket.getOutputStream());
            System.out.println("Conexión de " + socket + "!");

            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();
            // create a DataInputStream so we can read data from it.
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            CartaDto carta = (CartaDto) objectInputStream.readObject();

            System.out.println("Mensajes:");
            System.out.println(carta.toString());

           /*partida.getJugadores().stream().forEach((jugador) -> {
                try {
                    Socket socket2 = new Socket(jugador.getIP(), 44440);
                    DataOutputStream mensaje2 = new DataOutputStream(socket2.getOutputStream());
                    //DataInputStream respuesta = new DataInputStream(socket2.getInputStream());
                    System.out.println("Connected Text!");
                    OutputStream outputstream = socket2.getOutputStream();
                    ObjectOutputStream objectoutputstream = new ObjectOutputStream(outputstream);
                    objectoutputstream.writeObject(carta);
                    socket2.close();
                } catch (IOException e) {

                }
            });*/
            
            System.out.println("Cerrando socket");
            ss.close();
            socket.close();

        } catch (IOException | ClassNotFoundException IO) {
            System.out.println(IO.getMessage());
        }
       
    }

    public static void enviarCarta() {
        try {
            ServerSocket ss = new ServerSocket(44440);
            System.out.println("Esperando Conexion Jugador...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Conexión de " + socket + "!");
            DataInputStream entrada;
            entrada = new DataInputStream(socket.getInputStream());
            OutputStream outputstream = socket.getOutputStream();
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(outputstream);
            objectoutputstream.writeObject(partida.getCarta());
            System.out.println("Cerrando socket");
            ss.close();
            socket.close();
        } catch (IOException IO) {
            System.out.println(IO.getMessage());
        }
    }

    public static void recibirJugador() {
        try {
            ServerSocket ss = new ServerSocket(44440);
            DataOutputStream salida;

            System.out.println("Esperando Jugador...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            salida = new DataOutputStream(socket.getOutputStream());
            System.out.println("Conexión de " + socket + "!");

            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();
            // create a DataInputStream so we can read data from it.
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            OutputStream outputstream = socket.getOutputStream();
            OutputStream outputlista = socket.getOutputStream();

            ObjectOutputStream objectoutputstream = new ObjectOutputStream(outputstream);

            JugadorDto Jugador = (JugadorDto) objectInputStream.readObject();

            System.out.println("Mensajes:");
            System.out.println(Jugador.toString());

            partida.getJugadores().add(Jugador);

            System.out.println("Entregando Cartas a " + Jugador.getNombre());
            objectoutputstream.writeObject(partida.getCartasPorJugador());

            ObjectOutputStream objectoutlista = new ObjectOutputStream(outputlista);
            VerificarPartida(salida, socket, ss, objectoutlista); // Verificamos la cantidad de jugadores que existen hasta el momento en la partida

            System.out.println("Cerrando socket");
            ss.close();
            socket.close();

        } catch (IOException | ClassNotFoundException IO) {
            System.out.println(IO.getMessage());
        }
    }

    public static void recibirCarta() {
        try {
            ServerSocket ss = new ServerSocket(44440);
            System.out.println("Esperando Carta...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Conexión de " + socket + "!");

            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();
            // create a DataInputStream so we can read data from it.
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            CartaDto Carta = (CartaDto) objectInputStream.readObject();
            System.out.println("Mensajes:");
            System.out.println(Carta.toString());

            partida.getMazo().add(Carta);
            System.out.println("Cerrando socket");
            ss.close();
            socket.close();
        } catch (Exception IO) {
        }
    }

    public static void VerificarPartida(DataOutputStream salida, Socket socket, ServerSocket serverSocket, ObjectOutputStream objectoutlista) throws IOException {
        if (partida.getJugadores().size() == 6) {
            for (JugadorDto jugador : partida.getJugadores()) {
                socket = new Socket(jugador.getIP(), 44440);
                salida = new DataOutputStream(socket.getOutputStream());
                objectoutlista = new ObjectOutputStream(socket.getOutputStream());
                salida.writeUTF("Partida Lista");
                objectoutlista.writeObject(partida.getJugadores());
                Hilo.finalizado = true;
            }
        } else if (partida.getJugadores().size() == 2) {
            Hilo hilo = new Hilo();
            hilo.correrHilo(salida, socket, serverSocket, partida, objectoutlista);
        }
    }
}
