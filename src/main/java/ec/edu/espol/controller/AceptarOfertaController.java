/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.User;
import ec.edu.espol.proyecto2doparcial.App;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AceptarOfertaController implements Initializable {

    private ArrayList<Oferta> ofertas = new ArrayList<>();
    private User user;
    
    @FXML
    private ScrollPane scrollpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.ofertas =Util.readOfertasFile();
        scrollpane.setContent(null);
        ofertas.sort(Oferta:: compareTo);
        VBox vbox= new VBox();
        vbox.setPadding(new Insets(45, 0, 0, 5));
        scrollpane.setContent(vbox);
        scrollpane.setMinWidth(scrollpane.getMinWidth() + 50);
        Window owner = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
        owner.setHeight(scrollpane.getMinWidth() + 50);
        
        for(Oferta o:ofertas){
                HBox hbox = new HBox();
                hbox.setSpacing(25);

                VBox minibox = new VBox();
                
                File imgfile = new File("images/"+o.getPlaca()+".jpg");
                Image foto= new Image("file:" + imgfile.getAbsolutePath());
                
                ImageView im= new ImageView(foto);
                im.setFitWidth(140);
                im.setFitHeight(100);
                
                Text comprador= new Text("Usuario:   " + o.getCorreo());
                Text precio= new Text("Precio:  $"+o.getPrecio());
                Text placa= new Text("Placa:   " + o.getPlaca());
                minibox.getChildren().add(comprador);
                minibox.getChildren().add(precio);
                minibox.getChildren().add(placa);
                
                Button boton= new Button();
                boton.setText("Aceptar");
                boton.setOnMouseClicked((MouseEvent evento)->{
                    try 
                    {
                        Oferta.removerOferta(o);
                    } 
                    catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try 
                    {
                        Util.enviarCorreo(user.getCorreo(),o.getCorreo());
                    } 
                    catch (MessagingException ex) 
                    {
                        Util.alerta("ERROR DE CORREO",ex.getMessage());
                    }
                    Alert a = new Alert(Alert.AlertType.INFORMATION,"Mensaje enviado exitosamente");
                    a.show();
                    this.regresar(evento);
                });
                hbox.getChildren().add(im);
                hbox.getChildren().add(minibox);
                hbox.getChildren().add(boton);
                vbox.getChildren().add(hbox);
        }
    }    

    public void setUser(User usr)
    {
        this.user = usr;
    }
    @FXML
    private void regresar(MouseEvent event)
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
