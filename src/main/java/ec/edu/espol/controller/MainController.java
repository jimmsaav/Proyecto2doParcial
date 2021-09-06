/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author jimmy
 */
public class MainController implements Initializable 
{
    User userRecibido;
    @FXML
    private VBox panelvend;
    @FXML
    private VBox panelcomp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
    }   
    
    public void mostrarBotonesComp()
    {
        panelvend.setVisible(false);
    }
    
    public void mostrarBotonesVend()
    {
        panelcomp.setVisible(false);
    }
    public void setUser(User us)
    {
        this.userRecibido = us;
       
        if (us.getTipoEmp().equals("VENDEDOR"))
        {
            this.mostrarBotonesVend();
        }
        else if (us.getTipoEmp().equals("COMPRADOR"))
        {
            this.mostrarBotonesComp();
        }
    }

    @FXML
    private void registroven(MouseEvent event) 
    {
        
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Registro.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            RegistroController rc = fxmlLoader.<RegistroController>getController();
            rc.setLogeado(); 
            rc.setUser(userRecibido);
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void registroveh(MouseEvent event) 
    {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Intermediario.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            IntermediarioController rc = fxmlLoader.<IntermediarioController>getController();
            rc.setUser(userRecibido);        
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void aceptaofer(MouseEvent event) 
    {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AceptarOferta.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            AceptarOfertaController rc = fxmlLoader.<AceptarOfertaController>getController();
            rc.setUser(userRecibido);
            
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    
    }
    
    @FXML
    private void registrocomp(MouseEvent event) 
    {
         
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Registro.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            RegistroController rc = fxmlLoader.<RegistroController>getController();
            rc.setLogeado();    
            rc.mostrarBotones();
            rc.setUser(userRecibido);
            
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void hacerofer(MouseEvent event) 
    {
         
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Ofertar.fxml"));
            Parent root = fxmlLoader.load();

            App.setParentRoot(root);
            OfertarController rc = fxmlLoader.<OfertarController>getController();
            rc.setUser(userRecibido);
            
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void abrirperfil(MouseEvent event) 
    {
        
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Perfil.fxml"));
            Parent root = fxmlLoader.load();
            App.setParentRoot(root);
            PerfilController pc = fxmlLoader.<PerfilController>getController();
            pc.setUser(this.userRecibido);        
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void volverLogin(MouseEvent event) 
    {
        try {
            App.setRoot("Login");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}

