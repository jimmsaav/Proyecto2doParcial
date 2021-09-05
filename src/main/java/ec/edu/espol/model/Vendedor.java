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
public class Vendedor{
    private int id;
    private String nombre;
    private String apellido;
    private String organizacion;
    private String email;
    private String clave;

    public Vendedor(int id, String nombre, String apellido, String organizacion, String email, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.email = email;
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

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    //(String nombre, String apellido, String email, String organizacion, String clave)
    public static Vendedor leerTeclado(Scanner sc, String nomfile) throws NoSuchAlgorithmException
    {
        
        return null;
    }
    
    //Metodo para guardar Comprador en archivo de texto
    public void saveFile(String nomfile){
        
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombre+"|"+this.apellido+"|"+this.organizacion+"|"+this.email+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String toString(){
        return nombre + "," + apellido + "," + organizacion + "," + email + "," + clave;
    }
} 
