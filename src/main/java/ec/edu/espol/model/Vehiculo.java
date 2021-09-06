/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author jimmy
 */

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**

 * @author jimmy
 */
public class Vehiculo implements Serializable
{
    private String placa;
    private String marca;
    private String modelo;
    private String motor;
    private int año;
    private double recorrido;
    private String color;
    private String combustible;
    private double precio;
    
    public Vehiculo(String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public static boolean placaExiste(String placa, String filenamex)
    {
         String filename = filenamex;
     
        ArrayList<Vehiculo> lista = Util.readVehiclesFile(filename);
     
     for (Vehiculo p : lista)
     {
         if(p.getPlaca().equals(placa))
         {
             return true;
         }
     }
     
     return false;
 }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }    
    //FUNCION LISTA - LOGICA PARALELA NO DEBERIA DAR PROBLEMAS
    public void saveFile(String filen)
    {
        String filename = filen;
        
        ArrayList<Vehiculo> vehiculos = Util.readVehiclesFile(filen);
        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            vehiculos.add(this);    
            outStream.writeObject(vehiculos);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            File f = new File(filename);
            try {
                f.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Archivo creado");
            this.saveFile(filen);
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
    }
    
    
    public static void removerVehiculo(String filenamex, Vehiculo v) throws IOException
    {
        String filename = filenamex;
        ArrayList<Vehiculo> vehs = Util.readVehiclesFile(filename);
        
        ArrayList<Vehiculo> vehsMod = new ArrayList<>();
        
        for(Vehiculo o : vehsMod)
        {
            if(o.getPlaca().equals(v.getPlaca()))
            {
               
            }
            else
            {
                vehsMod.add(o);
            }
        }

        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {    
            outStream.writeObject(vehsMod);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            File f = new File(filename);
            f.createNewFile();
            System.out.println("Se ha creado el archivo");
            //fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
    }

}
