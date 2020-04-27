/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class JugadorDto implements Serializable {
    
    private static final long serialVersionUID = 4L; 
    
    private String nombre;
    private Boolean turno;
    private ArrayList<CartaDto> mazo;
    private ArrayList<CartaDto> jugadas;
    private Boolean ganador;
    private String IP;

    public JugadorDto(String nombre, Boolean turno, ArrayList<CartaDto> mazo, ArrayList<CartaDto> jugadas, Boolean ganador, String IP) {
        this.nombre = nombre;
        this.turno = turno;
        this.mazo = mazo;
        this.jugadas = jugadas;
        this.ganador = ganador;
        this.IP = IP;
    }
    
    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
    
    public JugadorDto(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getTurno() {
        return turno;
    }

    public void setTurno(Boolean turno) {
        this.turno = turno;
    }

    public ArrayList<CartaDto> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<CartaDto> mazo) {
        this.mazo = mazo;
    }

    public ArrayList<CartaDto> getJugadas() {
        return jugadas;
    }

    public void setJugadas(ArrayList<CartaDto> jugadas) {
        this.jugadas = jugadas;
    }

    public Boolean getGanador() {
        return ganador;
    }

    public void setGanador(Boolean ganador) {
        this.ganador = ganador;
    }
    
    
    
    
    
    
    
}
