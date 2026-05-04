package org.example.proyectolistacompra;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Producto {
    private final StringProperty nombre;
    private final BooleanProperty comprado;

    public Producto(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
        this.comprado = new SimpleBooleanProperty(false);
    }

    public String getNombre() {
        return nombre.get();
    }
    public StringProperty nombreProperty() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }



    public boolean isComprado() {
        return comprado.get();
    }
    public BooleanProperty compradoProperty() {
        return comprado;
    }
    public void setComprado(boolean comprado) {
        this.comprado.set(comprado);
    }
}