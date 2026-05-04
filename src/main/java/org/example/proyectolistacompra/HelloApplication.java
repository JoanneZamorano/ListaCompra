package org.example.proyectolistacompra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("APP: Lista de la compra!");
        stage.setScene(scene);
        //Carga el archivo de estilos CSS:
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}