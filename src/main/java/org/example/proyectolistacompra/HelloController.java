package org.example.proyectolistacompra;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtProducto;

    @FXML
    private Button btnAñadir;

    @FXML
    private ListView<Producto> listViewProductos;

    @FXML
    private Button btnVaciar;

    // Esta es la lista especial de JavaFX que actualiza la interfaz sola
    private ObservableList<Producto> listaDatos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Conectamos la lista de datos con el componente visual
        listViewProductos.setItems(listaDatos);

        // Aquí configuraremos más adelante cómo se ve cada fila (celdas personalizadas)
    }

    @FXML
    protected void onAñadirClick() {
        String nombre = txtProducto.getText();
        if (!nombre.isEmpty()) {
            listaDatos.add(new Producto(nombre));
            txtProducto.clear(); // Limpiamos el campo después de añadir
        }
    }

    @FXML
    protected void onVaciarClick() {
        listaDatos.clear();
    }
}