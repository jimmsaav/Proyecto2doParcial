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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CambioRolController implements Initializable {
    private User user;
    private ArrayList<String> roles = new ArrayList<>();
    @FXML
    private Text rolviejo;
    @FXML
    private ComboBox<String> comborol;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roles.add("VENDEDOR");
        roles.add("COMPRADOR");
        roles.add("AMBOS");
        
        comborol.setItems(FXCollections.observableArrayList(roles));
    }    
    
    public void setUser(User usr)
    {
        this.user = usr;
    }

    @FXML
    private void cambiarol(MouseEvent event) 
    {
        if(comborol.getValue().equals("VENDEDOR"))
        {
            user.setTipoEmp("VENDEDOR");
            user.remove(user.getCorreo());
            user.saveFile();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Rol cambiado con éxito");
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
        else if(comborol.getValue().equals("COMPRADOR"))
        {
    
            user.setTipoEmp("COMPRADOR");
            user.remove(user.getCorreo());
            user.saveFile();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Rol cambiado con éxito");
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
        else if(comborol.getValue().equals("AMBOS"))
        {
            user.setTipoEmp("AMBOS");
            user.remove(user.getCorreo());
            user.saveFile();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Rol cambiado con éxito");
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
        else
        {
            Util.alerta("Campo vacio", "Por favor, elija un nuevo rol");
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
