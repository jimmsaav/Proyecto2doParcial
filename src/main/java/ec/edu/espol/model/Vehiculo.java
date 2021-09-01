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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**

 * @author jimmy
 */
public class Vehiculo {
    private int id;
    private String tipo; //(auto,camioneta,motocicleta)
    private String placa;
    private String marca;
    private String modelo;
    private String tipo_de_motor;
    private int año;
    private double recorrido;
    private String color;
    private String tipo_combustible;
    private String vidrios;  //no aplica para motos
    private String transmision; //no aplica para motos
    private String traccion; //aplica para camionetas
    private double precio;
    private ArrayList<Oferta> ofertas;
    
    //METODO CONSTRUCTOR PARA AUTOS
    public Vehiculo(int id, String placa, String tipo, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, double precio) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_de_motor = tipo_de_motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.precio = precio;
    }
    
    //METODO CONSTRUCTOR PARA CAMIONETAS
    public Vehiculo(int id, String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, String traccion, double precio) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_de_motor = tipo_de_motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;
        this.precio = precio;
    }
    
    //METODO CONSTRUCTOR PARA MOTOS
    public Vehiculo(int id, String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, double precio) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_de_motor = tipo_de_motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_de_motor() {
        return tipo_de_motor;
    }

    public void setTipo_de_motor(String tipo_de_motor) {
        this.tipo_de_motor = tipo_de_motor;
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

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }
    
    //(String nombre, String apellido, String email, String organizacion, String clave)
    public static Vehiculo leerTeclado(Scanner sc, String nomfile){
        System.out.println("Ingrese el tipo de Vehiculo (Auto, Camioneta, Moto): ");
        sc.useDelimiter("\n");
        String tipo = sc.next();
        
        // Para Auto: (String placa, String tipo, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, double precio) 
        if(tipo.toLowerCase().equals("auto")){
            System.out.println("Ingrese la placa del Auto: ");
            sc.useDelimiter("\n");
            String placa = sc.next();
            System.out.println("Ingrese la marca del Auto: ");
            sc.useDelimiter("\n");
            String marca = sc.next();
            System.out.println("Ingrese el modelo del Auto: ");
            sc.useDelimiter("\n");
            String modelo = sc.next();
            System.out.println("Ingrese el tipo de motor del Auto: ");
            sc.useDelimiter("\n");
            String tipo_de_motor = sc.next();
            System.out.println("Ingrese el año del Auto: ");
            sc.useDelimiter("\n");
            int año = sc.nextInt();
            System.out.println("Ingrese el recorrido del Auto: ");
            sc.useDelimiter("\n");
            double recorrido = sc.nextDouble();
            System.out.println("Ingrese el color del Auto: ");
            sc.useDelimiter("\n");
            String color = sc.next();
            System.out.println("Ingrese el tipo de combustible del Auto: ");
            sc.useDelimiter("\n");
            String tipo_combustible = sc.next();
            System.out.println("Ingrese los vidrios del Auto: ");
            sc.useDelimiter("\n");
            String vidrios = sc.next();
            System.out.println("Ingrese la transmision del Auto: ");
            sc.useDelimiter("\n");
            String transmision = sc.next();
            System.out.println("Ingrese el precio del Auto: ");
            sc.useDelimiter("\n");
            double precio = sc.nextDouble();
            int id = Util.nextID(nomfile);
            Vehiculo vehiculo = new Vehiculo(id,placa, tipo, marca, modelo, tipo_de_motor, año, recorrido, color, tipo_combustible, vidrios, transmision, precio);
            return vehiculo;
        }
        
        // Para Camioneta: (String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, String traccion, double precio) 
        if(tipo.toLowerCase().equals("camioneta")){
            System.out.println("Ingrese la placa de la Camioneta: ");
            sc.useDelimiter("\n");
            String placa = sc.next();
            System.out.println("Ingrese la marca de la Camioneta: ");
            sc.useDelimiter("\n");
            String marca = sc.next();
            System.out.println("Ingrese el modelo de la Camioneta: ");
            sc.useDelimiter("\n");
            String modelo = sc.next();
            System.out.println("Ingrese el tipo de motor de la Camioneta: ");
            sc.useDelimiter("\n");
            String tipo_de_motor = sc.next();
            System.out.println("Ingrese el año de la Camioneta: ");
            sc.useDelimiter("\n");
            int año = sc.nextInt();
            System.out.println("Ingrese el recorrido de la Camioneta: ");
            sc.useDelimiter("\n");
            double recorrido = sc.nextDouble();
            System.out.println("Ingrese el color de la Camioneta: ");
            sc.useDelimiter("\n");
            String color = sc.next();
            System.out.println("Ingrese el tipo de combustible de la Camioneta: ");
            sc.useDelimiter("\n");
            String tipo_combustible = sc.next();
            System.out.println("Ingrese los vidrios de la Camioneta: ");
            sc.useDelimiter("\n");
            String vidrios = sc.next();
            System.out.println("Ingrese la transmision de la Camioneta: ");
            sc.useDelimiter("\n");
            String transmision = sc.next();
            System.out.println("Ingrese la traccion de la Camioneta: ");
            sc.useDelimiter("\n");
            String traccion = sc.next();
            System.out.println("Ingrese el precio de la Camioneta: ");
            sc.useDelimiter("\n");
            double precio = sc.nextDouble();
            int id = Util.nextID(nomfile);
            Vehiculo vehiculo = new Vehiculo(id, placa, tipo, marca, modelo, tipo_de_motor, año, recorrido, color, tipo_combustible, vidrios, transmision, traccion, precio);
            return vehiculo;
        }
        
        // Para Moto: (String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, double precio)
        if(tipo.toLowerCase().equals("moto")){
            System.out.println("Ingrese la placa de la Moto: ");
            sc.useDelimiter("\n");
            String placa = sc.next();
            System.out.println("Ingrese la marca de la Moto: ");
            sc.useDelimiter("\n");
            String marca = sc.next();
            System.out.println("Ingrese el modelo de la Moto: ");
            sc.useDelimiter("\n");
            String modelo = sc.next();
            System.out.println("Ingrese el tipo de motor de la Moto: ");
            sc.useDelimiter("\n");
            String tipo_de_motor = sc.next();
            System.out.println("Ingrese el año de la Moto: ");
            sc.useDelimiter("\n");
            int año = sc.nextInt();
            System.out.println("Ingrese el recorrido de la Moto: ");
            sc.useDelimiter("\n");
            double recorrido = sc.nextDouble();
            System.out.println("Ingrese el color de la Moto: ");
            sc.useDelimiter("\n");
            String color = sc.next();
            System.out.println("Ingrese el tipo de combustible de la Moto: ");
            sc.useDelimiter("\n");
            String tipo_combustible = sc.next();
            System.out.println("Ingrese el precio de la Moto: ");
            sc.useDelimiter("\n");
            double precio = sc.nextDouble();
            int id = Util.nextID(nomfile);
            Vehiculo vehiculo = new Vehiculo(id, placa, tipo, marca, modelo, tipo_de_motor, año, recorrido, color, tipo_combustible, precio);
            return vehiculo;
        }
        
        else
            return null;
    }
    
   @Override
   public String toString(){
       // Para Auto: (String placa, String tipo, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, double precio) 
       if (this.tipo.toLowerCase().equals("auto"))
           return placa + "|" + tipo + "|" + marca + "|" + modelo + "|" + tipo_de_motor + "|" + año + "|" + recorrido + "|" + color + "|" + tipo_combustible + "|" + vidrios + "|" + transmision + "|" + precio;
       
       // Para Camioneta: (String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, String traccion, double precio) 
       if (this.tipo.toLowerCase().equals("camioneta"))
           return placa + "|" + tipo + "|" + marca + "|" + modelo + "|" + tipo_de_motor + "|" + año + "|" + recorrido + "|" + color + "|" + tipo_combustible + "|" + vidrios + "|" + transmision + "|" + traccion + "|" + precio;
       
       // Para Moto: (String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, double precio)
       if (this.tipo.toLowerCase().equals("moto"))
           return placa + "|" + tipo + "|" + marca + "|" + modelo + "|" + tipo_de_motor + "|" + año + "|" + recorrido + "|" + color + "|" + tipo_combustible + "|" + precio;
       
       return null;
   }
   
   //Metodo para guardar Vehiculo en archivo de texto
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            if(this.tipo.toLowerCase().equals("auto")){
                pw.println(this.id+"|"+this.placa + "|" + this.tipo + "|" + this.marca + "|" + this.modelo + "|" + this.tipo_de_motor + "|" + this.año + "|" + this.recorrido + "|" + this.color + "|" + this.tipo_combustible + "|" + this.vidrios + "|" + this.transmision + "|" + this.precio);
            }
            if(this.tipo.toLowerCase().equals("camioneta")){
                pw.println(this.id+"|"+this.placa + "|" + this.tipo + "|" + this.marca + "|" + this.modelo + "|" + this.tipo_de_motor + "|" + this.año + "|" + this.recorrido + "|" + this.color + "|" + this.tipo_combustible + "|" + this.vidrios + "|" + this.transmision + "|" + this.traccion + "|" + this.precio);  
            }
            if(this.tipo.toLowerCase().equals("moto")){
                pw.println(this.id+"|"+this.placa + "|" + this.tipo + "|" + this.marca + "|" + this.modelo + "|" + this.tipo_de_motor + "|" + this.año + "|" + this.recorrido + "|" + this.color + "|" + this.tipo_combustible + "|" + this.precio);
            }
            
            }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //Metodo para leer el archivo
    
    public static ArrayList<Vehiculo> readFile(String nomfile) throws FileNotFoundException{
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] tokens = linea.split("\\|");
            // Para Auto: (String placa, String tipo, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, double precio) 
            if(tokens[2].toLowerCase().equals("auto")){
                Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[6]),Double.parseDouble(tokens[7]),tokens[8],tokens[9],tokens[10],tokens[11],Double.parseDouble(tokens[12]));
                vehiculos.add(v);
            }
            // Para Camioneta: (String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, String traccion, double precio) 
            if(tokens[2].toLowerCase().equals("camioneta")){
                Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[6]),Double.parseDouble(tokens[7]),tokens[8],tokens[9],tokens[10],tokens[11],tokens[12],Double.parseDouble(tokens[13]));
                vehiculos.add(v);
            }
            // Para Moto: (String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, double precio)
            if(tokens[2].toLowerCase().equals("moto")){
                Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[6]),Double.parseDouble(tokens[7]),tokens[8],tokens[9],Double.parseDouble(tokens[10]));
                vehiculos.add(v);
            }
            }
        }
        return vehiculos;
    }
    /*
    public static Vehiculo searchByParametros(ArrayList<Vehiculo> vehiculos,ArrayList<Oferta> ofertas){
        for(Vehiculo v : vehiculos){
            for(Oferta o: ofertas){
                if(v.tipo.equals(o.getTipo())) // aqui falta agregar la busquedad por parametros 
            }
        }
    }
    */
    
    public void removeFromOfertaFile(String filename)
    {
        ArrayList<String> lineasArchivo = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(filename)))
        {
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.toString().split(",");
                
                if(Integer.parseInt(tokens[2]) != this.id)
                {
                    lineasArchivo.add(linea);
                }
            }
        }
        catch(Exception e){}
        restartFile(filename);
        for (String linea : lineasArchivo)
        {
            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filename),true)))
            {
                pw.println(linea);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public void removeFromVehicleFile(String filename)
    {
        ArrayList<String> lineasArchivo = new ArrayList<>();
        int conteo = 0;
        try(Scanner sc = new Scanner(new File(filename)))
        {
            
            while(sc.hasNextLine())
            {

                String linea = sc.nextLine();
                String[] tokens = linea.toString().split(",");
                if(Integer.parseInt(tokens[0]) != this.id)
                {
                    
                    lineasArchivo.add(linea);
                }
            }
        }
        catch(Exception e){}
        restartFile(filename);
        for (String linea : lineasArchivo)
        {
            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filename),true)))
            {
                pw.println(linea);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void restartFile(String filename)
    {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filename), false)))
        {
                
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


}
