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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PerfilController implements Initializable {

    private User user;
    @FXML
    private Text nomtf;
    @FXML
    private Text apetf;
    @FXML
    private Text orgtf;
    @FXML
    private Text cortf;
    @FXML
    private Text roltf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cambiarclave(MouseEvent event) 
    {
        
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CambioClave.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            CambioClaveController ccc = fxmlLoader.<CambioClaveController>getController();
            ccc.setUser(user);
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void cambiarrol(MouseEvent event) 
    {
        
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CambioRol.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            CambioRolController crc = fxmlLoader.<CambioRolController>getController();
            crc.setUser(user);
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void regresar(MouseEvent event) 
    {
        
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Main.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            MainController mc = fxmlLoader.<MainController>getController();
            mc.setUser(user);    
            
            
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public void setUser(User usr)
    {
        this.user = usr;
        nomtf.setText(usr.getNombres());
        apetf.setText(usr.getApellidos());
        orgtf.setText(usr.getOrganizacion());
        cortf.setText(usr.getCorreo());
    }
}
