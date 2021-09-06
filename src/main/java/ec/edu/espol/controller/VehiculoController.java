/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Auto;
import ec.edu.espol.model.Camioneta;
import ec.edu.espol.model.Moto;
import ec.edu.espol.model.User;
import ec.edu.espol.proyecto2doparcial.App;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author user
 */
public class VehiculoController implements Initializable 
{

    private String vehactual;
    private String imgpathactual;
    @FXML
    private TextField placatf;
    @FXML
    private TextField marcatf;
    @FXML
    private TextField modelotf;
    @FXML
    private TextField motortf;
    @FXML
    private TextField añotf;
    @FXML
    private TextField recorridotf;
    @FXML
    private TextField colortf;
    @FXML
    private TextField combustibletf;
    @FXML
    private TextField preciotf;
    @FXML
    private TextField vidriostf;
    @FXML
    private TextField transmisiontf;
    @FXML
    private TextField tracciontf;
    @FXML
    private TextField pathtf;
    
    private User user;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        pathtf.setEditable(false);
        // TODO
    }    

    @FXML
    private void subirfoto(MouseEvent event) 
    {
        FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Buscar Imagen");

                // Agregar filtros para facilitar la busqueda
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Images", "*.*"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );

                Window owner = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
                File imgFile = fileChooser.showOpenDialog(owner);
                

                // Mostar la imagen
                if (imgFile != null ) 
                {
                    Image img = new Image("file:" + imgFile.getAbsolutePath());
                    imgpathactual = img.getUrl().substring(5,img.getUrl().length());
                    pathtf.setText(imgpathactual);
                    
                }
                else
                {
                    Util.alerta("ERROR", "FOTO INEXISTENTE");
                }
           
    }

    @FXML
    private void registrarveh(MouseEvent event)
    {
        if(!marcatf.getText().isEmpty() && !modelotf.getText().isEmpty() &&
                   !motortf.getText().isEmpty() && !añotf.getText().isEmpty() &&
                   !recorridotf.getText().isEmpty()&&!combustibletf.getText().isEmpty()&&
                   !colortf.getText().isEmpty() && !preciotf.getText().isEmpty() && !vidriostf.getText().isEmpty()&&
                   !transmisiontf.getText().isEmpty()  && !placatf.getText().isEmpty() && 
                    !pathtf.getText().equals("") && vehactual.equals("auto"))
                {
                    try
                    {
                        int añov= Integer.parseInt(añotf.getText());
                        double recorridov= Double.parseDouble(recorridotf.getText());
                        double preciov=Double.parseDouble(preciotf.getText());
                        Auto autoR= new Auto(placatf.getText(), marcatf.getText(), 
                                modelotf.getText(),motortf.getText(),añov,recorridov,colortf.getText(),
                                        combustibletf.getText(), preciov, vidriostf.getText(), transmisiontf.getText());


                        copiar(imgpathactual, "images/"+placatf.getText() + ".jpg");//);
                        autoR.saveFile("autos.ser");
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Creado exitosamente");
                        a.show();
                        this.volver(event);
                    }
                    catch(NumberFormatException e)
                    {
                        Util.alerta("ERROR", "Año, kilometraje y precio solo admite numeros");
                    }
                    catch(Exception e)
                    {
                         Util.alerta("Error 404", e.getMessage());
                    }
                }
        else if(!marcatf.getText().isEmpty() && !modelotf.getText().isEmpty() &&
                   !motortf.getText().isEmpty() && !añotf.getText().isEmpty() &&
                   !recorridotf.getText().isEmpty()&&!combustibletf.getText().isEmpty()&&
                   !colortf.getText().isEmpty() && !preciotf.getText().isEmpty() && !vidriostf.getText().isEmpty()&&
                   !transmisiontf.getText().isEmpty()  && !placatf.getText().isEmpty() && 
                    !pathtf.getText().equals("") && !tracciontf.getText().isEmpty() && vehactual.equals("camioneta"))
                {
                    try
                    {
                        int añov= Integer.parseInt(añotf.getText());
                        double recorridov= Double.parseDouble(recorridotf.getText());
                        double preciov=Double.parseDouble(preciotf.getText());
                        Camioneta cam= new Camioneta(placatf.getText(), marcatf.getText(), 
                                modelotf.getText(),motortf.getText(),añov,recorridov,colortf.getText(),
                                combustibletf.getText(), preciov, vidriostf.getText(), 
                                transmisiontf.getText(), tracciontf.getText());


                        copiar(imgpathactual, "images/"+placatf.getText() + ".jpg");//);
                        cam.saveFile("camionetas.ser");
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Creado exitosamente");
                        a.show();
                        this.volver(event);
                    }
                    catch(NumberFormatException e)
                    {
                        Util.alerta("ERROR", "Año, kilometraje y precio solo admite numeros");
                    }
                    catch(Exception e)
                    {
                         Util.alerta("Error 404", e.getMessage());
                    }
                }
        else if(!marcatf.getText().isEmpty() && !modelotf.getText().isEmpty() &&
                   !motortf.getText().isEmpty() && !añotf.getText().isEmpty() &&
                   !recorridotf.getText().isEmpty()&&!combustibletf.getText().isEmpty()&&
                   !colortf.getText().isEmpty() && !preciotf.getText().isEmpty()  && !placatf.getText().isEmpty() && 
                    !pathtf.getText().equals("") && vehactual.equals("moto"))
                {
                    try
                    {
                        int añov= Integer.parseInt(añotf.getText());
                        double recorridov= Double.parseDouble(recorridotf.getText());
                        double preciov=Double.parseDouble(preciotf.getText());
                        Moto autoR= new Moto(placatf.getText(), marcatf.getText(), 
                                modelotf.getText(),motortf.getText(),añov,recorridov,colortf.getText(),
                                        combustibletf.getText(), preciov);


                        copiar(imgpathactual, "images/"+placatf.getText() + ".jpg");//);
                        autoR.saveFile("motos.ser");
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Creado exitosamente");
                        a.show();
                        this.volver(event);
                    
                    }
                    catch(NumberFormatException e)
                    {
                        Util.alerta("ERROR", "Año, kilometraje y precio solo admite numeros");
                    }
                    catch(Exception e)
                    {
                         Util.alerta("Error 404", e.getMessage());
                    }
                }
        else
        {
            Util.alerta("ERROR", "DEBE LLENAR TODOS LOS CAMPOS");
        }

    }

    public void setAuto()
    {
        vehactual = "auto";
        vidriostf.setVisible(true);
        transmisiontf.setVisible(true);
        tracciontf.setVisible(false);
    }
    public void setCam()
    {
        vehactual = "camioneta";
        vidriostf.setVisible(true);
        transmisiontf.setVisible(true);
        tracciontf.setVisible(true);
    }
    public void setMoto()
    {
        vehactual = "moto";
        vidriostf.setVisible(false);
        transmisiontf.setVisible(false);
        tracciontf.setVisible(false);
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
    
    public static void copiar(String input, String output) 
    {

        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(input);
            out = new FileOutputStream(output);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;

            // write the output file (You have now copied the file)
            out.flush();
            out.close();
            out = null;

        } catch (FileNotFoundException fnfe1) {
            System.out.println(fnfe1.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
