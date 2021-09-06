 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

/**
 *
 * @author jimmy
 */

import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.User;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author jimmy
 */

public class Util 
{
    public static boolean isValidCred(String correo, String contrasenia) 
    {
        String filename = "users.ser";
        ArrayList<User> usuarios = readPersonasFile();

        
        String clave = User.convertirSHA256(contrasenia);
        
        for (User p : usuarios)
        {
            if (p.getCorreo().equals(correo))
            {
                if (p.getClave().equals(clave))
                {
                    return true;
                }
                else
                {
                    alerta("Credencial inválida","Clave incorrecta");
                    return false;
                }
            }
        }
        alerta("Credencial inválida","No existe el correo ingresado");
        return false;
    }
    public static void alerta(String tit,String msg)
    {
        Alert a = new Alert(Alert.AlertType.ERROR, msg);
        a.setHeaderText(tit);
        a.show();
    }
    public static void enviarCorreo(String correoObjetivo, String correoEmisor) throws MessagingException
    {
        Thread t = new Thread(()->{
        String to = correoObjetivo;
        String from = "proyecto2pg8";//correoEmisor
        String clave = "espol2021"; // chicos si el profesor les hace correr el programa no se olviden de abrir el correo en sus pc by Jimmy 
        
        
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.clave", clave);    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.port", "587"); 
        Session session = Session.getDefaultInstance(props);

        try 
        {
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(from));

           message.addRecipients(Message.RecipientType.TO, to);

           message.setSubject("OFERTA ACEPTADA");
           message.setText("Su oferta ha sido aceptada por un vendedor.\nPronto se comunicara con usted.");
           // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", from, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            
           
        } 
        catch (MessagingException mex) 
        {
            System.out.println(mex.getMessage());
        }
        });
        t.start();
    }
    
    public static ArrayList<Oferta> readOfertasFile()
    {
        String filename = "ofertas.ser";
        ArrayList<Oferta> offs = new ArrayList<>();
        
        try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(new File(filename))))
        {
            offs = (ArrayList<Oferta>) inStream.readObject();
        }
        catch(IOException e)
        {
            //e.printStackTrace();
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        return offs;
    }
    
    public static ArrayList<Vehiculo> readVehiclesFile(String filenamex)
    {
        String filename = filenamex;
        ArrayList<Vehiculo> listaVehs = new ArrayList<>();
        
        try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(new File(filename))))
        {
            listaVehs = (ArrayList<Vehiculo>) inStream.readObject();
        }
        catch(FileNotFoundException fn)
        {
            File f = new File(filenamex);
            try {
                f.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Archivo creado");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        return listaVehs;
    }
    public static ArrayList<User> readPersonasFile()
    {
        String filename = "users.ser";
        ArrayList<User> listaPersonas = new ArrayList<>();
        
        try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(new File(filename))))
        {
            listaPersonas = (ArrayList<User>) inStream.readObject();
        }
        catch(IOException e)
        {
            System.out.println("Se encontro EOF");
            //e.printStackTrace();
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        return listaPersonas;
    }
    
    public static boolean correoExiste(String email) 
    {
        String filename = "users.ser";
        
        ArrayList<User> listaPersonas = readPersonasFile();
        
        for (User p : listaPersonas)
        {
            if(p.getCorreo().equals(email))
            {
                return true;
            }
        }
        
        return false;
    }
}
