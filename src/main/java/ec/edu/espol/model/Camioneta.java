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
public class Camioneta extends Vehiculo implements Serializable
{
    protected String vidrios;
    protected String transmision;
    protected String traccion;
    private static final long serialVersionUID = -12345L;

    public Camioneta(String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio, String vidrios, String transmision, String traccion) 
    {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
        this.vidrios= vidrios;
        this.transmision= transmision;
        this.traccion= traccion;

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

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
    
}