package com.example.praktikum_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        HelloController helloController = fxmlLoader.getController();

        new Thread(
                helloController.loadListKategoriTiket()
        ).start();

        new Thread(
                helloController.loadListJenisKelamin()
        ).start();

        helloController.setTabelPesertaColumn();
        new Thread(helloController.loadListUsers()).start();

        stage.setTitle("Formulir Pendaftaran Konser");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}