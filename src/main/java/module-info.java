module org.example.proyectolistacompra {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proyectolistacompra to javafx.fxml;
    exports org.example.proyectolistacompra;
}