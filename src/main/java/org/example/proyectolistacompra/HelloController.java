package org.example.proyectolistacompra;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    // @FXML indica que estas variables están vinculadas a elementos del archivo .fxml
    @FXML
    private TextField txtProducto; //cuadro de texto para escribir el producto

    @FXML
    private Button btnAñadir; //botón +

    @FXML
    private ListView<Producto> listViewProductos; //lista visual que muestra los productos

    @FXML
    private Button btnVaciar; //botón "Eliminar toda la lista"

    @FXML
    private javafx.scene.control.Label lblTotal; //texto que muestra el total productos

    /**
     * ObservableList es una lista especial de JavaFX - Si se añade o se quita algo la interfaz se actualiza sola
     */
    private ObservableList<Producto> listaDatos = FXCollections.observableArrayList();


    /**
     * El método initialize() se ejecuta automáticamente cuando se carga la ventana.
     */
    @FXML
    public void initialize() {
        listViewProductos.setItems(listaDatos); // vincula la lista de datos al componente visual

        // Listener:cada vez que la lista cambie (añadir/borrar), actualiza el contador
        listaDatos.addListener((javafx.collections.ListChangeListener<Producto>) c -> {
            lblTotal.setText("Productos: " + listaDatos.size());
        });

        /**
         * setCellFactory define como se ve cada fila- por defecto solo se vetexto
         * aquí creo el diseño con CheckBox y el botón de basura
         */
        listViewProductos.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Producto producto, boolean empty) {
                super.updateItem(producto, empty);

                // si la celda está vacía-> no dibuja nada
                if (empty || producto == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    //crea un contenedor horizontal para los elementos de la fila
                    javafx.scene.layout.HBox contenedor = new javafx.scene.layout.HBox(10);
                    contenedor.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

                    javafx.scene.control.CheckBox check = new javafx.scene.control.CheckBox();
                    javafx.scene.control.Label nombreLabel = new javafx.scene.control.Label(producto.getNombre());
                    javafx.scene.control.Button btnEliminar = new javafx.scene.control.Button("🗑");

                    //hace que el nombre ocupe el espacio central para empujar el botón a la derecha
                    javafx.scene.layout.HBox.setHgrow(nombreLabel, javafx.scene.layout.Priority.ALWAYS);
                    nombreLabel.setMaxWidth(Double.MAX_VALUE);

                    // sincroniza el estado del CheckBox con el objeto Producto
                    check.setSelected(producto.isComprado());
                    actualizarEstilo(nombreLabel, producto.isComprado());

                    // EVENTO: al marcar/desmarcar -> actualiza el modelo y el estilo
                    check.setOnAction(e -> {
                        producto.setComprado(check.isSelected());
                        actualizarEstilo(nombreLabel, producto.isComprado());
                    });

                    // EVENTO: Elimina SOLO este producto de la lista
                    btnEliminar.setOnAction(e -> listaDatos.remove(producto));

                    // Añade los elementos al contenedor y el contenedor a la celda
                    contenedor.getChildren().addAll(check, nombreLabel, btnEliminar);
                    setGraphic(contenedor);
                }
            }

            /**
             * cambia el aspecto visual del texto (tachar/gris) usando clases CSS.
             */
            private void actualizarEstilo(javafx.scene.control.Label label, boolean tachado) {
                if (tachado) {
                    label.getStyleClass().add("producto-comprado");
                } else {
                    label.getStyleClass().remove("producto-comprado");
                }
            }
        });
    }

    /**
     * Se ejecuta al pulsar el botón "+" o la tecla Enter.
     */
    @FXML
    protected void onAñadirClick() {
        String nombre = txtProducto.getText().trim(); //obtiene el texto sin espacios extras
        if (!nombre.isEmpty()) {
            listaDatos.add(new Producto(nombre)); //añade el nuevo producto a la lista observable
            txtProducto.clear(); //limpia el campo después de añadir
        }
    }

    /**
     * Se ejecuta al pulsar "Eliminar toda la lista".
     */
    @FXML
    protected void onVaciarClick() {
        listaDatos.clear(); //borra todos los elementos de la lista
    }
}