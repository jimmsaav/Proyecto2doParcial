/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author jimmy
 */
public class User implements Serializable
{
    protected String nombres;
    protected String apellidos;
    protected String correo;
    protected String organizacion;
    protected String clave;
    protected String tipoEmp;
    
    public User(String tipoEmp, String nombres, String apellidos, String correo,
            String organizacion, String clave) 
    {
        this.tipoEmp = tipoEmp;
        this.nombres = nombres;
        this.apellidos = apellidos;
        
        if(isMailValid(correo))
        {
            this.correo = correo;
        }
        else
        {
            Alert a =  new Alert(Alert.AlertType.ERROR,"Ingrese un correo como este: correo@servidor.com");
            a.show();
        }
        this.organizacion = organizacion;        
        this.clave = convertirSHA256(clave);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public String getOrganizacion()
    {
        return organizacion;
    }

    public void setOrganizacion(String organizacion)
    {
        this.organizacion = organizacion;
    }

    public String getClave()
    {
        return clave;
    }

    public void setClave(String clave)
    {
        this.clave = clave;
    }

    public String getTipoEmp()
    {
        return tipoEmp;
    }

    public void setTipoEmp(String tipoEmp)
    {
        this.tipoEmp = tipoEmp;
    }


    public static void mostrarPerfil()
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Registrando usuario");
        a.show();
        //HACER
    }
    
    public static void registrarUser()
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Registrando usuario");
        a.show();
        //HACER
    }
    
    public static void registrarVeh()
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Registrando vehiculo");
        a.show();
        //HACER
    }
    
    public static void ofertar()
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Ofertando");
        a.show();
        //HACER
    }
    
    public static void aceptarOferta()
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Aceptando oferta");
        a.show();
        //HACER
    }
    
    public void remove(String cor) 
    {
        String filename = "users.ser";
        ArrayList<User> usuarios = Util.readPersonasFile();
        ArrayList<User> nusers = new ArrayList<>();
        for (User u : usuarios)
        {
            if(!u.getCorreo().equals(cor))
            {
                nusers.add(u);
            }
        }
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("users.ser")))
        {
                
            outStream.writeObject(nusers);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {

        }
        catch(IOException ioe)
        {
            
        }
    }
    
    public void saveFile() 
    {
        String filename = "users.ser";
        ArrayList<User> usuarios = Util.readPersonasFile();

        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("users.ser")))
        {
            
            usuarios.add(this);    
            outStream.writeObject(usuarios);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            File f = new File("users.ser");
            try 
            {
                f.createNewFile();
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
            this.saveFile();
        }
        catch(IOException ioe)
        {
            
            //System.out.println("EOF alcanzado, archivo creado");
            //ioe.printStackTrace();
        }
    }
    
    public static boolean isMailValid(String email)
    {
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");   
        Matcher mat = pat.matcher(email);
        return mat.find();   
    }
    
    public static String convertirSHA256(String pass) 
    {
        MessageDigest md = null;
        try {
                md = MessageDigest.getInstance("SHA-256");
        } 
        catch (NoSuchAlgorithmException e) {		
                e.printStackTrace();
                return null;
        }

            byte[] hash = md.digest(pass.getBytes(StandardCharsets.UTF_8));
            String res = toHexString(hash);

            return res;
        }
        
    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash); 
  
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }
    
    public static void removerPersona(User usr) throws IOException
    {
        String filename = "users.ser";
        ArrayList<User> personas = Util.readPersonasFile();
        
         
        ArrayList<User> nuevos = new ArrayList<>();
        
        for(User u : personas)
        {
            if(u.getCorreo().equals(usr.getCorreo()))
            {
               //No se agrega a la lista
            }
            else
            {
                nuevos.add(u);
            }
        }

        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {    
            outStream.writeObject(nuevos);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            File f = new File("users.ser");
            f.createNewFile();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            //ioe.printStackTrace();
        }
    }
    
    @Override 
    public String toString()
    {
        return this.correo;
    }
    
}

