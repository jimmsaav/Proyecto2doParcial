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
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import java.io.File;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
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
public class Util {
    
    private static String FROM_MAIL = "proyecto2pg8@gmail.com";
    private static String FROM_PASSWORD = "espol2021";
    
    private Util(){};
    
    public static int nextID(String nomfile){
        int id = 0;
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                id = Integer.parseInt(tokens[0]);
            }
        }catch(Exception e){
        }
        return id+1;
    }
    // Verifica si el vendedor esta en el sistema. Le das un onjeto Vendedor y un archivo de texto con los vendedores
    // Te bota un true sino se encuentra y false si, si lo esta.
    public static boolean verificarVendedor(Vendedor v,String nomfile){
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if(v.getEmail().equals(tokens[3])){
                    return false;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    // Verifica si el comprador esta en el sistema. Le das el email a verificar y un archivo de texto con los compradores.
    // Te bota un true si se encuentra en el archivo y false si no lo esta.
    public static boolean verificarComprador(String email,String nomfile){
        ArrayList<String> correoCompradores = new ArrayList<String>();
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                correoCompradores.add(tokens[2]);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(String c: correoCompradores)   {
            if(c == email)  {
                return true;
            }
        }
        return false;
    }
    
    //Para convertir contraseñas en tipo de dato Hash
    //Desde aqui
    private static byte[] getSHA(String contraseña) throws NoSuchAlgorithmException
    { 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
        return md.digest(contraseña.getBytes(StandardCharsets.UTF_8)); 
    }
    
    //Esta es la que se llama
    public static String convertirContraseña(String contraseña) throws NoSuchAlgorithmException{
        
        BigInteger number = new BigInteger(1, Util.getSHA(contraseña)); 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
        return hexString.toString(); 
    }
    //Hasta Aqui
    
    // Te bota un true si se encuentra en el archivo y false si no lo esta.
    // Le das la contraseña ingresada y el archivo vendedores
    // (id, nombre, apellido, organizacion, email, hash)
    private static boolean validarContraseñaVendedor(String correoIngresado, String claveIngresada, String nomfile) throws NoSuchAlgorithmException{
        String hash = Util.convertirContraseña(claveIngresada);
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if (correoIngresado.equals(tokens[4]) && hash.equals(tokens[5]))
                    return false;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    //Se llama para validar el ingreso de un Vendedor (Vota True si la contraseña esta incorrecta y False si no lo esta)
    public static boolean pedirVendedor(Scanner sc) throws NoSuchAlgorithmException{
        System.out.println("Ingrese su correo: ");
        sc.useDelimiter("\n");
        String correo = sc.next();
        System.out.println("Ingrese su contraseña: ");
        sc.useDelimiter("\n");
        String contraseña = sc.next();

        boolean resultado = Util.validarContraseñaVendedor(correo, contraseña, "Vendedores.txt");
        return resultado;
    }
    
    // Validar si el vehiculo se encuentra en el sistema 
    // Te bota un true si se encuentra en el archivo y false si no lo esta.
    public static boolean verificarVehiculo(Vehiculo vehiculo, String nomfile){
        ArrayList<String> placas = new ArrayList<String>();
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                placas.add(tokens[1]);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(String p: placas)   {
            if(vehiculo.getPlaca().equals(p)){
                return true;
            }
        }
        return false;
    }
    // Aquie esta implementado el metodo enviarConGmail pero aun falta instalar las dependencias .
    public static boolean enviarConGMail(String destinatario, String asunto, String cuerpo) {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", Util.FROM_MAIL);
        props.put("mail.smtp.clave", Util.FROM_PASSWORD);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(Util.FROM_MAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", Util.FROM_MAIL, Util.FROM_PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException me) {
            return false;
        }
    }
}
