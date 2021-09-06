/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.User;
import ec.edu.espol.proyecto2doparcial.App;
import ec.edu.espol.util.Util;
import static ec.edu.espol.util.Util.readPersonasFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jimmy
 */
public class LoginController implements Initializable 
{

    ArrayList<User> globalUsers;
    
    
    @FXML
    private TextField correotf;
    @FXML
    private PasswordField clavetf;
    @FXML
    private Button Login;
    @FXML
    private Button Registro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        String usersfile = "users.ser";
        
        globalUsers = Util.readPersonasFile();
        
    }    

    @FXML
    private void Login(MouseEvent event) 
    {
        
        if(Util.isValidCred(correotf.getText(), clavetf.getText()))
        {
            User us = null;
            for (User u: globalUsers)
            {
                if(u.getCorreo().equals(correotf.getText()))
                {
                    us = u;
                }
            }
            try 
            {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Main.fxml"));
                Parent root = fxmlLoader.load();
                App.setParentRoot(root);
                MainController mc = fxmlLoader.<MainController>getController();
                mc.setUser(us);
                
            } catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void Registro(MouseEvent event) 
    {
        try 
        {        
            App.setRoot("Registro");
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
}