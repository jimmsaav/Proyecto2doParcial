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
public class Comprador extends User
{


    public Comprador(String tipoEmp, String nombres, String apellidos, String correo,
            String organizacion, String clave) 
    {
        super(tipoEmp, nombres, apellidos, correo,organizacion, clave);
    }

    @Override
    public String toString(){
        return nombres + "," + apellidos + "," + correo + "," + organizacion + "," + clave;
    }
    
}
