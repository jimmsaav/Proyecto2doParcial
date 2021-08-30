module ec.edu.espol.proyecto2doparcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyecto2doparcial to javafx.fxml;
    exports ec.edu.espol.proyecto2doparcial;
}
