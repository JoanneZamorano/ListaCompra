package org.example.proyectolistacompra;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Clase que representa un producto en la lista de la compra
 * Se utilizan Properties de JavaFX para permitir que la interfaz gráfica "escuche" y reaccione a los cambios en los datos automáticamente.
 */
public class Producto {
    private final StringProperty nombre; // permite que el nombre sea observable por los controles de la UI
    private final BooleanProperty comprado; //para manejar el estado de CheckBoxes o textos tachados

    /**
     * Constructor para crear un nuevo producto
     * @param nombre
     */
    public Producto(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
        this.comprado = new SimpleBooleanProperty(false); //por defecto un producto nuevo no está comprado
    }

    // devuelve el valor real(String)
    public String getNombre() {
        return nombre.get();
    }
    //devuelve el objeto Property (necesario en tablas o listas)
    public StringProperty nombreProperty() {
        return nombre;
    }

    // cambia el valor del nombre (no lo he usado)
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }


    //devuelve si está marcado como comprado
    public boolean isComprado() {
        return comprado.get();
    }
    // devuelve el objeto Property para observar cambios en el estado de compra
    public BooleanProperty compradoProperty() {
        return comprado;
    }
    // cambia el estado de compra (CheckBox)
    public void setComprado(boolean comprado) {
        this.comprado.set(comprado);
    }

    /**
     * Método toString sobrescrito.
     * es lo que utiliza el ListView por defecto para saber qué texto pintar en la celda
     * (si no usa una CellFactory personalizada)
     */
    @Override
    public String toString() {
        return getNombre();
    }
}

