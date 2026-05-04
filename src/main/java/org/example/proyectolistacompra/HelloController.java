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

    @FXML
    private javafx.scene.control.Label lblTotal;

    // Esta es la lista especial de JavaFX que actualiza la interfaz sola
    private ObservableList<Producto> listaDatos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listViewProductos.setItems(listaDatos);
        // Esto hace que el label se actualice automáticamente cada vez que la lista cambie
        listaDatos.addListener((javafx.collections.ListChangeListener<Producto>) c -> {
            lblTotal.setText("Productos: " + listaDatos.size());
        });

        // Definimos cómo se dibuja cada fila de la lista
        listViewProductos.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Producto producto, boolean empty) {
                super.updateItem(producto, empty);

                if (empty || producto == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    // Creamos los componentes de la fila
                    javafx.scene.layout.HBox contenedor = new javafx.scene.layout.HBox(10);
                    contenedor.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

                    javafx.scene.control.CheckBox check = new javafx.scene.control.CheckBox();
                    javafx.scene.control.Label nombreLabel = new javafx.scene.control.Label(producto.getNombre());
                    javafx.scene.control.Button btnEliminar = new javafx.scene.control.Button("🗑");

                    // Empujamos el botón a la derecha
                    javafx.scene.layout.HBox.setHgrow(nombreLabel, javafx.scene.layout.Priority.ALWAYS);
                    nombreLabel.setMaxWidth(Double.MAX_VALUE);

                    // Estado inicial (si ya estaba comprado)
                    check.setSelected(producto.isComprado());
                    actualizarEstilo(nombreLabel, producto.isComprado());

                    // Evento: Tachar al marcar
                    check.setOnAction(e -> {
                        producto.setComprado(check.isSelected());
                        actualizarEstilo(nombreLabel, producto.isComprado());
                    });

                    // Evento: Eliminar este producto
                    btnEliminar.setOnAction(e -> listaDatos.remove(producto));

                    contenedor.getChildren().addAll(check, nombreLabel, btnEliminar);
                    setGraphic(contenedor);
                }
            }

            // Función auxiliar para el estilo visual
            private void actualizarEstilo(javafx.scene.control.Label label, boolean tachado) {
                if (tachado) {
                    // Añade la clase de CSS para tachar
                    label.getStyleClass().add("producto-comprado");
                } else {
                    // Quita la clase para que vuelva a la normalidad
                    label.getStyleClass().remove("producto-comprado");
                }
            }
        });
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