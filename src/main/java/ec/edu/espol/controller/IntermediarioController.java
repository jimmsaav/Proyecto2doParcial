/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.User;
import ec.edu.espol.proyecto2doparcial.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class IntermediarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private User usr;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void auto(MouseEvent event) 
    {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Vehiculo.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            VehiculoController rc = fxmlLoader.<VehiculoController>getController();
            rc.setAuto();
            rc.setUser(usr);        
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void moto(MouseEvent event) 
    {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Vehiculo.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            VehiculoController rc = fxmlLoader.<VehiculoController>getController();
            rc.setMoto();
            rc.setUser(usr);        
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void camioneta(MouseEvent event) 
    {
    
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Vehiculo.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            VehiculoController rc = fxmlLoader.<VehiculoController>getController();
            rc.setCam();
            rc.setUser(usr);        
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public void setUser(User user)
    {
        this.usr = user;
    }
    
}
