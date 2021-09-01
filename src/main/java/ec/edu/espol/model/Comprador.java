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
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jimmy
 */
public class Comprador {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String organizacion;
    private String clave;

    public Comprador(int id, String nombre, String apellido, String email, String organizacion, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.organizacion = organizacion;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emial) {
        this.email = emial;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    //(String nombre, String apellido, String email, String organizacion, String clave)
    public static Comprador leerTeclado(Scanner sc, String nomfile) throws NoSuchAlgorithmException{
        
        System.out.println("Ingrese nombre del Comprador: ");
        sc.useDelimiter("\n");
        String nombre = sc.next();
        System.out.println("Ingrese apellido del Comprador: ");
        sc.useDelimiter("\n");
        String apellido = sc.next();
        System.out.println("Ingrese correo del Comprador: ");
        sc.useDelimiter("\n");    
        String email = sc.next();
        System.out.println("Ingrese organizacion del Comprador: ");
        sc.useDelimiter("\n");
        String organizacion = sc.next();
        System.out.println("Ingrese contraseña del Comprador: ");
        sc.useDelimiter("\n");
        String contraseña = sc.next();
        //Convertimos la contraseña
        String hash = Util.convertirContraseña(contraseña);
        //Creamos el Objeto Comprador
        int id = Util.nextID(nomfile);
        Comprador comprador = new Comprador(id, nombre, apellido, email, organizacion, hash);
        
        return comprador;
    }
    
  
    public static ArrayList<Comprador> readFile(String filename)
    {
        ArrayList<Comprador> compradores = new ArrayList<Comprador>();
        try(Scanner sc = new Scanner(new File(filename)))
        {
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split(",");
                
                
                    compradores.add(new Comprador(Integer.parseInt(tokens[0]),tokens[2],tokens[3],
                            tokens[4],tokens[5],tokens[6]));
                
            }
            return compradores;
        }
        catch(Exception e)
        {
            System.out.println("Error al leer el archivo");
            return readFile(filename);
        }
        
    }
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombre+"|"+this.apellido+"|"+this.email+"|"+this.organizacion+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String toString(){
        return id + "," + nombre + "," + apellido + "," + email + "," + organizacion + "," + clave;
    }
    
}
