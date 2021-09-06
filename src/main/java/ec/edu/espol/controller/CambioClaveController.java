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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CambioClaveController implements Initializable {

    private User user;
    @FXML
    private PasswordField clavant;
    @FXML
    private PasswordField clavnew;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setUser(User usr)
    {
        this.user = usr;
    }

    @FXML
    private void cambiar(MouseEvent event) 
    {

        if(Util.isValidCred(user.getCorreo(), clavant.getText()))
        {
            user.setClave(User.convertirSHA256(clavnew.getText()));
            user.remove(user.getCorreo());
            user.saveFile();
            Alert a = new Alert(AlertType.INFORMATION, "Clave cambiada con éxito");
            a.show();
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
    }

    @FXML
    private void cancelar(MouseEvent event) 
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
}
