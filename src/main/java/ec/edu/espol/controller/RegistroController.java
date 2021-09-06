/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.User;
import ec.edu.espol.proyecto2doparcial.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RegistroController implements Initializable {

    private boolean logeado = false;
    private String correotemp;
    private User user;
    
    @FXML
    private TextField nombretf;
    @FXML
    private TextField apetf;
    @FXML
    private TextField orgtf;
    @FXML
    private TextField correotf;
    @FXML
    private PasswordField clavetf;
    @FXML
    private CheckBox venchbox;
    @FXML
    private CheckBox compchbox;
    @FXML
    private Button aceptarbtn;
    @FXML
    private Button cancbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
    }    
    
    public void setLogeado()
    {
        this.logeado = true;
    }
    
    public void setUser(User usr)
    {
        this.user = usr;
    }

    @FXML
    private void aceptar(MouseEvent event) 
    {
        
        String nombre = nombretf.getText();
        String apellido = apetf.getText();
        String organizacion = orgtf.getText();
        String correo = correotf.getText();
        String clave = clavetf.getText();
        
        if(!(nombre.equals("") || apellido.equals("") || organizacion.equals("") || correo.equals("") || clave.equals("")))
        {
            if(Util.correoExiste(correotf.getText()))
            {
                Util.alerta("ERROR", "CORREO YA EXISTE");
                return;
            }
            if(compchbox.isSelected() && !venchbox.isSelected())
            {
                User u = new User("COMPRADOR", nombre, apellido, correo, organizacion, clave);
                u.saveFile();
                
                try 
                {
                    if(logeado)
                        App.setRoot("Main");
                    else    
                        App.setRoot("Login");
                } 
                catch (IOException ex) 
                {
                    ex.printStackTrace();
                }

            }
            else if(!compchbox.isSelected() && venchbox.isSelected())
            {
                User u = new User("VENDEDOR", nombre, apellido, correo, organizacion, clave);
              
                u.saveFile();
                
                try 
                {
                    if(logeado)
                        App.setRoot("Main");
                    else    
                        App.setRoot("Login");
                } 
                catch (IOException ex) 
                {
                    ex.printStackTrace();
                }
            }
            
            else if(compchbox.isSelected() && venchbox.isSelected())
            {
                User u = new User("AMBOS", nombre, apellido, correo, organizacion, clave);
                u.saveFile();
                
                try 
                {
                    if(logeado)
                        App.setRoot("Main");
                    else    
                        App.setRoot("Login");
                } 
                catch (IOException ex) 
                {
                    ex.printStackTrace();
                }
            }
            else
            {
                Util.alerta("ERROR", "SELECCIONE UN ROL");
            }
            
        }

        else
        {
            Util.alerta("ERROR", "DEBE LLENAR TODOS LOS DATOS");
        }
        
    }

    public void setCorreo(String correo)
    {
        this.correotemp = correo;
    }
    public void mostrarBotones()
    {
        venchbox.setVisible(false);
        compchbox.setVisible(false);
    }
    @FXML
    private void cancelar(MouseEvent event) 
    {
        System.out.println(logeado);
            if(logeado)
            {
                try 
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Main.fxml"));
                    Parent root = fxmlLoader.load();

                    App.setParentRoot(root);
                    MainController rc = fxmlLoader.<MainController>getController();
                    rc.setUser(user);

                } 
                catch (IOException ex) 
                {
                    ex.printStackTrace();
                }
            }
            
            else
            {
                try 
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Login.fxml"));
                    Parent root = fxmlLoader.load();

                    App.setParentRoot(root);

                } 
                catch (IOException ex) 
                {
                    ex.printStackTrace();
                }
            }
                
      
    }
    
    
}
