module ec.edu.espol.proyecto2doparcial {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyecto2doparcial to javafx.fxml;
    exports ec.edu.espol.proyecto2doparcial;    
    requires java.mail;
    requires activation;
    requires java.base;
}
