/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.Serializable;

/**
 *
 * @author jimmy
 */
public class Auto extends Vehiculo implements Serializable
{
    protected String vidrios;
    protected String transmision;
    private static final long serialVersionUID = -12345L;


    public Auto(String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio, String vidrios, String transmision) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
        this.vidrios = vidrios;
        this.transmision=  transmision;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
}

