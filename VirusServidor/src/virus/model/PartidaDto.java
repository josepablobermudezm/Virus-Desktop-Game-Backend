/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class PartidaDto {

    private static final long serialVersionUID = 4L;

    private ArrayList<CartaDto> mazo;
    private ArrayList<CartaDto> desechadas;
    private ArrayList<JugadorDto> jugadores;

    public PartidaDto(ArrayList<CartaDto> mazo, ArrayList<CartaDto> desechadas, ArrayList<JugadorDto> jugadores) {
        this.mazo = mazo;
        this.desechadas = desechadas;
        this.jugadores = jugadores;
        crearMazo();
    }

    public PartidaDto() {
        crearMazo();
    }

    public void crearMazo() {
        if (this.mazo == null) {
            mazo = new ArrayList();
        }
        mazo.add(new CartaDto("Corazon", "Rojo", "corazonCarta.png", "Sano"));
        mazo.add(new CartaDto("Corazon", "Rojo", "corazonCarta.png", "Sano"));
        mazo.add(new CartaDto("Corazon", "Rojo", "corazonCarta.png", "Sano"));
        mazo.add(new CartaDto("Corazon", "Rojo", "corazonCarta.png", "Sano"));
        mazo.add(new CartaDto("Corazon", "Rojo", "corazonCarta.png", "Sano"));

        mazo.add(new CartaDto("Estomago", "Verde", "estomagoVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Estomago", "Verde", "estomagoVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Estomago", "Verde", "estomagoVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Estomago", "Verde", "estomagoVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Estomago", "Verde", "estomagoVerdeCarta.png", "Sano"));

        mazo.add(new CartaDto("Cerebro", "Azul", "cerebroCarta.png", "Sano"));
        mazo.add(new CartaDto("Cerebro", "Azul", "cerebroCarta.png", "Sano"));
        mazo.add(new CartaDto("Cerebro", "Azul", "cerebroCarta.png", "Sano"));
        mazo.add(new CartaDto("Cerebro", "Azul", "cerebroCarta.png", "Sano"));
        mazo.add(new CartaDto("Cerebro", "Azul", "cerebroCarta.png", "Sano"));

        mazo.add(new CartaDto("Hueso", "Amarillo", "HuesoCarta.png", "Sano"));
        mazo.add(new CartaDto("Hueso", "Amarillo", "HuesoCarta.png", "Sano"));
        mazo.add(new CartaDto("Hueso", "Amarillo", "HuesoCarta.png", "Sano"));
        mazo.add(new CartaDto("Hueso", "Amarillo", "HuesoCarta.png", "Sano"));
        mazo.add(new CartaDto("Hueso", "Amarillo", "HuesoCarta.png", "Sano"));

        mazo.add(new CartaDto("Organo_Comodin", "Comodin", "comodinOrgano.png", "Sano"));

        mazo.add(new CartaDto("Virus", "Rojo", "virusRojoCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Rojo", "virusRojoCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Rojo", "virusRojoCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Rojo", "virusRojoCarta.png", "Sano"));

        mazo.add(new CartaDto("Virus", "Verde", "virusVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Verde", "virusVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Verde", "virusVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Verde", "virusVerdeCarta.png", "Sano"));

        mazo.add(new CartaDto("Virus", "Azul", "virusAzulCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Azul", "virusAzulCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Azul", "virusAzulCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Azul", "virusAzulCarta.png", "Sano"));

        mazo.add(new CartaDto("Virus", "Amarillo", "virusAmarrilloCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Amarillo", "virusAmarrilloCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Amarillo", "virusAmarrilloCarta.png", "Sano"));
        mazo.add(new CartaDto("Virus", "Amarillo", "virusAmarrilloCarta.png", "Sano"));

        mazo.add(new CartaDto("Virus_Comodin", "Comodin", "comodinVirus.png", "Sano"));

        mazo.add(new CartaDto("Medicina", "Rojo", "medicinaRojaCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Rojo", "medicinaRojaCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Rojo", "medicinaRojaCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Rojo", "medicinaRojaCarta.png", "Sano"));

        mazo.add(new CartaDto("Medicina", "Verde", "medicinaVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Verde", "medicinaVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Verde", "medicinaVerdeCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Verde", "medicinaVerdeCarta.png", "Sano"));

        mazo.add(new CartaDto("Medicina", "Amarillo", "medicinaAmarrilloCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Amarillo", "medicinaAmarrilloCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Amarillo", "medicinaAmarrilloCarta.png", "Sano"));
        mazo.add(new CartaDto("Medicina", "Amarillo", "medicinaAmarrilloCarta.png", "Sano"));

        mazo.add(new CartaDto("Medicina_Comodin", "Morado", "comodinMedicina.png", "Sano"));
        mazo.add(new CartaDto("Medicina_Comodin", "Morado", "comodinMedicina.png", "Sano"));
        mazo.add(new CartaDto("Medicina_Comodin", "Morado", "comodinMedicina.png", "Sano"));
        mazo.add(new CartaDto("Medicina_Comodin", "Morado", "comodinMedicina.png", "Sano"));

        mazo.add(new CartaDto("Transplante", "Morado", "transplanteCarta.png", "Sano"));
        mazo.add(new CartaDto("Transplante", "Morado", "transplanteCarta.png", "Sano"));

        mazo.add(new CartaDto("Ladron", "Morado", "ladrondeOrganosCarta.png", "Sano"));
        mazo.add(new CartaDto("Ladron", "Morado", "ladrondeOrganosCarta.png", "Sano"));
        mazo.add(new CartaDto("Ladron", "Morado", "ladrondeOrganosCarta.png", "Sano"));
        /*
        mazo.add(new CartaDto("Contagio", "Morado", "contagioCarta.png", "Sano"));
        mazo.add(new CartaDto("Contagio", "Morado", "contagioCarta.png", "Sano"));
        mazo.add(new CartaDto("Contagio", "Morado", "contagioCarta.png", "Sano"));
         */
        mazo.add(new CartaDto("Guante", "Morado", "guantesDeLatexCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        /*mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));
        mazo.add(new CartaDto("Error", "Morado", "errorMedicoCarta.png", "Sano"));*/

        Collections.shuffle(mazo);
    }

    public void entregarCartasJugador(String Ip) {
        try {
            Socket socket = new Socket(Ip, 44440);
            System.out.println("Connected!");
            // get the output stream from the socket.
            OutputStream outputStream = socket.getOutputStream();
            // create an object output stream from the output stream so we can send an object through it
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            // make a bunch of messages to send.

            System.out.println("Sending messages to the ServerSocket");
            objectOutputStream.writeObject(getCartasPorJugador());

            System.out.println("Closing socket and terminating program.");
            socket.close();
        } catch (IOException IO) {

        }
    }

    public ArrayList<CartaDto> getMazo() {
        if (mazo == null) {
            mazo = new ArrayList();
        }
        return mazo;
    }

    public void setMazo(ArrayList<CartaDto> mazo) {
        this.mazo = mazo;
    }

    public ArrayList<CartaDto> getDesechadas() {
        if (desechadas == null) {
            desechadas = new ArrayList();
        }
        return desechadas;
    }

    public void setDesechadas(ArrayList<CartaDto> desechadas) {
        this.desechadas = desechadas;
    }

    public ArrayList<JugadorDto> getJugadores() {
        if (jugadores == null) {
            jugadores = new ArrayList();
        }
        return jugadores;
    }

    public void setJugadores(ArrayList<JugadorDto> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<CartaDto> getCartasPorJugador() {
        ArrayList<CartaDto> cartas = new ArrayList<>();
        if (!mazo.isEmpty()) {
            for (CartaDto carta : mazo) {
                if (mazo.indexOf(carta) <= 2) {
                    cartas.add(carta);
                }
            }
        }
        mazo.removeAll(cartas);
        return cartas;
    }

    public CartaDto getCarta() {
        CartaDto carta = null;
        ArrayList<CartaDto> cartas = new ArrayList<>();
        if (!mazo.isEmpty()) {
            carta = mazo.remove(0);
        }
        return carta;
    }

    public JugadorDto cambiarTurno() {
        int i = getJugadores().indexOf(getJugadores().stream().filter(x -> x.getTurno()).findAny().get());
        /*
        Cambia el estado de todos los jugadores, para luego cambiar el turno por medio de sus indices
         */
        getJugadores().stream().forEach(jugador -> {
            jugador.setTurno(false);
        });

        if (i + 1 != getJugadores().size()) {
            getJugadores().get(i + 1).setTurno(true);
        } else {
            getJugadores().get(0).setTurno(true);
        }
        if (getJugadores().stream().filter(x -> x.getTurno()).findAny().isPresent()) {
            return getJugadores().stream().filter(x -> x.getTurno()).findAny().get();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "PartidaDto{" + "mazo=" + mazo + ", desechadas=" + desechadas + ", jugadores=" + jugadores + '}';
    }
}
