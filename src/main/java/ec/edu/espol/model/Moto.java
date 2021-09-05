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
public class Moto extends Vehiculo implements Serializable{

    private static final long serialVersionUID = -12345L;

    public Moto(String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
    }
}
