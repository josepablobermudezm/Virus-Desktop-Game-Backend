/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.model;

import java.util.ArrayList;

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
    }

    public PartidaDto() {
    }

    public ArrayList<CartaDto> getMazo() {
        if(mazo==null){
            mazo = new ArrayList();
        }
        return mazo;
    }

    public void setMazo(ArrayList<CartaDto> mazo) {
        this.mazo = mazo;
    }

    public ArrayList<CartaDto> getDesechadas() {
        if(desechadas==null){
            desechadas = new ArrayList();
        }
        return desechadas;
    }

    public void setDesechadas(ArrayList<CartaDto> desechadas) {
        this.desechadas = desechadas;
    }

    public ArrayList<JugadorDto> getJugadores() {
        if(jugadores==null){
            jugadores = new ArrayList();
        }
        return jugadores;
    }

    public void setJugadores(ArrayList<JugadorDto> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "PartidaDto{" + "mazo=" + mazo + ", desechadas=" + desechadas + ", jugadores=" + jugadores + '}';
    }

}
