/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.User;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.proyecto2doparcial.App;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller class
 *
 * @author user
 */
public class OfertarController implements Initializable {

    private User user;
    @FXML
    private ScrollPane scrollpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ArrayList <String> tipos = new ArrayList<> ();
        tipos.add("Todos");
        tipos.add("Moto");
        tipos.add("Auto");
        tipos.add("Camioneta");
        double wrappingW = 100;
        VBox vbox = new VBox();
        scrollpane.setContent(vbox);
        vbox.setAlignment(Pos.CENTER);
        Button buscar = new Button("Buscar");
        
        HBox hbox1 = new HBox();
        Text tipot= new Text("Tipo de vehículo:");
        ComboBox tipo = new ComboBox();
        tipo.setItems(FXCollections.observableArrayList(tipos));
        hbox1.getChildren().add(tipot);
        hbox1.getChildren().add(tipo);
        tipot.setWrappingWidth(wrappingW);
        
        HBox hbox2 = new HBox();
        Text recorridot= new Text("Recorrido Maximo:   ");
        recorridot.setTextAlignment(TextAlignment.RIGHT);
        TextField recorrido = new TextField();
        hbox2.getChildren().add(recorridot);
        hbox2.getChildren().add(recorrido);
        recorridot.setWrappingWidth(wrappingW);

        HBox hbox3 = new HBox();
        Text añot= new Text("Año Mínimo:   ");    
        añot.setTextAlignment(TextAlignment.RIGHT);
        TextField año = new TextField();
        hbox3.getChildren().add(añot);
        hbox3.getChildren().add(año);
        añot.setWrappingWidth(wrappingW);
        
        HBox hbox4 = new HBox();
        Text preciot= new Text("Precio máximo:   ");
        preciot.setTextAlignment(TextAlignment.RIGHT);
        TextField precio = new TextField();
        hbox4.getChildren().add(preciot);
        hbox4.getChildren().add(precio);
        preciot.setWrappingWidth(wrappingW);
        
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(buscar);
        
        buscar.setOnMouseClicked((MouseEvent evento)->{
            try{
                double recorridop= Double.parseDouble(recorrido.getText());
                int añop= Integer.parseInt(año.getText());
                double preciop= Double.parseDouble(precio.getText());
                ArrayList<Vehiculo> vehiculos = new ArrayList <>();
                String item = (String)tipo.getValue();
                if (item.equals("Todos"))
                {
                    for(Vehiculo x : Util.readVehiclesFile("autos.ser"))
                    {
                        vehiculos.add(x);
                    }
                    for(Vehiculo x : Util.readVehiclesFile("camionetas.ser"))
                    {
                        vehiculos.add(x);
                    }
                    for(Vehiculo x : Util.readVehiclesFile("motos.ser"))
                    {
                        vehiculos.add(x);
                    }
                }
                    
                if(item.equals("Moto"))
                    vehiculos= Util.readVehiclesFile("motos.ser");
                if(item.equals("Auto"))
                    vehiculos= Util.readVehiclesFile("autos.ser");
                if(item.equals("Camioneta"))
                    vehiculos= Util.readVehiclesFile("camionetas.ser");
                
                ArrayList<Vehiculo> vehiculosFilter = new ArrayList<>();
                for(Vehiculo v:vehiculos)
                {
                    if(v.getRecorrido() < recorridop)
                    {
                       if(v.getAño() > añop)
                       {
                           if(v.getPrecio() < preciop)
                           {
                               vehiculosFilter.add(v);
                           }
                       }
                    }
                }
            vehiculos = vehiculosFilter;
                
            ///////////////////////////////////////////////////////////////////////////////
            vbox.getChildren().clear();
            for(Vehiculo v:vehiculos){
                HBox hbox = new HBox();
                hbox.setSpacing(25);
                VBox minibox = new VBox();
                
                File imgfile = new File("images/"+v.getPlaca()+".jpg");
                Image foto= new Image("file:" + imgfile.getAbsolutePath());
                
                
                ImageView im= new ImageView(foto);
                im.setFitWidth(140);
                im.setFitHeight(100);
                
                Text precios= new Text("Precio:  $"+v.getPrecio());
                minibox.getChildren().add(precios);
                Text años= new Text("Año: "+v.getAño());
                minibox.getChildren().add(años);
                Text recorridos= new Text("Recorrido:  " + v.getRecorrido()+"km");
                minibox.getChildren().add(recorridos);
                minibox.setAlignment(Pos.CENTER);
                
                Button boton= new Button();
                boton.setText("Ofertar");
                boton.setOnMouseClicked((MouseEvent event)->{
                    vbox.getChildren().clear();
                    vbox.setAlignment(Pos.CENTER);
                    Button botono = new Button("Ofertar");
                    vbox.getChildren().add(im);
                    Text placav= new Text("Placa: "+v.getPlaca());
                    Text marcav= new Text("Marca: "+v.getMarca());
                    Text combustiblev= new Text("Combustible: "+v.getCombustible());
                    Text colorv= new Text("Color: "+v.getColor());
                    Text modelov= new Text("Modelo: "+v.getModelo());
                    Text motorv= new Text("Motor :"+v.getMotor());
                    Text preciov= new Text("Precio: $"+v.getPrecio());
                    Text añov= new Text("Año: "+v.getAño());
                    Text recorridov= new Text("Recorrido: "+v.getRecorrido()+"km");   
                    HBox hboxn= new HBox();
                    Text precioOfertadot= new Text("Precio a ofertar:  ");
                    TextField precioOfertado = new TextField();
                    hboxn.getChildren().add(precioOfertadot);
                    hboxn.getChildren().add(precioOfertado);
                    vbox.getChildren().add(placav);
                    vbox.getChildren().add(marcav);
                    vbox.getChildren().add(combustiblev);
                    vbox.getChildren().add(colorv);
                    vbox.getChildren().add(modelov);
                    vbox.getChildren().add(motorv);
                    vbox.getChildren().add(preciov);
                    vbox.getChildren().add(añov);
                    vbox.getChildren().add(recorridov);
                    vbox.getChildren().add(hboxn);
                    vbox.getChildren().add(botono);
                    botono.setOnMouseClicked((MouseEvent ofertar)->{
                        try{
                            double precioOferta = Double.parseDouble(precioOfertado.getText()) ; 
                            Oferta oferta = new Oferta(user.getCorreo(),precioOferta,v.getPlaca());
                            try {
                                oferta.saveFile();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                             Alert a = new Alert(Alert.AlertType.INFORMATION,"Registro de oferta exitoso");
                            a.show();
                            this.volver(event);
                            }catch(NumberFormatException e){
                                 Util.alerta("ERROR", "Año, recorrido y precio solo permite numeros.");} 
                    });
                });
                
                vbox.setPadding(new Insets(45, 0, 0, 25));
                hbox.getChildren().add(im);
                hbox.getChildren().add(minibox);
                hbox.getChildren().add(boton);
                vbox.getChildren().add(hbox);
        }
                }catch(NumberFormatException e){
                Util.alerta("ERROR", "Año, recorrido y precio solo permite numeros.");
            }
        });
        
    }    

    public void setUser(User usr)
    {
        this.user = usr;
    }
    
    @FXML
    private void volver(MouseEvent event) 
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
